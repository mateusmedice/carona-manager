package br.com.carona.manager.dao;

import java.util.List;

import br.com.carona.manager.model.City;

/**
 * Interface to City's DAO's Methods.
 */
public interface CityDAO {

	/**
	 * Return a list of City by state.
	 * 
	 * @param uf - State.
	 * @return List of City.
	 */
	List<City> getByState(String uf);
	
}
