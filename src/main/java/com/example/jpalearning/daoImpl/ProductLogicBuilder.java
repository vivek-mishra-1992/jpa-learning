package com.example.jpalearning.daoImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductLogicBuilder {
	public String processData(String prdData) throws Exception {
		validate(prdData);
		if (prdData.contains("-")) {
			String[] prdSplit = prdData.split("-");
			for (String val : prdSplit) {
				if (val.equalsIgnoreCase("Samsung")) {
					return val;
				}

			}
		}
		return prdData;
	}

	public void validate(String prdData) throws Exception {
		if(StringUtils.isEmpty(prdData)){
			throw new Exception("Product can naot be null or empty");
		}
		
	}
	
}
