package com.darekzon.shoppinglist.actions;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.ResultPath;

import com.darekzon.shoppinglist.model.ShoppingList;
import com.darekzon.shoppinglist.repository.ShoppingListRepository;
import com.google.inject.Inject;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@ResultPath("/WEB-INF/content/shopping-list/")
public class ShoppingListController implements ModelDriven<ShoppingList> {

	ShoppingListRepository shoppingListRepository;
	
	@Inject
	public void setShoppingListRepository(ShoppingListRepository pr){
		this.shoppingListRepository = pr;
	}
	
	private ShoppingList list = new ShoppingList();
	
	private String id;	
		

	public String index(){
		System.out.println("INDEX");
		return "index";
	}
	
	@Validations(requiredStrings = {@RequiredStringValidator(type = ValidatorType.FIELD, fieldName = "list.name", message = "You must set shopping list name a value for string.")})
	public String create(){
		this.shoppingListRepository.create(this.list);
		return "create";
	}

	public String show(){
		System.out.println("shopping list show"+this.list.getName());
		
		return "show";
	}
	
	
	public String destroy(){
		Logger.getLogger(this.getClass()).debug("destroy - deleting products list");
		if(this.list!=null){
			this.shoppingListRepository.delete(this.list);
		}
		return "destroy";
		
	}
	
	/*@Validations(requiredStrings = {@RequiredStringValidator(type=ValidatorType.SIMPLE,key="productId",message="No productId specified")})*/
	public String update(){
		return "update";
	}
	
	public ShoppingList getModel() {
		this.list = this.shoppingListRepository.get(this.getId());
		return this.list;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ShoppingList getList() {
		return list;
	}

	public void setList(ShoppingList list) {
		this.list = list;
	}
	
	
}
