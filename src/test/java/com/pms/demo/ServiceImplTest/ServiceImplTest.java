package com.pms.demo.ServiceImplTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.pms.demo.model.Category;
import com.pms.demo.model.Product;
import com.pms.demo.repository.ProductRepository;
import com.pms.demo.serviceImpl.ProductServiceImpl;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceImplTest {

	@Mock
	private RequestAttributes attribute;

	@InjectMocks
	private ProductServiceImpl productServiceImpl;

	private MockMvc mockMvc;

	@Mock
	private ProductRepository productRepository;

	
	  @Before(value = "") 
	  public void setup()
	  {
	      RequestContextHolder.setRequestAttributes(attribute);
	     this.mockMvc=MockMvcBuilders.standaloneSetup(productServiceImpl).build(); }
	 
	@Test
	public void getAllProductList() {
		List<Product> listProduct = new ArrayList<>();
		Category cat = new Category();
		cat.setCid(102);
		cat.setName("Electronic Product");

		Product prod = new Product();
		prod.setProductId(101);
		prod.setName("HP");
		prod.setDescription("Laptop");
		prod.setPrice(50000);
		prod.setCategory(cat);

		listProduct.add(prod);

		Mockito.when(productRepository.findAll()).thenReturn(listProduct);

		Assert.assertNotNull(productServiceImpl.getAllProduct());
		Assert.assertNotNull(prod);
		Assert.assertNotNull(listProduct);
		Assert.assertNotNull(cat);
	}
}
