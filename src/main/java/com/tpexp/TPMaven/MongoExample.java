package com.tpexp.TPMaven;


import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoExample {
    public static void main(String[] args) throws Exception{
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DB database = mongoClient.getDB("myMongoDb");
			System.out.println("vous �tes connect�");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("le serveur est pr�t");

    }
}
