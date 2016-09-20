package com.learnSpringBatch.listener;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class ProductChunkListener implements ChunkListener {

	public void beforeChunk(ChunkContext context) {
		// TODO Auto-generated method stub
		System.out.println("Before chunk");
	}

	public void afterChunk(ChunkContext context) {
		// TODO Auto-generated method stub
		System.out.println("After chunk");
		
	}

	public void afterChunkError(ChunkContext context) {
		// TODO Auto-generated method stub
		
	}

}
