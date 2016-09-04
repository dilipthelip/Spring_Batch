package com.learnSpringBatch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;


public class ProductListener implements JobExecutionListener {

	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		
	}

	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		
		if (jobExecution.getStatus()==BatchStatus.COMPLETED) {
		      // Called when job ends successfully
				System.out.println("Batch Completed Successfully");
		    } else if (jobExecution.getStatus()==BatchStatus.FAILED) {
		      // Called when job ends in failure
		    	System.out.println("Batch Failed with some errors Successfully");
		    	
		    }
	}

}
