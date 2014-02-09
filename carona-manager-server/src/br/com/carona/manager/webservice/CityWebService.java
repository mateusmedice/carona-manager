package br.com.carona.manager.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.carona.manager.business.CityBusiness;
import br.com.carona.manager.business.impl.CityBusinessImpl;

import com.google.gson.Gson;

@Path("/city")
public class CityWebService {
	
	@GET
	@Path("/{uf}")
	@Produces("application/json")
	public String getCityByState(@PathParam("uf") String uf) {

		CityBusiness cityBusiness = new CityBusinessImpl();
		
		Gson gson = new Gson();
		
		return gson.toJson(cityBusiness.getByState(uf));
	}
}
