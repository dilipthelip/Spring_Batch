package com.learnSpringBatch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.learnSpringBatch.model.Product;

public class ProductProcessor implements ItemProcessor<Product, Product> {

	public Product process(Product item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

}
