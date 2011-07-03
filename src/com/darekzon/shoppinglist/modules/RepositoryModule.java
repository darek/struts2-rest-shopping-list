package com.darekzon.shoppinglist.modules;

import com.darekzon.shoppinglist.mongoose.EntityManager;
import com.darekzon.shoppinglist.mongoose.EntityManagerImpl;
import com.darekzon.shoppinglist.mongoose.Sendmail;
import com.darekzon.shoppinglist.mongoose.SendmailImpl;
import com.darekzon.shoppinglist.repository.ProductListRepository;
import com.darekzon.shoppinglist.repository.ProductListRepositoryImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class RepositoryModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(EntityManager.class).to(EntityManagerImpl.class).in(Scopes.SINGLETON);
		bind(Sendmail.class).to(SendmailImpl.class).in(Scopes.SINGLETON);
		bind(ProductListRepository.class).to(ProductListRepositoryImpl.class);
	}

}
