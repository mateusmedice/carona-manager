package br.com.carona.manager.activity;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.carona.manager.rest.util.AbstractAsyncUtil;
import br.com.carona.manager.service.MainAsyncService;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	public void onClick(View view) {

		AbstractAsyncUtil asyncUltil = new MainAsyncService() {

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

		asyncUltil.execute("http://www.cheesejedi.com/rest_services/get_big_cheese.php?puzzle=1");

	}


}
