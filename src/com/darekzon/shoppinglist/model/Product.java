package com.darekzon.shoppinglist.model;
import com.google.code.morphia.annotations.*;

@Entity(value="products")
public class Product {
	
	public Product(){}
	
	public Product(String productName) {
		this.setName(productName);
	}
	
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String objectId) {
		id = objectId;
	}

	private String name;

	public String getName() {
		return name;
	}

	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Embedded
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

}
