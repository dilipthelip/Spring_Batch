package com.learnSpringBatch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

public class ProductListerAnnotation {
	
	@BeforeJob
	  public void executeBeforeJob(JobExecution jobExecution) {
	    //Notifying when job starts
	  }

	  @AfterJob
	  public void executeAfterJob(JobExecution jobExecution) {
	    if (jobExecution.getStatus()==BatchStatus.COMPLETED) {
	       //Notifying when job successfully ends
	    	System.out.println("Batch Completed Successfully in annotation");
	    } else if (jobExecution.getStatus()==BatchStatus.FAILED) {
	      //Notifying when job ends with failure
	    	System.out.println("Batch Failed with some errors in annotation");
	    }
	  }

}
