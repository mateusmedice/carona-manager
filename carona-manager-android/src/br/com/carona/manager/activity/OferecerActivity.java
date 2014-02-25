package br.com.carona.manager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;
import br.com.carona.manager.activity.service.LoginAsyncService;
import br.com.carona.manager.activity.util.AbstractAsync;

public class OferecerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_oferecer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.oferecer, menu);
		return true;
	}

	public void loadToCities(View view) {

		Spinner spinnerUfTo = (Spinner) findViewById(R.id.spinnerUfFrom);
		// TODO: Chamar ws para buscar cidades do estado
		
		AbstractAsync asyncUltil = new LoginAsyncService() {
			
			@Override
			protected void onPostExecute(Object results) {

				// TODO: Carregar combo com o response
				Spinner spinnerCitiesTo = (Spinner) findViewById(R.id.spinerCityTo);
						
			}
		};		
		
		asyncUltil.execute("http://169.254.80.80:8080/carona-manager-server/city/cityByState/SP");
		
	}
	
}
