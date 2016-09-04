package com.learnSpringBatch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class ProductStepListener implements StepExecutionListener {

	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		System.out.println("Entering the step");
		
	}

	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		
		if(stepExecution.getStatus() == BatchStatus.COMPLETED){
			System.out.println("Step executed successfully");
		}
		return null;
	}

}
