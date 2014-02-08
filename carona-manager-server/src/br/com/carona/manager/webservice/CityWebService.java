package br.com.carona.manager.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.carona.manager.business.CityBusiness;
import br.com.carona.manager.business.impl.CityBusinessImpl;

@Path("city")
public class CityWebService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCityByState(@PathParam("uf") String uf) {

		CityBusiness cityBusiness = new CityBusinessImpl();
		
		cityBusiness.getByState(uf);
		
		return null;
	}
}
