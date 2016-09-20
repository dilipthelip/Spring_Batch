package com.learnSpringBatch.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;

public class SpringSchedulingLauncher {

	@Autowired
	private Job job;

	@Autowired
	private JobLauncher jobLauncher;

	public void importProducts(){

		//System.out.println("Inside Import Products");
		try {

			JobExecution execution = jobLauncher.run(job, new JobParametersBuilder().addLong("timestamp", System.currentTimeMillis()).addString("inputFile", "/Dilip/Study/Spring_Batch/workspace/SpringBatch/src/main/resources/Product_Samples.txt")
					.toJobParameters());

			System.out.println("Execution Status : " +  execution.getExitStatus() + execution.getExitStatus().getExitCode());

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
		}


	}
}
