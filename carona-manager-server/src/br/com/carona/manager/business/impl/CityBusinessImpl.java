package br.com.carona.manager.business.impl;

import java.util.List;

import br.com.carona.manager.business.CityBusiness;
import br.com.carona.manager.dao.CityDAO;
import br.com.carona.manager.dao.impl.CityDAOImpl;
import br.com.carona.manager.model.City;

/**
 * 
 * @author Discover Technology
 *
 */
public class CityBusinessImpl implements CityBusiness {

	private CityDAO cityDAO;
	
	/**
	 * Construtor Padrão
	 */
	public CityBusinessImpl() {
		if (this.cityDAO == null) {
			this.cityDAO = new CityDAOImpl();
		}
	}
	
	/**
	 * @see 
	 */
	@Override
	public List<City> getByState(String uf) {
		
		if (uf == null || uf.isEmpty()) {
			throw new IllegalArgumentException("UF can't be null or empty");
		}
		
		return this.cityDAO.getByState(uf);
	}

	@Override
	public List<City> getAllCities() {
		
		return this.cityDAO.getAllCities();
	}

}
