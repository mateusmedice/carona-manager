package br.com.carona.manager.activity;

import br.com.carona.manager.activity.service.LoginAsyncService;
import br.com.carona.manager.activity.util.AbstractAsync;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.my_button).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View view) {

		AbstractAsync asyncUltil = new LoginAsyncService() {

			@Override
			protected void onPostExecute(Object results) {
				
				if (results != null) {
					EditText et = (EditText) findViewById(R.id.my_edit);

					et.setText(results.toString());
				}

				Button b = (Button) findViewById(R.id.my_button);

				b.setClickable(true);

			}
		};

		asyncUltil.execute("http://localhost:8080/carona-manager-server/city/SP");

	}

}
