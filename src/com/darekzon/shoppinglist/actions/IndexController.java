package com.darekzon.shoppinglist.actions;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.darekzon.shoppinglist.repository.ProductListRepository;
import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@SuppressWarnings("serial")
public class IndexController extends ActionSupport {

	@Inject
	private ProductListRepository productList;
	
	private String email;
	
	@EmailValidator(message="Please provide valid email-address")
	@RequiredStringValidator(message="This field cannot be null")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@SkipValidation
	public String index(){
		return "index";
	}

	
	public String create(){
		productList.create(email);
		return "index";
	}
	
	
}
