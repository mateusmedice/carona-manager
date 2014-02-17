package br.com.carona.manager.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/post")
public class PostWebService {

	
	@GET
	@Path("/find")
	@Produces("application/json")
	public String find(@QueryParam("ufFrom") String ufFrom,
			   @QueryParam("cityFrom") String cityFrom,
			   @QueryParam("ufTo") String ufTo,
			   @QueryParam("cityTo") String cityTo) {
		
		return ufFrom + " - " + cityFrom + " - " + ufTo + " - " + cityTo;
	}
	
}
