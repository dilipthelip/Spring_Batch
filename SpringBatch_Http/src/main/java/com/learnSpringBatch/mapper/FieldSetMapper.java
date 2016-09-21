package com.learnSpringBatch.mapper;

import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.learnSpringBatch.model.Product;

public class FieldSetMapper implements org.springframework.batch.item.file.mapping.FieldSetMapper<Product>{

	public Product mapFieldSet(FieldSet fieldSet) throws BindException {
		// TODO Auto-generated method stub
		  Product product = new Product();
		    product.setId(fieldSet.readString("PRODUCT_ID"));
		    product.setName(fieldSet.readString("NAME"));
		    product.setDescription(fieldSet.readString("DESCRIPTION"));
		    product.setPrice(fieldSet.readBigDecimal("PRICE"));
		    
		    System.out.println("The Product object in Reader : "+ product);
		    
		    return product;

	}
	
	

	
}
