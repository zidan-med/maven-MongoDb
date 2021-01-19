package com.tpexp.TPMaven;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoExample {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        MongoDatabase database = mongoClient.getDatabase("myMongoDb");

        // print existing databases
        mongoClient.getDatabaseNames().forEach(System.out::println);

        database.createCollection("customers", null);

        // print all collections in customers database
        database.getCollectionNames().forEach(System.out::println);

        // create data
        MongoCollection<Document> collection = database.getCollection("customers");
        BasicDBObject document = new BasicDBObject();
        document.put("name", "Shubham");
        document.put("company", "Baeldung");
        collection.insert(document);

        // update data
        BasicDBObject query = new BasicDBObject();
        query.put("name", "Shubham");
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", "John");
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);
        collection.update(query, updateObject);

        // read data
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "John");
        MongoCursor cursor = collection.find(searchQuery);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
}
