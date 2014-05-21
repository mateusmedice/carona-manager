package br.com.carona.manager.activity.util;

import java.net.URI;
import java.net.URL;

public class URLUtil {

	public static String encode(String urlParam) {

		try {
		
			if (urlParam == null || urlParam.isEmpty()) {
				return null;
			}
			
			URL url = new URL(urlParam);
	
			URI uri = new URI(
				url.getProtocol(), url.getUserInfo(), url.getHost(), 
				url.getPort(), url.getPath(), url.getQuery(), url.getRef());
	
			url = uri.toURL();
	
			return url.toString();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
