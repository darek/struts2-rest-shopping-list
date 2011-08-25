package com.darekzon.shoppinglist.actions;

import java.util.HashSet;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.darekzon.shoppinglist.model.Product;
import com.darekzon.shoppinglist.model.ProductsList;
import com.darekzon.shoppinglist.repository.ProductListRepository;
import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@ResultPath("/WEB-INF/content/products-list/")
public class ProductsListController implements ModelDriven<ProductsList>{

	private static final long serialVersionUID = 751486393318625432L;

	ProductListRepository productListRepository;
	
	@Inject
	public void setProductListRepository(ProductListRepository pr){
		this.productListRepository = pr;
	}
	
	private ProductsList productsList = new ProductsList();
	private String email = null;
	private int code;
	private String id;	
	private String redirectUrl = null;
	private Product product;
		
	/*@Action(results={@Result(location="${redirectUrl}",type="redirect",name="index",params={"statusCode","200"}),
					 @Result(location="${redirectUrl}",type="redirect",name="error",params={"statusCode","404"})})*/
	@Validations(requiredStrings = {@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "stringisrequired", message = "You must enter a value for string.")},
			     emails = { @EmailValidator(type = ValidatorType.SIMPLE, fieldName = "emailaddress", message = "You must enter a value for email.")})
	public HttpHeaders index(){
		System.out.println("INDEX :/");
		if(this.id!=null){
			return new DefaultHttpHeaders("index").disableCaching();
		}
		try{
			this.id = this.productListRepository.getId(this.getEmail(),this.getCode());
			this.redirectUrl = "/products-list/"+this.id;
		}catch(Exception e){
			HashSet<String> msg = new HashSet<String>();
			msg.add("Products list does not exists");
			//this.setActionErrors(msg);
			this.redirectUrl = "/";
			return new DefaultHttpHeaders("error").disableCaching();
		}
		
		
		return new DefaultHttpHeaders("index").disableCaching();
	}
	
	public String show(){
		if(this.productsList==null){
			return "error";
		}
		return "show";
	}
	
	@Validations(requiredFields = {@RequiredFieldValidator(type=ValidatorType.FIELD,fieldName="product.name",message="You must enter product name"),
								   @RequiredFieldValidator(type=ValidatorType.FIELD,fieldName="product.amount",message="You must enter amount name")},
		         intRangeFields = {@IntRangeFieldValidator(type=ValidatorType.FIELD,fieldName="product.amount",min="1",message="You must set amount greater than 0")})
	public String create(){

		this.productsList.getProductsList().add(this.product);
		this.productListRepository.merge(this.productsList);
		return "index";
	}
	
	//@Override
	public ProductsList getModel() {
		return this.productsList;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
		if(id!=null){
			this.productsList = this.productListRepository.get(id);
		}
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}


	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
}
