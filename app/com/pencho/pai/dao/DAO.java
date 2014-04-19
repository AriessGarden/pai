package com.pencho.pai.dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * 
 * @author ari
 * 
 */
public class DAO {

	public static final DAO instance = new DAO();
	public static MongoClient mongo;
	public static DB database;

	private DAO() 

	{
		try {
			// MongoOptions options = new MongoOptions();
			// options.autoConnectRetry = true;
			// options.connectionsPerHost = 1000;
			// options.maxWaitTime = 5000;
			// options.socketTimeout = 0;
			// options.connectTimeout = 15000;
			// options.threadsAllowedToBlockForConnectionMultiplier = 5000;
			// 
            
			mongo = new MongoClient("192.168.0.178", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		database = mongo.getDB("pai");
	}
}
