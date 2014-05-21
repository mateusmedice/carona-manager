package br.com.carona.manager.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.carona.manager.business.CityBusiness;
import br.com.carona.manager.business.impl.CityBusinessImpl;
import br.com.carona.manager.util.JSONUtil;

/** 
 * Web service class to City operations.
 */
@Path("/city")
public class CityWebService {
	
	/**
	 * Return the City of a State.
	 * 
	 * @param uf - State
	 * @return List of City in a JSON format.
	 */
	@GET
	@Path("/cityByState/{uf}")
	@Produces("application/json")
	public String getCityByState(@PathParam("uf") String uf) {

		CityBusiness cityBusiness = new CityBusinessImpl();
		
		return JSONUtil.toJson(cityBusiness.getByState(uf));
	}	
	
}
