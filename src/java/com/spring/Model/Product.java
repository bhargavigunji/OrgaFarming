package com.spring.Model;

import com.andromeda.commons.model.BaseModel;

public class Product extends BaseModel {

	private static final long serialVersionUID = 1L;
	public String name;
	public String email;
	public String product;
	public String price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	

}
