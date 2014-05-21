package br.com.carona.manager.business;

import java.util.List;

import br.com.carona.manager.model.Post;

/**
 * Interface to the Post's business methods.
 */
public interface PostBusiness {

	/**
	 * return a list of Post. 
	 * 
	 * @param ufFrom - from state
	 * @param cityFrom - from city
	 * @param ufTo - to state
	 * @param cityTo - to city
	 * @return List of Post.
	 */
	List<Post> getPostBy(String ufFrom, String cityFrom, String ufTo, String cityTo);

	/**
	 * Save the Post on.
	 * 
	 * @param post - Post
	 */
	void save(Post post);
}
