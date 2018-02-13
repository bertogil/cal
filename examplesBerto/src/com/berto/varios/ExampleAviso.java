package com.berto.varios;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "aviso")
public class ExampleAviso {

	@XmlElement
	public PagedList<TextosMensaje> tituloList;
	@XmlElement
	public PagedList<TextosMensaje> informacionList;
	@XmlElement
	public PagedList<TextosMensaje> instruccionesList;

	public PagedList<TextosMensaje> getTituloList() {
		return tituloList;
	}

	public void setTituloList(PagedList<TextosMensaje> tituloList) {
		this.tituloList = tituloList;
	}

	public PagedList<TextosMensaje> getInformacionList() {
		return informacionList;
	}

	public void setInformacionList(PagedList<TextosMensaje> informacionList) {
		this.informacionList = informacionList;
	}

	public PagedList<TextosMensaje> getInstruccionesList() {
		return instruccionesList;
	}

	public void setInstruccionesList(PagedList<TextosMensaje> instruccionesList) {
		this.instruccionesList = instruccionesList;
	}

}
