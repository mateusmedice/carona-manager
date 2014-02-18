package br.com.carona.manager.util;

/**
 * Constants Class.
 */
public class Constants {

	/**
	 * Data base host name.
	 */
	public static final String MONGO_DB_HOST = "localhost";

	/**
	 * Data base port.
	 */
	public static final Integer MONGO_DB_PORT = 27017;

	/**
	 * Data base name.
	 */
	public static final String MONGO_DB_CARONA = "carona";
	
	/**
	 * Like regex to like's queries.
	 */
	public static final String REGEX_LIKE_QUERY_FORMAT = ".*((?i)%s).*";

	
	/**
	 * Like regex to one size like's queries.
	 */
	public static final String REGEX_LIKE_LEFT_QUERY_FORMAT = ".*((?i)^%s).*";
	
}
