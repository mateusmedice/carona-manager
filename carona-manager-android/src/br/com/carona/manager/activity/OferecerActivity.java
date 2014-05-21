package br.com.carona.manager.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import br.com.carona.manager.activity.service.AsyncService;
import br.com.carona.manager.activity.util.AbstractAsync;
import br.com.carona.manager.activity.util.Constants;

public class OferecerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_oferecer);

		loadSpinnerUfFrom();
		loadSpinnerUfTo();
	}

	public void savePost(View view) {
		
		try {
			
			String paramsUrl = "?";
			
			Spinner spinnerUfFrom = (Spinner) findViewById(R.id.spinnerUfFrom);
			String ufFrom = (String) spinnerUfFrom.getSelectedItem();
			
			Spinner spinnerCityFrom = (Spinner) findViewById(R.id.spinnerCityFrom);
			String cityFrom = (String) spinnerCityFrom.getSelectedItem();
			
			Spinner spinnerUfTo = (Spinner) findViewById(R.id.spinnerUfTo);
			String ufTo = (String) spinnerUfTo.getSelectedItem();
			
			Spinner spinnerCityTo = (Spinner) findViewById(R.id.spinnerCityTo);
			String cityTo = (String) spinnerCityTo.getSelectedItem();

			EditText contactEdiTText = (EditText) findViewById(R.id.contactId);
			String contact = contactEdiTText.getText().toString();
			
			EditText descriptionEdiTText = (EditText) findViewById(R.id.descriptionId);
			String description = descriptionEdiTText.getText().toString();
			
			DatePicker hourDatePicker = (DatePicker) findViewById(R.id.whereDateId);

			Calendar date = Calendar.getInstance();
			date.set(Calendar.DAY_OF_MONTH, hourDatePicker.getDayOfMonth());
			date.set(Calendar.MONTH, hourDatePicker.getMonth());
			date.set(Calendar.YEAR, hourDatePicker.getYear());
			
			String hour = ((Long) date.getTime().getTime()).toString();
			
			String idUsuario = "528108a01c5063fd4c85020c";
			String userName = "mateus.medice";
			
			paramsUrl += "idUsuario=" + idUsuario;
			paramsUrl += "&userName=" + userName;
			paramsUrl += "&hour=" + hour;
			paramsUrl += "&description=" + description;
			paramsUrl += "&contact=" + contact;
			paramsUrl += "&ufFrom=" + ufFrom;
			paramsUrl += "&cityFrom=" + cityFrom;
			paramsUrl += "&ufTo=" + ufTo;
			paramsUrl += "&cityTo=" + cityTo;

			final String paramsFinal = paramsUrl;
			
			final ProgressDialog progressDialog = 
				ProgressDialog.show(OferecerActivity.this, "In progress", "Loading...");

			new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					AbstractAsync asyncUltil = new AsyncService() {

						@Override
						protected void onPostExecute(Object results) {
							
							if (results == null) {
								Toast.makeText(getApplicationContext(), "Sorry, we are having some problems! Please try again later!", Toast.LENGTH_LONG).show();
								return;
							}
							
							if (("1").equals(results.toString())) {
								Toast.makeText(getApplicationContext(), "Post successfully saved!", Toast.LENGTH_LONG).show();
								startActivity(new Intent(getApplicationContext(), HomeActivity.class));	
							} else {
								Toast.makeText(getApplicationContext(), "Sorry, we are having some problems! Please try again later!", Toast.LENGTH_LONG).show();
							}
							
							progressDialog.dismiss();		
						}
					};

					asyncUltil.execute(Constants.WS_SERVER_ADDRESS + "post/save" + paramsFinal);			
					
				}
			}).start();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	private void loadSpinnerUfTo() {
		
		Spinner spinnerUfTo = (Spinner) findViewById(R.id.spinnerUfTo);

		final List<Object> listState = Constants.getStateSpinner();

		spinnerUfTo.setAdapter(getArrayAdapter(listState));
		
		spinnerUfTo.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
				
				String selectedState = (String) listState.get(position);
				
				if (selectedState != null && !selectedState.isEmpty()) {
					loadCitySpinnerByState(selectedState, R.id.spinnerCityTo);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) { }
		});
	}

	private void loadSpinnerUfFrom() {
		
		Spinner spinnerUfFrom = (Spinner) findViewById(R.id.spinnerUfFrom);

		final List<Object> listState = Constants.getStateSpinner();
		
		spinnerUfFrom.setAdapter(getArrayAdapter(listState));

		spinnerUfFrom.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
				
				String selectedState = (String) listState.get(position);
				
				if (selectedState != null && !selectedState.isEmpty()) {
					loadCitySpinnerByState(selectedState, R.id.spinnerCityFrom);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) { }
		});

	}

	private void loadCitySpinnerByState(final String state, final int spinnerId) {

		if (state == null || state.isEmpty()) {
			return;
		}

		final ProgressDialog progressDialog = 
			ProgressDialog.show(OferecerActivity.this, "In progress", "Loading...");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				AbstractAsync asyncUltil = new AsyncService() {

					@Override
					protected void onPostExecute(Object results) {
						
						Spinner spinner = (Spinner) findViewById(spinnerId);
							
						String json = results.toString();
						
						try {
						
							JSONArray array = new JSONArray(json);
					
							List<Object> listCity = new ArrayList<Object>();
							
							listCity.add("");
							
							for (int i = 0; i < array.length(); i++) {
								
								JSONObject jsonObject = array.getJSONObject(i);
								
								listCity.add(jsonObject.getString("nome"));
							}
							
							spinner.setAdapter(getArrayAdapter(listCity));
							
						} catch (Exception e) {
							throw new RuntimeException(e);
						}

						progressDialog.dismiss();
					}
				};

				asyncUltil.execute(Constants.WS_SERVER_ADDRESS + "city/cityByState/" + state);
			}
		}).start();
	}
	
	private ArrayAdapter<Object> getArrayAdapter(List<Object> list) {

		ArrayAdapter<Object> adapterStateList = new ArrayAdapter<Object>(
			this, android.R.layout.simple_list_item_1, list);
		
		adapterStateList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		return adapterStateList;
		
	}
	
}
