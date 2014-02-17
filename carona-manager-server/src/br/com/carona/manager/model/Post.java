package br.com.carona.manager.model;

import java.io.Serializable;

/**
 * 
 * @author mateus.medice
 *
 */
public class Post implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -894053621596452567L;

	private String idPost;
	
	private String idUsuario;
	
	private String userName;
	
	private String fromUF;
	
	private String fromCity;
	
	private String toUF;
	
	private String toCity;
	
	private String postTime;
	
	private String hour;
	
	private String description;
	
	private String contact;
	
	public Post() {
		
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
	 * @return the fromUF
	 */
	public String getFromUF() {
		return fromUF;
	}

	/**
	 * @param fromUF the fromUF to set
	 */
	public void setFromUF(String fromUF) {
		this.fromUF = fromUF;
	}

	/**
	 * @return the fromCity
	 */
	public String getFromCity() {
		return fromCity;
	}

	/**
	 * @param fromCity the fromCity to set
	 */
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	/**
	 * @return the toUF
	 */
	public String getToUF() {
		return toUF;
	}

	/**
	 * @param toUF the toUF to set
	 */
	public void setToUF(String toUF) {
		this.toUF = toUF;
	}

	/**
	 * @return the toCity
	 */
	public String getToCity() {
		return toCity;
	}

	/**
	 * @param toCity the toCity to set
	 */
	public void setToCity(String toCity) {
		this.toCity = toCity;
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
	
}
