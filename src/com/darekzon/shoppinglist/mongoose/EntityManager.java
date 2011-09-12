package com.darekzon.shoppinglist.mongoose;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;

public interface EntityManager {

	public <T> Datastore getDatastore(String datastore);
	
	public <T> Query<T> find(Class<T> cl);
	
	public String create(Object cl);
	
	public void merge(Object entity);
	
	public void delete(Object entity);
	
	public <T> T get(Class<T> cl,String id);
	
	
	
}
