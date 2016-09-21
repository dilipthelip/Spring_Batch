package com.learnSpringBatch.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class JobLauncherController {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private JobRegistry jobRegistry;
	
	@RequestMapping(value="jobLauncher", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void launch(@RequestParam String job, HttpServletRequest request){
			
				System.out.println("Inside launch");
			JobParametersBuilder builder = extractParameters(request);
			try {
				JobExecution execution = jobLauncher.run(jobRegistry.getJob(job), builder.toJobParameters());
				
				System.out.println("Execution : "+ execution.getExitStatus());
			} catch (JobExecutionAlreadyRunningException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JobRestartException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JobInstanceAlreadyCompleteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JobParametersInvalidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchJobException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/**
	 * This method is used to extract the parameters.
	 * @param request
	 * @return
	 */
	private JobParametersBuilder extractParameters(HttpServletRequest request) {
		JobParametersBuilder builder = new JobParametersBuilder();
		Enumeration<String> params= request.getParameterNames();
		while(params.hasMoreElements()){
			String paramName= params.nextElement();
			if(!"job".equals(paramName)){
				builder.addString(paramName, request.getParameter(paramName));
			}
		}
		builder.addLong("timestamp", System.currentTimeMillis());
		return builder;
	}
}
