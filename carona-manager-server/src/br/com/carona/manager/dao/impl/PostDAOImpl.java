package br.com.carona.manager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.carona.manager.dao.PostDAO;
import br.com.carona.manager.model.Post;
import br.com.carona.manager.util.ConnectionUtil;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * Implementation of PostDAO.
 */
public class PostDAOImpl implements PostDAO {

	/**
	 * @see br.com.carona.manager.dao.PostDAO#getPostBy(String, String, String, String)
	 */
	@Override
	public List<Post> getPostBy(String ufFrom, String cityFrom, String ufTo, String cityTo) {
		

		DB db = ConnectionUtil.getInstance().getMongoDB();
		
		DBCollection postCollection = db.getCollection("post");
		
		BasicDBObject query = new BasicDBObject();

		query.append("from_uf", ufFrom);
		query.append("from_city", cityFrom);
		query.append("to_uf", ufTo);
		query.append("to_city", cityTo);

		BasicDBObject order = new BasicDBObject();
		order.append("hour", 0);

		DBCursor cursor = postCollection.find(query).sort(order);
		
		List<Post> posts = new ArrayList<Post>();
		
		while (cursor.hasNext()) {
			
			Post post = new Post();
			
			DBObject currentPost = cursor.next();

			post.setUserName(currentPost.get("user_name").toString());
			post.setDescription(currentPost.get("description").toString());
			post.setHour(currentPost.get("hour").toString());
			post.setContact(currentPost.get("contact").toString());
			
			posts.add(post);
		}
		
		return posts;
	}

	@Override
	public void save(Post post) {
		
	}

}
