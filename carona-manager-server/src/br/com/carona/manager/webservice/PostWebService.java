package br.com.carona.manager.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import br.com.carona.manager.business.PostBusiness;
import br.com.carona.manager.business.impl.PostBusinessImpl;
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

	@POST
	@Consumes("text/xml")
	@Produces("text/plain")
	public String save(Post post) {
		
		PostBusiness postBusiness = new PostBusinessImpl();
		
		postBusiness.save(post);
		
		return "post successful saved";
	}
	
}
