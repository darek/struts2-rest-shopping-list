package com.darekzon.shoppinglist.modules;

import com.darekzon.shoppinglist.mongoose.EntityManager;
import com.darekzon.shoppinglist.mongoose.EntityManagerImpl;
import com.darekzon.shoppinglist.repository.ShoppingListRepository;
import com.darekzon.shoppinglist.repository.ShoppingListRepositoryImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class RepositoryModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(EntityManager.class).to(EntityManagerImpl.class).in(Scopes.SINGLETON);
		bind(ShoppingListRepository.class).to(ShoppingListRepositoryImpl.class);
	}

}
