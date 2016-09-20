/**
 * 
 */
package com.learnSpringBatch;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

/**
 * @author Z001QGD
 *
 */
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/configs/job-configuration.xml"})
//@PropertySource("classpath:application.properties")
public class SpringBatchJunitTest extends TestCase {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@Before
	public void setUp(){
		System.out.println("Inside Set up");
	}

	@Test
	public void importProducts(){

		//System.out.println("Inside Import Products");
		try {
			//String str = env.getProperty("test.reader");
			//System.out.println("env : "+ env);
			
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
