package com.example.jpalearning.dao;

import java.util.List;
import java.util.Optional;

import com.example.jpalearning.entity.Product;

public interface ProductDao {

	public Product saveProduct(Product pr);
	
	public List<Product> fetchAllProdcut();
	
	public Optional<Product>  getProdById(Integer id);
	
	public List<Product> getProdByName(String name);
	
}
