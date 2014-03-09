package br.com.carona.manager.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.my_button).setOnClickListener(this);
		
		Button b = (Button) findViewById(R.id.my_button);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(LoginActivity.this, "Teste!", Toast.LENGTH_LONG).show();

				Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View view) {

		/*AbstractAsync asyncUltil = new LoginAsyncService() {

			@Override
			protected void onPostExecute(Object results) {
				
				if (results != null) {
					EditText et = (EditText) findViewById(R.id.my_edit);
					
					et.setText(results.toString());
				}

				

				//b.setClickable(true);

			}
		};

*/		//asyncUltil.execute("http://169.254.80.80:8080/carona-manager-server/city/cityByState/SP");

	}

}
