package com.learnSpringBatch.writer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.learnSpringBatch.model.Product;

public class ProductWriter implements ItemWriter<Product>{

	private JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_PRODUCT = " Insert into product (id,name,description,price)";

	public ProductWriter(DataSource dataSource){
		this.jdbcTemplate =new JdbcTemplate(dataSource);
	}

	public void write(List<? extends Product> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Call to Product Writer");
		for(Product product : items)
			System.out.println("Product in Writer :" + product);

	}

}
