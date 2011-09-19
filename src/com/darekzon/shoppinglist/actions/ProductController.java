package com.darekzon.shoppinglist.actions;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.darekzon.shoppinglist.model.Product;
import com.darekzon.shoppinglist.model.ShoppingList;
import com.darekzon.shoppinglist.repository.ShoppingListRepository;
import com.google.inject.Inject;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@ResultPath("/WEB-INF/content/product/")
public class ProductController implements ModelDriven<ShoppingList> {

	ShoppingListRepository productListRepository;

	@Inject
	public void setProductListRepository(ShoppingListRepository pr) {
		this.productListRepository = pr;
	}

	private String id;

	private int productId;

	private Product product;

	private ShoppingList productsList;

	@Validations(requiredFields = {
			@RequiredFieldValidator(type = ValidatorType.FIELD, fieldName = "product.name", message = "You must enter product name"),
			@RequiredFieldValidator(type = ValidatorType.FIELD, fieldName = "product.amount", message = "You must enter amount") }, intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.FIELD, fieldName = "product.amount", min = "1", message = "You must set amount greater than 0") })
	public String create() {
		Logger.getLogger(this.getClass()).debug("inserting new product - "+this.product.getName());
		
		this.productsList.addProduct(this.product);
		this.productListRepository.merge(this.productsList);
		return "create";
	}

	public String destroy() {
		Logger.getLogger(this.getClass().toString()).log(Level.INFO,"deleting product");
		this.productListRepository.deleteProduct(this.productsList,this.productId);
		return "destroy";
	}

	public ShoppingList getModel() {
		if (this.id != null) {
			this.setProductsList(this.productListRepository.get(this.id));
		}
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ShoppingList getProductsList() {
		return productsList;
	}

	public void setProductsList(ShoppingList productList) {
		this.productsList = productList;
	}

}
