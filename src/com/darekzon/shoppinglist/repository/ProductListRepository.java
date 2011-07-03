package com.darekzon.shoppinglist.repository;

import java.util.List;

import com.darekzon.shoppinglist.model.Product;

public interface ProductRepository {
	void create(Product product);
	void update(Product product);
	void delete(Product product);
	List<Product> list();
}
