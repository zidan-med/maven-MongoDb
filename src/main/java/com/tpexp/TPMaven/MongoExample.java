package com.tpexp.TPMaven;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoExample {
    public static void main(String[] args) throws Exception{
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DB database = mongoClient.getDB("myMongoDb");
			System.out.println("vous êtes connecté");
			mongoClient.getDatabaseNames().forEach(System.out::println);
			database.createCollection("customers", null);
			database.getCollectionNames().forEach(System.out::println);
			DBCollection collection = database.getCollection("customers");
	        BasicDBObject document = new BasicDBObject();
	        document.put("name", "Shubham");
	        document.put("company", "Baeldung");
	        collection.insert(document);
		} catch (Exception e) {
			System.out.println(e);
		}
		
    }
    
}
