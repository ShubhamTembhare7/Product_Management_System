package com.pms.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer"}) 
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	@Column
	private String name;
	
	@OneToMany(mappedBy="category")
	private List<Product> product;
	/*
	 * @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	 * 
	 * @Fetch(FetchMode.SELECT) private List<Product> product;
	 */
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", name=" + name + "]";
	}

	/*
	 *  public List<Product> getProduct() { //// return product; //// } ////
	 *  public void setProduct(List<Product> product) { //// this.product =
	 * product;  }
	 */
	

	
	
	
}
