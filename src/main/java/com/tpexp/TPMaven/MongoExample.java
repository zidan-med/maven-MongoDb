package com.tpexp.TPMaven;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoExample {
    public static void main(String[] args) throws Exception{
		try {
			//connection au base de donnees Mongodb
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DB database = mongoClient.getDB("myMongoDb");
			System.out.println("vous êtes connecté");
			//afficher les base de donnees
			mongoClient.getDatabaseNames().forEach(System.out::println);
			database.createCollection("customers", null);
			//afficher les collections
			database.getCollectionNames().forEach(System.out::println);
			//insertion des donnees
			DBCollection collection = database.getCollection("customers");
	        BasicDBObject document = new BasicDBObject();
	        document.put("name", "Shubham");
	        document.put("company", "Baeldung");
	        collection.insert(document);
	        //modification des donnees
	        BasicDBObject query = new BasicDBObject();
	        query.put("name", "Shubham");
	        BasicDBObject newDocument = new BasicDBObject();
	        newDocument.put("name", "John");
	        BasicDBObject updateObject = new BasicDBObject();
	        updateObject.put("$set", newDocument);
	        collection.update(query, updateObject);
	        //lecture des donnees
	        BasicDBObject searchQuery = new BasicDBObject();
	        searchQuery.put("name", "John");
	        DBCursor cursor = collection.find(searchQuery);
	        while (cursor.hasNext()) {
	            System.out.println(cursor.next());
	        }
		} catch (Exception e) {
			System.out.println(e);
		}
		
    }
    
}
