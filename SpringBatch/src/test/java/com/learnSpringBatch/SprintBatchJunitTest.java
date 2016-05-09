/**
 * 
 */
package com.learnSpringBatch;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
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
//@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/configs/job-configuration.xml"})
//@PropertySource("classpath:application.properties")
public class SprintBatchJunitTest extends TestCase {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;
	
	@Value("${test.reader}")
	private String env;
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Before
	public void setUp(){
		System.out.println("Inside Set up");
	}

	@Test
	public void importProducts(){

		//System.out.println("Inside Import Products");
		try {
			//String str = env.getProperty("test.reader");
			System.out.println("env : "+ env);
			jobLauncher.run(job, new JobParametersBuilder().addString("inputFile", "/InputFiles/Product_Samples.txt").addLong("timestamp", System.currentTimeMillis())
					.toJobParameters());
			
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
