package br.com.carona.manager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import br.com.carona.manager.activity.fragment.MainFragment;

public class LoginActivity extends FragmentActivity {

	private MainFragment mainFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		if (savedInstanceState == null) {

			// Add the fragment on initial activity setup
			mainFragment = new MainFragment();

			getSupportFragmentManager().beginTransaction()
					.add(android.R.id.content, mainFragment).commit();

		} else {

			// Or set the fragment from restored state info
			mainFragment = (MainFragment) getSupportFragmentManager()
					.findFragmentById(android.R.id.content);

		}

	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
		
		startActivity(intent);
	}
		
}
