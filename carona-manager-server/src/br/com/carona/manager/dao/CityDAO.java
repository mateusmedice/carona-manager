package br.com.carona.manager.dao;

import java.util.List;

import br.com.carona.manager.model.City;

public interface CityDAO {

	List<City> getByState(String uf);

	List<City> getAllCities();
	
}
