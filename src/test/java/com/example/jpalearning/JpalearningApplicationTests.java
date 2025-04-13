package com.example.jpalearning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.jpalearning.controller.Controller;
import com.example.jpalearning.dao.ProductDao;


class JpalearningApplicationTests {
	@InjectMocks
	private JpalearningApplication jpalearningApplication;
	@Mock
	private ProductDao productDao;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void contextLoads() {
		String val[] = {"test"};
		jpalearningApplication.main(val);
	}

}
