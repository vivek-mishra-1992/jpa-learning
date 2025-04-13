package com.example.jpalearning.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.jpalearning.dao.ProductDao;
import com.example.jpalearning.entity.Product;
public class TestController {
	@InjectMocks
	private Controller controller;
	@Mock
	private ProductDao productDao;
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFetchAllProduct() {
		Mockito.when(productDao.fetchAllProdcut()).thenReturn(productResponse());
		ResponseEntity<List<Product>> fetchAllProdcut = controller.fetchAllProdcut();
		assertEquals("Tata", fetchAllProdcut.getBody().get(0).getPrName());
		assertEquals(5000.0, fetchAllProdcut.getBody().get(0).getPrPrice());
	}
	@Test
	void testgetProductById() {
		Mockito.when(productDao.getProdById(123)).thenReturn(productByIdResponse());
		ResponseEntity<Optional<Product>> fetchAllProdcut = controller.getProdById(123);
		assertEquals(512, fetchAllProdcut.getBody().get().getId());
	}
	@Test
	void testgetProductByName() {
		Mockito.when(productDao.getProdByName("Salt")).thenReturn(productResponseByName());
		ResponseEntity<List<Product>> fetchAllProdcut = controller.getProdByName("Salt");
		assertEquals("Tea", fetchAllProdcut.getBody().get(0).getPrName());
	}
	@Test
	void testSaveProduct() {
		Product pr = new Product();
		pr.setId(234);
		pr.setPrName("Steel");
		Product newPr = new Product();
		newPr.setPrName("Iron");
		Mockito.when(productDao.saveProduct(pr)).thenReturn(newPr);
		ResponseEntity<Product> fetchProdcut = controller.saveProduct(pr);
		assertEquals("Iron", fetchProdcut.getBody().getPrName());
	}
	private List<Product> productResponse(){
		List<Product> productList = new ArrayList<>();
		Product pr = new Product();
		pr.setId(1);
		pr.setPrName("Tata");
		pr.setPrPrice(5000.0);
		productList.add(pr);
		return productList;
	}
	private Optional<Product> productByIdResponse(){
		Product pr = new Product();
		pr.setId(512);
		pr.setPrName("Tata");
		pr.setPrPrice(5000.0);
		Optional<Product> optional = Optional.of(pr);
		return optional;
	}
	private List<Product> productResponseByName(){
		List<Product> productList = new ArrayList<>();
		Product pr = new Product();
		pr.setId(1);
		pr.setPrName("Tea");
		pr.setPrPrice(5000.0);
		productList.add(pr);
		return productList;
	}
}
