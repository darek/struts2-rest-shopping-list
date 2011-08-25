package com.darekzon.shoppinglist.mongoose;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Properties;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * EntityManagerImpl - class that implement MongoDB EntityManager
 * EntityManager read config from database.properties file
 * 
 * @author darek
 */
public class EntityManagerImpl implements EntityManager {
	
	/**
	 * Database properties from database.properties file
	 */
	private Properties properties = new Properties();
	
	/**
	 * Mongo database connection
	 */
	private Mongo mongo;
	
	/**
	 * Morfia object for Mongo database operation 
	 * @see mongo
	 */
	private Morphia morphia = new Morphia();
	
	/**
	 * 
	 * @throws UnknownHostException
	 * @throws MongoExcept
	 */
	public EntityManagerImpl() throws UnknownHostException, MongoException{
		System.out.println("Starting Morphia wrapper...");
		this.readProperties();
		this.mongo = new Mongo(properties.getProperty("db.host"),Integer.valueOf(properties.getProperty("db.port")));
	}
	
	/**
	 * Reads database settings from database.properties file
	 * If settings doesn not exists system is unable to connect to database, 
	 * so application won't work that's why RuntimeException is thrown
	 */
	private void readProperties() throws RuntimeException{
		try {
			properties.load(this.getClass().getResourceAsStream("/database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Database fatal error. Please provide database configuration in database.properties file");
		}
		
	}
	
	public <T> Datastore getDatastore(String datastore) {
		return this.morphia.createDatastore(this.mongo, datastore);
	}
	
	public <T> Query<T> find(Class<T> cl){
		return this.getDatastore(this.properties.getProperty("db.datastore")).find(cl);
	}
	
	
	@Override
	public void merge(Object entity) {
		System.out.println("merging entity "+entity);
		this.getDatastore(this.properties.getProperty("db.datastore")).merge(entity);
	}

	public <T> T get(Class<T> cl,String id){
	
		return this.getDatastore(this.properties.getProperty("db.datastore")).get(cl,new ObjectId(id));
	}
	
	public DB getDatabase(String database){
		return this.mongo.getDB(database);
	}

	@Override
	public void create(Object cl) {
		this.getDatastore(this.properties.getProperty("db.datastore")).save(cl);
		
	}

}
