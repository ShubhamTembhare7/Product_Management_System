package com.pms.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.demo.controller.ProductController;
import com.pms.demo.model.Product;
import com.pms.demo.repository.ProductRepository;
import com.pms.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(ProductServiceImpl.class);
	@Override
	public Product addProduct(Product product) {
		
		LOGGER.info("Inside class..ProductServiceImpl,Method..addProduct");
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		LOGGER.info("Inside class..ProductServiceImpl,Method..getAllProduct");
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductByName(String name) {
		
		LOGGER.info("Inside class..ProductServiceImpl,Method..getProductByName");
		return productRepository.findByName(name);
	}

	@Override
	public Product getProductById(Long productId) {
		
		LOGGER.info("Inside class..ProductServiceImpl,Method..getProductById");
		Optional<Product> opt= productRepository.findById(productId);
		if(opt.isPresent())
			
		{
			Product product=opt.get();
			 return product;
		}
		else {
			
			System.out.println("Prodcut Not Exist");
			return null;
		}
		
		
	}

	@Override
	public void deleteProductById(Long productId) {
		
		LOGGER.info("Inside class..ProductServiceImpl,Method..deleteProductById");
		 productRepository.deleteById(productId);
	}

	@Override
	public Product updateProduct(Long productId,Product product) {
		
		LOGGER.info("Inside class..ProductServiceImpl,Method..updateProduct");
		Product prod=null;
		Optional<Product> opt=productRepository.findById(productId);
		if(opt.isPresent())
		{
			prod=opt.get();
			prod.setName(product.getName());
			prod.setDescription(product.getDescription());
			prod.setPrice(product.getPrice());
			prod.setCategory(product.getCategory());
			
			return productRepository.save(prod);
			
		}
		else {
            System.out.println("Product not found!");
        }
		return prod;
	}

	
	

}
