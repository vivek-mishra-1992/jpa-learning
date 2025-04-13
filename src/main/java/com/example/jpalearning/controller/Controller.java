package com.example.jpalearning.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpalearning.dao.ProductDao;
import com.example.jpalearning.entity.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product")
@Api(value = "Product Controller", tags = {"This is the Product controller, which exposes APIs for Product management."})
public class Controller {
	@Autowired
	private ProductDao productDao;

	@Autowired
	public Controller(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	
	@PostMapping(value ="/saveProduct",produces = {"application/json"},consumes = {"application/json"})
	@ApiOperation(value = "Save a product", notes = "This endpoint saves a new product in the system.")
	public ResponseEntity<Product> saveProduct(@RequestBody Product pr){
		pr = productDao.saveProduct(pr);
		return new ResponseEntity<>(pr,HttpStatus.CREATED);
	}
	
	@GetMapping(value ="/fetchAllProduct")
	@ApiOperation(value = "Fetch all products", notes = "This endpoint retrieves all products from the system.")
	public ResponseEntity<List<Product>> fetchAllProdcut(){
		List<Product> prList = productDao.fetchAllProdcut();
		return new ResponseEntity<>(prList,HttpStatus.OK);
	}
	
	@GetMapping(value ="/getProductByName/{id}")
	@ApiOperation(value = "Get product by ID", notes = "This endpoint retrieves a product by its ID.")
	public ResponseEntity<Optional<Product>> getProdById(@PathVariable(value ="id") Integer prName){
		Optional<Product> pr = productDao.getProdById(prName);
		return new ResponseEntity<>(pr,HttpStatus.OK);
	}
	
	@GetMapping(value ="/getAllProductByName/{name}")
	@ApiOperation(value = "Get products by name", notes = "This endpoint retrieves products by their name.")
	public ResponseEntity<List<Product>> getProdByName(@PathVariable(value ="name") String prName){
		List<Product> pr = productDao.getProdByName(prName);
		return new ResponseEntity<>(pr,HttpStatus.OK);
	}
	
	
}
