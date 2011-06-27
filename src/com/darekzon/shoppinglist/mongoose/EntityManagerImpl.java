package com.darekzon.shoppinglist.mongoose;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Properties;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class EntityManagerImpl implements EntityManager {
	
	private String host = null;;
	private int port = 27017;
	private String user = null;
	private String password = null;
	private String datastore = null;
	
	private Mongo mongo;
	
	private Morphia morphia = new Morphia();
	
	public EntityManagerImpl() throws UnknownHostException, MongoException{
		
		this.readProperties();
		
		
		System.out.println("Starting EntityManager");
	}
	
	private void readProperties() {
		Properties databaseProps = new Properties();
		try {
			databaseProps.load(this.getClass().getResourceAsStream("/database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Database fatal error");
		}
		this.host = databaseProps.getProperty("host");
		this.port = Integer.valueOf(databaseProps.getProperty("port"));
		this.user = databaseProps.getProperty("user");
		this.password = databaseProps.getProperty("password");
		this.datastore = databaseProps.getProperty("datastore");
		
	}

	public EntityManagerImpl(final String host, final int port) throws UnknownHostException, MongoException{
		this.mongo = new Mongo(host, port);
	}

	public <T> Datastore getDatastore(String datastore) {
		return this.morphia.createDatastore(this.mongo, datastore);
	}
	
	public <T> Query<T> find(Class<T> cl){
		return this.getDatastore(this.datastore).find(cl);
	}
	
	public DB getDatabase(String database){
		return this.mongo.getDB(database);
	}

	@Override
	public void create(Object cl) {
		//System.out.println(cl);
		this.getDatastore(this.datastore).save(cl);
		
	}

}
