package com.berto.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "matricula")
public class Matricula {

	private String id;
	private String client;
	private String lote;
	private String reference;
	private Integer quantity;
	private List<Matricula> matriculaList;

	public Matricula() {
	}

	public Matricula(String id, String client, String lote, String reference,
			Integer quantity, List<Matricula> matriculaList) {
		super();
		this.id = id;
		this.client = client;
		this.lote = lote;
		this.reference = reference;
		this.quantity = quantity;
		this.matriculaList = matriculaList;
	}

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "client")
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@XmlElement(name = "lote")
	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	@XmlElement(name = "reference")
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@XmlElement(name = "quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@XmlElement(name = "contenido")
	public List<Matricula> getMatriculaList() {
		return matriculaList;
	}

	public void setMatriculaList(List<Matricula> matriculaList) {
		this.matriculaList = matriculaList;
	}

}
