package com.tpexp.TPMaven;

import static org.junit.jupiter.api.Assertions.*;

import java.net.UnknownHostException;

import org.junit.jupiter.api.Test;

import com.mongodb.MongoClient;

class MongoExampleTest {

	@Test
	void test() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		mongoClient.getDatabaseNames().forEach(System.out::println);
		
	}

}
