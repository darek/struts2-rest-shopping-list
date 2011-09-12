package com.darekzon.shoppinglist.model;
import java.io.Serializable;

import com.google.code.morphia.annotations.Entity;

@Entity(value="products")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7752948041825268744L;
	
	public Product(){}
	
	public Product(String productName,int amount) {
		this.setName(productName);
		this.setAmount(amount);
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
	
	//@TypeConversion(converter = "com.darekzon.shoppinglist.mongoose.StringToIntConverter")
	public void setAmount(int amnt){
		this.amount = amnt;
	}
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
