package br.com.carona.manager.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.carona.manager.business.CityBusiness;
import br.com.carona.manager.business.impl.CityBusinessImpl;
import br.com.carona.manager.model.City;

@Path("/city")
public class CityWebService {
	
	@GET
	@Path("/{uf}")
	@Produces("text/xml")
	public List<City> getCityByState(@PathParam("uf") String uf) {

		CityBusiness cityBusiness = new CityBusinessImpl();
		
		return cityBusiness.getByState(uf);
	}
}
