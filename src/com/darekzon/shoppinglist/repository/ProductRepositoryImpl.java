package com.darekzon.shoppinglist.repository;

import java.util.ArrayList;
import java.util.List;

import com.darekzon.shoppinglist.model.Product;
import com.darekzon.shoppinglist.mongoose.EntityManager;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ProductRepositoryImpl implements ProductRepository{

	private EntityManager em;
	
	@Inject
	public ProductRepositoryImpl(Provider<EntityManager> em) {
		this.em = em.get();
	}

	public void create(Product product) {
		this.em.create(product);
		
	}

	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Product product) {
		// TODO Auto-generated method stub
		
	}

	public List<Product> list() {
		return this.em.find(Product.class).asList();
	}

}
