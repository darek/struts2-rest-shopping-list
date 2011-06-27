package com.darekzon.shoppinglist.modules;

import com.google.inject.Binder;
import com.google.inject.Module;

public class ShoppingListModule implements Module {

	public void configure(Binder binder) {
		
		binder.install(new RepositoryModule());
	}

}
