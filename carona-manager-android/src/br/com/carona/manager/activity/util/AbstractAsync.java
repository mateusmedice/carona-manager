package br.com.carona.manager.activity.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.os.AsyncTask;
import br.com.carona.manager.activity.model.Post;

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
	
	protected String callPostWebservice(String url, Object param) {

		HttpClient httpClient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		HttpPost httpPost = new HttpPost(url);
		
		try {
			
			Post post = (Post) param;
			
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("idUsuario", post.getIdUsuario()));
            nvps.add(new BasicNameValuePair("description", post.getDescription()));
			
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));

			HttpResponse response = httpClient.execute(httpPost, localContext);

			HttpEntity entity = response.getEntity();

			return getASCIIContentFromEntity(entity);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	protected String callGetWebservice(String urlParam) {

		HttpClient httpClient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		HttpGet httpGet = new HttpGet(URLUtil.encode(urlParam));
				
		try {

			HttpResponse response = httpClient.execute(httpGet, localContext);

			HttpEntity entity = response.getEntity();

			return getASCIIContentFromEntity(entity);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
