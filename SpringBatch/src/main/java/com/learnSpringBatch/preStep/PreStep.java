package com.learnSpringBatch.preStep;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class PreStep implements Tasklet {

	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside Execute of PreStep : ");
		return RepeatStatus.FINISHED;
	}

}
