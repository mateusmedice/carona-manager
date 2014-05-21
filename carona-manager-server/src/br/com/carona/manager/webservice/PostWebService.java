package br.com.carona.manager.webservice;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import br.com.carona.manager.business.PostBusiness;
import br.com.carona.manager.business.impl.PostBusinessImpl;
import br.com.carona.manager.model.City;
import br.com.carona.manager.model.Post;
import br.com.carona.manager.util.JSONUtil;

/**
 * Web service class to Post operations.
 */
@Path("/post")
public class PostWebService {

	/**
	 * Method to search the Post.
	 * 
	 * @param ufFrom
	 * @param cityFrom
	 * @param ufTo
	 * @param cityTo
	 * @return List of Post in JSON format.
	 */
	@GET
	@Path("/find")
	@Produces("application/json")
	public String find(@QueryParam("ufFrom") String ufFrom,
			   @QueryParam("cityFrom") String cityFrom,
			   @QueryParam("ufTo") String ufTo,
			   @QueryParam("cityTo") String cityTo) {
		
		PostBusiness postBusiness = new PostBusinessImpl();
		
		return JSONUtil.toJson(postBusiness.getPostBy(ufFrom, cityFrom, ufTo, cityTo));
	}

	@GET
	@Path("/save")
	@Produces("application/json")
	public String save(@QueryParam("idUsuario") String idUsuario,
			@QueryParam("userName") String userName,
			@QueryParam("hour") String hour,
			@QueryParam("description") String description,
			@QueryParam("contact") String contact,
			@QueryParam("ufFrom") String ufFrom,
			@QueryParam("cityFrom") String cityFrom,
			@QueryParam("ufTo") String ufTo,
			@QueryParam("cityTo") String cityTo) {
		
		try {
			
			Post post = new Post();
			post.setIdUsuario(idUsuario);
			post.setUserName(userName);
			
			if (hour != null) {
				
				long timestamp = Long.parseLong(hour);
				
				Calendar date = Calendar.getInstance();
				
				date.setTimeInMillis(timestamp);
				
				hour = new SimpleDateFormat("dd/MM/yyyy").format(date.getTime());
			}
			
			post.setHour(hour);
			post.setDescription(description);
			post.setContact(contact);
	
			City fromCity = new City();
			fromCity.setUf(ufFrom);
			fromCity.setNome(cityFrom);
			post.setFromCity(fromCity);
			
			City toCity = new City();
			toCity.setUf(ufTo);
			toCity.setNome(cityTo);
			post.setToCity(toCity);
			
			PostBusiness postBusiness = new PostBusinessImpl();
			
			postBusiness.save(post);
		
		} catch (Exception e) {
			throw new RuntimeException("0", e);
		}
		
		return "1";
	}
	
}
