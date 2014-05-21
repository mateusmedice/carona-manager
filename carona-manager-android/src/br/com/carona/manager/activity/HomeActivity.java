package br.com.carona.manager.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);	
	}
	
	public void showAbout(View view) {
		Intent intent = new Intent(this, SobreActivity.class);
		startActivity(intent);
	}

	public void showPost(View view) {
		startActivity(new Intent(this, OferecerActivity.class));
	}

	public void showFind(View view) {
		startActivity(new Intent(this, BuscarActivity.class));
	}

}
