package com.darekzon.shoppinglist.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Id;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

public class ShoppingList{
	
	public ShoppingList(){}
	
	@Id
	private ObjectId id;

	public ObjectId getId() {
		return id;
	}
	
	@TypeConversion("com.darekzon.shoppinglist.converter.ObjectIdConverter")
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Date date = new Date();
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private List<Product> productsList = new ArrayList<Product>();

	public List<Product> getProductsList() {
		return productsList;
	}

	public void addProduct(Product p){
		p.setId(this.productsCounter.getAndIncrement());
		this.productsList.add(p);                                             
	}
	
	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}
	
	private AtomicInteger productsCounter = new AtomicInteger(0);
	
	
	public void removeProductById(Integer id){
		int index = 0;
		for(Product p : this.productsList){
			if(p.getId().equals(id)){
				this.productsList.remove(index);
				break;
			}
			++index;
		}
	}
	
	
}
