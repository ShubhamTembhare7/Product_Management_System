package com.pms.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.demo.exception_handle.BusinessException;
import com.pms.demo.exception_handle.DeleteException;
import com.pms.demo.exception_handle.EmptyException;
import com.pms.demo.exception_handle.EmptyInputException;
import com.pms.demo.model.Product;
import com.pms.demo.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Value("${module1.dev}")
	private String dev;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(ProductController.class);
	
	@PostMapping(value = "/addProduct")
	public Product saveProduct(@RequestBody Product product)
	{
		LOGGER.info("Inside class..ProductController,Method..saveProduct");
		
		  if(product.getName().isEmpty()|| product.getName().length()==0) 
			  throw new EmptyInputException("601","Input field are empty.");
		
		
		Product prod=productService.addProduct(product);
		if(product!=null)
		{
			throw new BusinessException(" Data is added Successfully");
		}
		
		return prod;
	}
	
	@GetMapping(value = "/getAllProduct")
	public ResponseEntity<List<Product>> getProduct()
	{
		LOGGER.info("Inside method..getProduct");
		
		List<Product> productlist=productService.getAllProduct();
		
		 if(productlist.isEmpty()) 
			 throw new EmptyException("101","Product List is Empty");
		 
		return new ResponseEntity<List<Product>>(productlist,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getProductByName/{name}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable("name") String name)
	{
		LOGGER.info("Inside method..getProductByName");
		
		List<Product> listprod=productService.getProductByName(name);
		
		return new ResponseEntity<List<Product>>(listprod,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getProductById/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId)
	{
		LOGGER.info("Inside method..getProductById");
		
		Product prod=productService.getProductById(productId);
		
		return new ResponseEntity<Product>(prod,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteProductById/{productId}")
	public ResponseEntity deleteProductById(@PathVariable("productId") long productId)
	{ 
		
		
	List<Product>productlist=productService.getAllProduct();
	
	int flag =0;
	
	LOGGER.info("Inside method..deleteProductById");
	
	for(Product pro:productlist)
	{
		
		if(productId ==pro.getProductId())
		{
			productService.deleteProductById(productId);
			flag=1;
			return new ResponseEntity("Data is deleted Successfully", HttpStatus.ACCEPTED);
		}
	}
	if(flag==0)
	{
		return new ResponseEntity("Product Id is not exist", HttpStatus.NOT_FOUND);

	}
	return null;
	}
	
	@PutMapping(value = "/updateProduct/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product)
	{
		LOGGER.info("Inside method..updateProduct");
		
		Product update=productService.updateProduct(productId,product);
		
		return new ResponseEntity<Product>(update,HttpStatus.OK);
	}

}
