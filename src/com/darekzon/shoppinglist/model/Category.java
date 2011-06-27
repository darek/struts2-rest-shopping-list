package com.darekzon.shoppinglist.model;

import com.google.code.morphia.annotations.Entity;

@Entity("categories")
public class Category {

	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String url;


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
