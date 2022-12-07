package com.pms.demo.service;

import java.util.List;
import java.util.Optional;

import com.pms.demo.model.Product;

public interface ProductService {

	public Product addProduct(Product product);

	public List<Product> getAllProduct();

	public List<Product> getProductByName(String name);

	public Product getProductById(Long productId);

	public void deleteProductById(Long productId);

	public Product updateProduct(Long productId, Product product);

}
