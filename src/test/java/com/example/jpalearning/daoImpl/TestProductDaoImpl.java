package com.example.jpalearning.daoImpl;

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

import com.example.jpalearning.entity.Product;
import com.example.jpalearning.repo.ProductRepositery;

public class TestProductDaoImpl {
	@Mock
	private ProductRepositery prrepo;
	@InjectMocks
	private ProductDaoImpl productDaoImpl;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSaveProduct() {
		Product pr = new Product();
		pr.setId(234);
		pr.setPrName("Steel");
		Product newPr = new Product();
		newPr.setPrName("Iron");
		Mockito.when(prrepo.save(pr)).thenReturn(newPr);
		Product fetchProdcut = productDaoImpl.saveProduct(pr);
		assertEquals("Iron", fetchProdcut.getPrName());
	}
	@Test
	void testFetchAllProduct() {
		Mockito.when(prrepo.findAll()).thenReturn(productResponse());
		List<Product> fetchAllProdcut = productDaoImpl.fetchAllProdcut();
		assertEquals("Tata", fetchAllProdcut.get(0).getPrName());
		assertEquals(5000.0, fetchAllProdcut.get(0).getPrPrice());
	}
	@Test
	void testgetProductById() {
		Mockito.when(prrepo.findById(123)).thenReturn(productByIdResponse());
		Optional<Product> fetchAllProdcut = productDaoImpl.getProdById(123);
		assertEquals(512, fetchAllProdcut.get().getId());
	}
	@Test
	void testgetProductByName() {
		Mockito.when(prrepo.findByPrName("Salt")).thenReturn(productResponseByName());
		List<Product> fetchAllProdcut = productDaoImpl.getProdByName("Salt");
		assertEquals("Tea", fetchAllProdcut.get(0).getPrName());
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
