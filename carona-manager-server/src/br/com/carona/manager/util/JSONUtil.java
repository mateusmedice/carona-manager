package br.com.carona.manager.util;

import com.google.gson.Gson;

/**
 * JSON utility class.
 */
public class JSONUtil {

	/**
	 * Parse an object to JSON.
	 * 
	 * @param object
	 * @return Object's JSON
	 */
	public static String toJson(Object object) {
		
		if (object == null) {
			throw new RuntimeException("Object cant be null.");
		}
		
		return new Gson().toJson(object);
	}
	
}
