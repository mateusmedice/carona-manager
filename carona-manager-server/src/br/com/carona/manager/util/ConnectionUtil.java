package br.com.carona.manager.util;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class ConnectionUtil {

	private static ConnectionUtil instance;

	private static DB mongoDB;

	private static MongoClient mongoClient;

	/**
	 * Construtor Padrao
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
	 * Metodo que retorna a insancia da propria classe.
	 * 
	 * @return Instancia de ConnectionUtil.
	 */
	public static synchronized ConnectionUtil getInstance() {
		if (instance == null) {
			instance = new ConnectionUtil();
		}
		return instance;
	}

	/**
	 * Retorna o banco de dados no MongoDB.
	 * 
	 * @param db
	 *            - Nome do Banco de Dados
	 * @return DB - Objeto que contem o banco de dados.
	 */
	public DB getMongoDB() {

		try {

			if (mongoDB == null) {

				mongoDB = mongoClient.getDB(Constants.MONGO_DB_CARONA);
				/*
				boolean auth = 
					mongoDB.authenticate(
						Constants.MONGO_DB_USER_NAME, Constants.MONGO_DB_PASSWORD.toCharArray());
				
				
				if (auth) {
					return mongoDB;
				} else {
					throw new RuntimeException("Usuario nao autenticado no banco de dados.");
				}*/
			}

			return mongoDB;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
