package com.berto.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.berto.varios.TextosMensaje;

@XmlRootElement(name = "avisos")
public class Aviso {

	private String id;

	private List<TextosMensaje> tituloList;
	private List<TextosMensaje> informacionList;
	private List<TextosMensaje> instruccionesList;

	private List<Aviso> avisoList;

	public Aviso() {
	}

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElementWrapper(name = "titulo")
	@XmlElement(name = "linea")
	public List<TextosMensaje> getTituloList() {
		return tituloList;
	}

	public void setTituloList(List<TextosMensaje> tituloList) {
		this.tituloList = tituloList;
	}

	@XmlElementWrapper(name = "informacion")
	@XmlElement(name = "linea")
	public List<TextosMensaje> getInformacionList() {
		return informacionList;
	}

	public void setInformacionList(List<TextosMensaje> informacionList) {
		this.informacionList = informacionList;
	}

	@XmlElementWrapper(name = "instrucciones")
	@XmlElement(name = "linea")
	public List<TextosMensaje> getInstruccionesList() {
		return instruccionesList;
	}

	public void setInstruccionesList(List<TextosMensaje> instruccionesList) {
		this.instruccionesList = instruccionesList;
	}

	@XmlElement(name = "aviso")
	public List<Aviso> getAvisoList() {
		return avisoList;
	}

	public void setAvisoList(List<Aviso> avisoList) {
		this.avisoList = avisoList;
	}

}
