package br.com.carona.manager.util;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Utility class to data base connection.
 */
public class ConnectionUtil {

	private static ConnectionUtil instance;

	private static DB mongoDB;

	private static MongoClient mongoClient;

	/**
	 * Default Constructor
	 */
	private ConnectionUtil() {

		try {

			if (mongoClient == null) {
				mongoClient = new MongoClient(Constants.MONGO_DB_HOST,
						Constants.MONGO_DB_PORT);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Return the class instance.
	 * 
	 * @return Instance of ConnectionUtil.
	 */
	public static synchronized ConnectionUtil getInstance() {
		
		if (instance == null) {
			instance = new ConnectionUtil();
		}
		return instance;
	}

	/**
	 * Return the MongoDB data base object.
	 * 
	 * @return Data Base Object.
	 */
	public DB getMongoDB() {

		try {

			if (mongoDB == null) {
				mongoDB = mongoClient.getDB(Constants.MONGO_DB_CARONA);
			}

			return mongoDB;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
