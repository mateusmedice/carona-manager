package br.com.carona.manager.activity.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.os.AsyncTask;

public abstract class AbstractAsync extends AsyncTask<Object, Object, Object> {
	
	protected abstract String doInBackground(Object... params);
	
	private String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
		
		InputStream in = entity.getContent();

		StringBuffer out = new StringBuffer();
		
		int n = 1;
		
		while (n > 0) {
			byte[] b = new byte[4096];
			n = in.read(b);

			if (n > 0)
				out.append(new String(b, 0, n));
		}

		return out.toString();
	}
	
	protected String callWebservice(String url) {
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		HttpGet httpGet = new HttpGet(url);
		
		try {
		
			HttpResponse response = httpClient.execute(httpGet, localContext);

			HttpEntity entity = response.getEntity();

			return getASCIIContentFromEntity(entity);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
