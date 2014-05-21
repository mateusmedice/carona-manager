package br.com.carona.manager.activity.service;

import br.com.carona.manager.activity.util.AbstractAsync;

public abstract class AsyncService extends AbstractAsync {
	
	protected abstract void onPostExecute(Object results);

	@Override
	protected String doInBackground(Object... params) {

		try {
			
			if (params == null || params.length == 0) {
				return null;
			}
			
			return this.callGetWebservice(params[0].toString());
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
