package com.pms.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pms.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	//@Query( value = "SELECT * FROM product where name = ?1" , nativeQuery = true)
	public List<Product> findByName(String name);

}
