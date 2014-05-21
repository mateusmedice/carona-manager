package br.com.carona.manager.business;

import java.util.List;

import br.com.carona.manager.model.City;

/**
 * Interface to the City's business methods.
 */
public interface CityBusiness {

	/**
	 * Returns the cities by state.
	 * 
	 * @param uf - State
	 * @return List of City
	 */
	List<City> getByState(String uf);

}
