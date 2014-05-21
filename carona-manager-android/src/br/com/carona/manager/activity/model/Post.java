package br.com.carona.manager.activity.model;

import java.io.Serializable;

/**
 * Class to represent the collection Post.
 */
public class Post implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -894053621596452567L;

	private String idPost;
	
	private String idUsuario;
	
	private String userName;
	
	private String postTime;
	
	private String hour;
	
	private String description;
	
	private String contact;

	private City fromCity;
	
	private City toCity;
	
	/**
	 * Default Constructor
	 */
	public Post() {

		if (this.fromCity == null) {
			this.fromCity = new City();
		}

		if (this.toCity == null) {
			this.toCity = new City();
		}
	}

	/**
	 * @return the idPost
	 */
	public String getIdPost() {
		return idPost;
	}

	/**
	 * @param idPost the idPost to set
	 */
	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}

	/**
	 * @return the idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the postTime
	 */
	public String getPostTime() {
		return postTime;
	}

	/**
	 * @param postTime the postTime to set
	 */
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	/**
	 * @return the hour
	 */
	public String getHour() {
		return hour;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(String hour) {
		this.hour = hour;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the fromCity
	 */
	public City getFromCity() {
		return fromCity;
	}

	/**
	 * @param fromCity the fromCity to set
	 */
	public void setFromCity(City fromCity) {
		this.fromCity = fromCity;
	}

	/**
	 * @return the toCity
	 */
	public City getToCity() {
		return toCity;
	}

	/**
	 * @param toCity the toCity to set
	 */
	public void setToCity(City toCity) {
		this.toCity = toCity;
	}
	
}
