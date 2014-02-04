package br.com.carona.manager.dao.impl;

import java.io.Serializable;

import br.com.carona.manager.dao.DAO;

public class DAOImpl <T, PK extends Serializable> implements DAO <T, PK> {

	@Override
	public T getByID(PK id) {
		
		return null;
	}

}
