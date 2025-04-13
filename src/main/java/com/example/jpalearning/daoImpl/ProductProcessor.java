package com.example.jpalearning.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductProcessor {
	@Autowired
	ProductLogicBuilder productLogicBuilder;

	public String processProductData(String prdData) throws Exception {
		String prodName = productLogicBuilder.processData(prdData);
		validate(prdData);
		if (prodName.equalsIgnoreCase("Samsung")) {
			System.out.println("Latest Product found");
		} else if (prodName.equalsIgnoreCase("Nokia")) {
			System.out.println("Old Product found");
		} else {
			System.out.println("Can't use This product in our organization");
		}
		return prodName;
	}
	public void validate(String prdData) throws Exception {
		productLogicBuilder.validate(prdData);
		
	}
	public Integer add(int a, int b) throws Exception {
		if (a < 0 || b < 0) {
			throw new Exception("Provided input is less than 0, Hence not eligible to add");
		}
		if (a > 1000 || b > 1000) {
			throw new Exception("Provided input is greater than 1000, hence not eligible to add");
		}
		return a + b;
	}
}
