//package com.example.jpalearning.daoImpl;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(TestProductLogicBuilder.class)
//public class TestProductLogicBuilder {
//	private ProductLogicBuilder productLogicBuilder;
//
//	@Before
//	public void before() {
//		productLogicBuilder = PowerMockito.spy(new ProductLogicBuilder());
//	}
//
//	@Test
//	public void testProduct() {
//		PowerMockito.doReturn("test").when(productLogicBuilder.staticMethod("ProdName-234"));
//		String staticMethod = productLogicBuilder.staticMethod("ProdName-234");
//		Assert.assertEquals("ProdName", staticMethod);
//	}
//}
