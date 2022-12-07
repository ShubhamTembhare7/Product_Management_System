package com.pms.demo.ControllerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pms.demo.controller.ProductController;
import com.pms.demo.model.Category;
import com.pms.demo.model.Product;
import com.pms.demo.service.ProductService;

import junit.framework.Assert;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@WebMvcTest
public class ProductControllerTest {
	
	@Autowired(required = true)
	private MockMvc mockMvc;

	@Autowired(required = true)
	private ObjectMapper objectMapper;
	
	@InjectMocks
	private ProductController productController;
	
	@MockBean
	private ProductService productService;

	
	@Test
	public void addProductTest() throws  Exception
	{
		Set<Product> setProduct=new HashSet<>();
		Category cat=new Category();
		cat.setCid(102);
		cat.setName("Electronic Product");
		
		Product prod=new Product();
		prod.setProductId(101);
		prod.setName("HP");
		prod.setDescription("Laptop");
		prod.setPrice(50000);
		prod.setCategory(cat);
		
		setProduct.add(prod);
		
		when(productService.addProduct(prod)).thenReturn(prod);

		this.mockMvc.perform(post("/product/addProduct").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(prod))).andExpect(status().isCreated());
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getAllProduct() throws Exception
	{
		List<Product> listProduct=new ArrayList<>();
		Category cat=new Category();
		cat.setCid(102);
		cat.setName("Electronic Product");
		
		Product prod=new Product();
		prod.setProductId(101);
		prod.setName("HP");
		prod.setDescription("Laptop");
		prod.setPrice(50000);
		prod.setCategory(cat);
		
		listProduct.add(prod);
		
		Mockito.when(productService.getAllProduct()).thenReturn(listProduct);
		Assert.assertNotNull(productController.getProduct());
		Assert.assertNotNull(listProduct);
		Assert.assertNotNull(cat);
		Assert.assertNotNull(prod);
		
	}
	
	@Test
	public void getProductById()
	{
		long productId=101;
		Product prod=new Product();
		Mockito.when(productService.getProductById(productId)).thenReturn(prod);
		Assert.assertNotNull(productController. getProductById(productId));
		Assert.assertNotNull(prod);
		Assert.assertNotNull(productId);
	}
	
	
	@Test
	public void getProductByNameTest()
	{
		List<Product> listProduct=new ArrayList<>();
		
		when(productService.getProductByName("HP")).thenReturn(listProduct);
		
	
		
	}
}
