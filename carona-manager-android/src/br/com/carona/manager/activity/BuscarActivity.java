package br.com.carona.manager.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import br.com.carona.manager.activity.adapter.PostListAdapter;
import br.com.carona.manager.activity.model.vo.PostVO;
import br.com.carona.manager.activity.service.AsyncService;
import br.com.carona.manager.activity.util.AbstractAsync;
import br.com.carona.manager.activity.util.Constants;

public class BuscarActivity extends Activity {

	private ListView postLisView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar);

		loadSpinnerUfFrom();
		loadSpinnerUfTo();
	}
	
	public void findPost(View view) {
		
		try {

			String paramsUrl = "?";
			
			Spinner spinnerUfFrom = (Spinner) findViewById(R.id.spinnerUfFromFind);
			String ufFrom = (String) spinnerUfFrom.getSelectedItem();
			
			Spinner spinnerCityFrom = (Spinner) findViewById(R.id.spinnerCityFromFind);
			String cityFrom = (String) spinnerCityFrom.getSelectedItem();
			
			Spinner spinnerUfTo = (Spinner) findViewById(R.id.spinnerUfToFind);
			String ufTo = (String) spinnerUfTo.getSelectedItem();
			
			Spinner spinnerCityTo = (Spinner) findViewById(R.id.spinnerCityToFind);
			String cityTo = (String) spinnerCityTo.getSelectedItem();

			if (cityFrom == null || cityFrom.isEmpty()) {
				Toast.makeText(getApplicationContext(), "You must select one City From", Toast.LENGTH_LONG).show();
				return;
			}

			if (cityTo == null || cityTo.isEmpty()) {
				Toast.makeText(getApplicationContext(), "You must select one City To", Toast.LENGTH_LONG).show();
				return;
			}
			
			if (ufTo == null || ufTo.isEmpty()) {
				Toast.makeText(getApplicationContext(), "You must select one UF To", Toast.LENGTH_LONG).show();
				return;
			}
			
			if (ufFrom == null || ufFrom.isEmpty()) {
				Toast.makeText(getApplicationContext(), "You must select one UF From", Toast.LENGTH_LONG).show();
				return;
			}
			
			paramsUrl += "ufFrom=" +  ufFrom;
			paramsUrl += "&cityFrom=" + cityFrom;
			paramsUrl += "&ufTo=" + ufTo;
			paramsUrl += "&cityTo=" + cityTo;
			
			final String paramsFinal = paramsUrl;

			final ProgressDialog progressDialog = 
				ProgressDialog.show(BuscarActivity.this, "In progress", "Loading...");
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					AbstractAsync asyncUltil = new AsyncService() {

						@Override
						protected void onPostExecute(Object results) {
							
						
							try {
								
								if (results == null) {
									return;
								}
								
								String json = results.toString();
								
								JSONArray jsonArray = new JSONArray(json);
								
								List<PostVO> postVOList = new ArrayList<PostVO>();
								
								for (int i = 0; i < jsonArray.length(); i++) {
									
									JSONObject jsonObject = jsonArray.getJSONObject(i);
									
									PostVO postVO = new PostVO(
										jsonObject.getString("userName"), 
										jsonObject.getString("hour"), 
										jsonObject.getString("description"), 
										jsonObject.getString("contact"));
									
									postVOList.add(postVO);
								}
								
								postLisView = (ListView) findViewById(R.id.postList);
								postLisView.setAdapter(new PostListAdapter(getApplicationContext(), R.layout.list_item, postVOList));
								
								
							} catch (Exception e) {
								throw new RuntimeException(e);
							}

							progressDialog.dismiss();
						}						
					};

					asyncUltil.execute(Constants.WS_SERVER_ADDRESS + "post/find" + paramsFinal);
				}
				
			}).start();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	private void loadSpinnerUfTo() {
		
		Spinner spinnerUfTo = (Spinner) findViewById(R.id.spinnerUfToFind);

		final List<Object> listState = Constants.getStateSpinner();

		spinnerUfTo.setAdapter(getArrayAdapter(listState));
		
		spinnerUfTo.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
				
				String selectedState = (String) listState.get(position);
				
				if (selectedState != null && !selectedState.isEmpty()) {
					loadCitySpinnerByState(selectedState, R.id.spinnerCityToFind);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) { }
		});

		
	}

	private void loadSpinnerUfFrom() {
		
		Spinner spinnerUfFrom = (Spinner) findViewById(R.id.spinnerUfFromFind);

		final List<Object> listState = Constants.getStateSpinner();
		
		spinnerUfFrom.setAdapter(getArrayAdapter(listState));

		spinnerUfFrom.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
				
				String selectedState = (String) listState.get(position);
				
				if (selectedState != null && !selectedState.isEmpty()) {
					loadCitySpinnerByState(selectedState, R.id.spinnerCityFromFind);
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
			ProgressDialog.show(BuscarActivity.this, "In progress", "Loading...");
		
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
