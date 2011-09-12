package com.darekzon.shoppinglist.repository;

import java.util.List;

import com.darekzon.shoppinglist.model.Product;
import com.darekzon.shoppinglist.model.ShoppingList;

public interface ShoppingListRepository {
	String create(ShoppingList sl);
	void merge(ShoppingList sl);
	void delete(ShoppingList sl);
	void deleteProduct(ShoppingList sl, Integer p);
	
	List<Product> listProducts();
	List<ShoppingList> list();
	ShoppingList get(String id);
}
