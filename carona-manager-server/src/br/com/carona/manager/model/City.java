package br.com.carona.manager.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 
 * 
 * @author mateus.medice
 *
 */
@XmlRootElement
@SuppressWarnings("serial")
public class City implements Serializable {

	private String id;
	
	private Integer codigo;
	
	private String nome;
	
	private String nomeTratado;
	
	private String uf;
	
	private Integer capital;
	
	/**
	 * Construtor Padrão
	 */
	public City() {
		
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the nomeTratado
	 */
	public String getNomeTratado() {
		return nomeTratado;
	}

	/**
	 * @param nomeTratado the nomeTratado to set
	 */
	public void setNomeTratado(String nomeTratado) {
		this.nomeTratado = nomeTratado;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @return the capital
	 */
	public Integer getCapital() {
		return capital;
	}

	/**
	 * @param capital the capital to set
	 */
	public void setCapital(Integer capital) {
		this.capital = capital;
	}
	
}
