package br.com.carona.manager.dao;

import java.util.List;

import br.com.carona.manager.model.Post;

public interface PostDAO {

	List<Post> getPostBy(String ufFrom, String cityFrom, String ufTo, String cityTo);

	void save(Post post);
}
