package br.com.carona.manager.business.impl;

import java.util.Calendar;
import java.util.List;

import br.com.carona.manager.business.PostBusiness;
import br.com.carona.manager.dao.PostDAO;
import br.com.carona.manager.dao.impl.PostDAOImpl;
import br.com.carona.manager.model.Post;
import br.com.carona.manager.util.DateUtil;

/**
 * Implementation of PostBusiness.
 */
public class PostBusinessImpl implements PostBusiness {

	private PostDAO postDAO;
	
	/**
	 * Default Constructor.
	 */
	public PostBusinessImpl() {
		if (postDAO == null) {
			this.postDAO = new PostDAOImpl();
		}
	}
	
	/**
	 * @see br.com.carona.manager.business.PostBusiness#getPostBy(String, String, String, String)
	 */
	@Override
	public List<Post> getPostBy(String ufFrom, String cityFrom, String ufTo, String cityTo) {

		// FIXME: Validar entrada
		
		return this.postDAO.getPostBy(ufFrom, cityFrom, ufTo, cityTo);
	}

	/**
	 * @see br.com.carona.manager.business.PostBusiness#save(Post)
	 */
	@Override
	public void save(Post post) {
		
		if (post == null) {
			throw new IllegalArgumentException("Post can't be null.");
		}
		
		post.setPostTime(
			DateUtil.formatDate(
				Calendar.getInstance().getTime(), DateUtil.SIMPLE_DATE_FORMAT));
		
		this.postDAO.save(post);
	}

}
