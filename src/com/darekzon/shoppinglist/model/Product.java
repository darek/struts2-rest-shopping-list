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

	public void setName(String name) {
		this.name = name;
	}

	private int amount;
	
	public int getAmount(){
		return amount;
	}
	
	public void setAmount(int amnt){
		this.amount = amnt;
	}

}
