package br.com.carona.manager.activity.model.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PostVO implements Serializable {

	private String postOwner;
	
	private String postHour;
	
	private String description;
	
	private String contact;
	
	/**
	 * Construtor Padrão
	 */
	public PostVO() {
		
	}
	
	public PostVO(String postOwner, String postHour, String description,
			String contact) {
		super();
		this.postOwner = postOwner;
		this.postHour = postHour;
		this.description = description;
		this.contact = contact;
	}

	/**
	 * @return the postOwner
	 */
	public String getPostOwner() {
		return postOwner;
	}

	/**
	 * @param postOwner the postOwner to set
	 */
	public void setPostOwner(String postOwner) {
		this.postOwner = postOwner;
	}

	/**
	 * @return the postHour
	 */
	public String getPostHour() {
		return postHour;
	}

	/**
	 * @param postHour the postHour to set
	 */
	public void setPostHour(String postHour) {
		this.postHour = postHour;
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
