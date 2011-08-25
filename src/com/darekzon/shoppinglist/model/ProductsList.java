package com.darekzon.shoppinglist.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import java.lang.String;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

public class ProductsList{

	@Id
	ObjectId id;

	public ObjectId getId() {
		return id;
	}

	@TypeConversion(converter = "com.darekzon.shoppinglist.mongoose.ObjectIdConverter")
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public void setId(String id){
		this.id = new ObjectId(id);
	}
	
	String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Indexed
	String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Indexed
	Date date = new Date();
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	List<Product> productsList = new ArrayList<Product>();

	public List<Product> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}
	
	
	
}
