package com.darekzon.shoppinglist.model;
import com.google.code.morphia.annotations.Entity;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

@Entity(value="products")
public class Product {
	
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
