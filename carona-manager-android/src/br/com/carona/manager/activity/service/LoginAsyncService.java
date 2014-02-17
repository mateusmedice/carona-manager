package br.com.carona.manager.activity.service;

import br.com.carona.manager.activity.util.AbstractAsync;

public abstract class LoginAsyncService extends AbstractAsync {

	protected abstract void onPostExecute(Object results);

	@Override
	protected String doInBackground(Object... params) {
		
		try {
			
			return this.callWebservice(params[0].toString());

		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

}
