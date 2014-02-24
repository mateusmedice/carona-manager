package br.com.carona.manager.activity;

import br.com.carona.manager.activity.OferecerActivity;
import br.com.carona.manager.activity.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		Button BotaoOferecer = (Button) findViewById(R.id.btnOferecer);
		BotaoOferecer.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(HomeActivity.this, "Oferecer!", Toast.LENGTH_LONG).show();

					Intent intent = new Intent(HomeActivity.this, OferecerActivity.class);
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
	
}
