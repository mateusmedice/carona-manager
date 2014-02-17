package br.com.carona.manager.business;

import java.util.List;

import br.com.carona.manager.model.City;

public interface CityBusiness {

	List<City> getByState(String uf);

	List<City> getAllCities();
	
}
