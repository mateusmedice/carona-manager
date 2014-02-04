package br.com.carona.manager.dao;

import java.io.Serializable;

public interface DAO <T, PK extends Serializable> {

	T getByID(PK id);
	
}
