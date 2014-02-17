package br.com.carona.manager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.carona.manager.dao.CityDAO;
import br.com.carona.manager.model.City;
import br.com.carona.manager.util.ConnectionUtil;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 
 * 
 * 
 * @author mateus.medice
 *
 */
public class CityDAOImpl implements CityDAO {

	/**
	 * @see 
	 */
	@Override
	public List<City> getByState(String uf) {

		DB db = ConnectionUtil.getInstance().getMongoDB();
		
		DBCollection cityCollection = db.getCollection("city");
		
		BasicDBObject query = new BasicDBObject();
		
		query.append("uf", uf);

		BasicDBObject order = new BasicDBObject();
		order.append("nome_tratado", 0);

		DBCursor cursor = cityCollection.find(query).sort(order);
		
		List<City> cities = new ArrayList<City>();
		
		while (cursor.hasNext()) {
			
			City city = new City();
			
			DBObject currentCity = cursor.next();

			city.setCodigo((Integer) currentCity.get("codigo"));
			city.setNome((String) currentCity.get("nome"));
			
			cities.add(city);
			
		}
		
		return cities;
	}
	
	/**
	 * @see 
	 */
	@Override
	public List<City> getAllCities() {

		DB db = ConnectionUtil.getInstance().getMongoDB();
		
		DBCollection cityCollection = db.getCollection("city");
		
		BasicDBObject order = new BasicDBObject();
		order.append("nome_tratado", 0);

		DBCursor cursor = cityCollection.find().sort(order);
		
		List<City> cities = new ArrayList<City>();
		
		while (cursor.hasNext()) {
			
			City city = new City();
			
			DBObject currentCity = cursor.next();

			city.setCodigo((Integer) currentCity.get("codigo"));
			city.setNome((String) currentCity.get("nome"));
			
			cities.add(city);
			
		}
		
		return cities;
	}
	
}
