//package com.example.jpalearning.daoImpl;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.atLeastOnce;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//import org.junit.Ignore;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//public class TestProductProcessor {
//	@InjectMocks
//	private ProductProcessor processor;
//
//	@Mock
//	private ProductLogicBuilder productLogicBuilder;
//
//	@BeforeEach
//	public void before() {
//		MockitoAnnotations.openMocks(this);
//
//	}
//	@Ignore
//	@Test
//	public void testProductWhenOtherProduct() throws Exception {
//		String processData = processor.processProductData("ProdName-234");
//		assertEquals("ProdName-234", processData);
//	}
//	@Ignore
//	@Test
//	public void testProductWhencomPanyProduct() throws Exception {
//		String processData = processor.processProductData("Samsung-A54");
//		assertEquals("Samsung", processData);
//	}
//	@Ignore
//	@Test
//	public void testProductWhenOutside() throws Exception {
//		String processData = processor.processProductData("Nokia");
//		assertEquals("Nokia", processData);
//	}
//	@Test
//	public void testAddWhenValidDigits() throws Exception {
//		assertEquals(11, processor.add(5, 6));
//	}
//	@Test
//	public void testAddWhenAisLessThan0() {
//		assertThrows(Exception.class, ()->processor.add(-1, 6),"This method should throw: ");
//	}
//	@Test
//	public void testAddWhenBisLessThan0() {
//		assertThrows(Exception.class, ()->processor.add(6, -1),"This method should throw: ");
//	}
//	@Test
//	public void testAddWhenAisGreaterthan1000() {
//		assertThrows(Exception.class, ()->processor.add(5000, 5),"This method should throw: ");
//	}
//	@Test
//	public void testAddWhenBisGreaterthan1000() {
//		assertThrows(Exception.class, ()->processor.add(5, 5000),"This method should throw: ");
//	}
//	@Test
//	public void testAddWhenProductIsNotNull() throws Exception {
//		Mockito.when(productLogicBuilder.processData(anyString())).thenReturn("MyProduct");
//		Mockito.doNothing().when(processor).validate("MyProduct");
//		String processProductData = processor.processProductData("MyProduct");
//		assertEquals("MyProduct", processProductData);
//	}
//	@Test
//	public void testAddWhenProductIsNoll() throws Exception {
//		Mockito.doNothing().when(productLogicBuilder).validate("MyProduct");
//		processor.validate("MyProduct");
//		verify(productLogicBuilder, times(2)).validate("MyProduct");
//		verify(productLogicBuilder, atLeastOnce()).validate("MyProduct");
//	}
//	@Test()
//	public void testAddWhenProductException() throws Exception {
//		Mockito.doThrow(new RuntimeException("Product can naot be null or empty")).when(productLogicBuilder).validate("MyProduct");
//		assertThrows(RuntimeException.class, () -> {
//			processor.validate("MyProduct");
//        });
//		verify(productLogicBuilder, atLeastOnce()).validate("MyProduct");
//	}
//}
