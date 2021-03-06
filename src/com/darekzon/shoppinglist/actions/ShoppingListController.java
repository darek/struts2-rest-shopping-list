package com.darekzon.shoppinglist.actions;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.bson.types.ObjectId;

import com.darekzon.shoppinglist.model.ShoppingList;
import com.darekzon.shoppinglist.repository.ShoppingListRepository;
import com.google.inject.Inject;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;


@ResultPath("/WEB-INF/content/shopping-list/")
public class ShoppingListController implements ModelDriven<ShoppingList>  {

	ShoppingListRepository shoppingListRepository;
	
	@Inject
	public void setShoppingListRepository(ShoppingListRepository pr){
		this.shoppingListRepository = pr;
	}
	
	private ShoppingList list = null;
	
	private String id = null;	
		

	public HttpHeaders index(){
		if(this.id != null && this.list==null){
			return new DefaultHttpHeaders("notfound").withStatus(404);
		}
		if(this.id !=null && this.list!=null){
			// BUG - even with directly setted 302 status application is returning 201 (created) status.
			return new DefaultHttpHeaders("show").setLocationId(this.id).withStatus(302);
		}
		return new DefaultHttpHeaders("index");
	}
	
	@Validations(requiredStrings = {@RequiredStringValidator(type = ValidatorType.FIELD, fieldName = "list.name", message = "You must set shopping list name a value for string.")})
	public HttpHeaders create(){
		String id = this.shoppingListRepository.create(this.list);
		return new DefaultHttpHeaders("create").withStatus(201).setLocationId(id.toString());
	}

	public HttpHeaders show(){
		if(this.list == null){
			return new DefaultHttpHeaders("notfound").withStatus(404);
		}
		return new DefaultHttpHeaders("show").withStatus(200);
	}
	
	
	public HttpHeaders destroy(){
		Logger.getLogger(this.getClass()).debug("destroy - deleting products list");
		if(this.list!=null){
			this.shoppingListRepository.delete(this.list);
		}
		return new DefaultHttpHeaders("destroy").withStatus(204).disableCaching();
		
	}
	
	@Validations(requiredStrings = {@RequiredStringValidator(type=ValidatorType.SIMPLE,key="shoppingList.name",message="You must set shopping list name")})
	public HttpHeaders update(){
		
		
		return new DefaultHttpHeaders("update").withStatus(204).disableCaching();
	}
	
	public ShoppingList getModel() {
		return this.list;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		if(id!=null){
			this.list = this.shoppingListRepository.get(this.getId());
		}
	}

	public ShoppingList getList() {
		return list;
	}

	public void setList(ShoppingList list) {
		this.list = list;
	}
	
	
}
