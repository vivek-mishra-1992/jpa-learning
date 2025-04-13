package com.example.jpalearning.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.jpalearning.entity.Product;

public interface ProductRepositery extends CrudRepository<Product, Integer>{
	public List<Product> findAll();
	public List<Product> findByPrName(String prName);

}
