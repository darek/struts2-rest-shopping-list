package com.darekzon.shoppinglist.repository;

import java.util.List;

import com.darekzon.shoppinglist.model.Product;
import com.darekzon.shoppinglist.model.ShoppingList;
import com.darekzon.shoppinglist.mongoose.EntityManager;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ShoppingListRepositoryImpl implements ShoppingListRepository{
	
	private EntityManager em;
	
	@Inject
	public ShoppingListRepositoryImpl(Provider<EntityManager> em) {
		this.em = em.get();
	}

	public void merge(ShoppingList pr) {
		this.em.merge(pr);
		
	}

	public void delete(ShoppingList pr) {
		this.em.delete(pr);
	}

	public void deleteProduct(ShoppingList pr, Integer productId) {
		pr.removeProductById(productId);
		this.em.merge(pr);
	}

	public List<Product> listProducts() {
		return null;
	}
	
	public List<ShoppingList> list(){
		return this.em.find(ShoppingList.class).asList();
	}

	public String getId(String email, int code) {
		return this.em.find(ShoppingList.class).field("email").equal(email)
					  .field("code").equal(String.valueOf(code)).retrievedFields(true, "_id").get().getId().toStringMongod();
	}

	public ShoppingList get(String id){
		try{
			return (ShoppingList) this.em.get(ShoppingList.class,id);
		}catch(IllegalArgumentException iae){
			return null;
		}
	

	}

	public String create(ShoppingList sl) {
		return this.em.create(sl);
	}
	
}
