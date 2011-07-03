package com.darekzon.shoppinglist.actions;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.darekzon.shoppinglist.model.ProductsList;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@SuppressWarnings("serial")
public class ProductsListController extends ActionSupport implements ModelDriven<ProductsList> {

	private ProductsList productsList = new ProductsList();
	
	private String email = null;
	
	private String code = null;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	@RequiredStringValidator
	@EmailValidator
	public void setEmail(String email) {
		this.email = email;
	}

	public ProductsList getProductsList() {
		return productsList;
	}

	public void setProductsList(ProductsList productsList) {
		this.productsList = productsList;
	}

	@Override
	public ProductsList getModel() {
		return null;
	}
	
	public HttpHeaders index(){
		return new DefaultHttpHeaders("index").disableCaching();
	}
	
	public String create(){
		this.validate();
		System.out.println(this.getActionErrors().toString());
		
		System.out.println(this.getEmail());
	
		return ActionSupport.SUCCESS;
	}

	
	
}
