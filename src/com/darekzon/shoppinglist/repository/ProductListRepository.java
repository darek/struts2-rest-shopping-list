package com.darekzon.shoppinglist.repository;

import java.util.List;

import com.darekzon.shoppinglist.model.Product;
import com.darekzon.shoppinglist.model.ProductsList;

public interface ProductListRepository {
	void create(String email);
	void merge(ProductsList pr);
	void delete(ProductsList pr);
	void deleteProduct(ProductsList pr, Product p);
	String getId(String email,int code);
	List<Product> listProducts();
	List<ProductsList> list();
	ProductsList get(String id);
}
