package br.com.carona.manager.activity.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;

import android.os.AsyncTask;

public abstract class AbstractAsync extends AsyncTask<Object, Object, Object> {
	
	protected abstract String doInBackground(Object... params);
	
	protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
		
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

}
