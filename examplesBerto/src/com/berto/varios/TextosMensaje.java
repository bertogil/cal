package com.berto.varios;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;

public class TextosMensaje {

	private String linea;
	private String style;

	public TextosMensaje() {
	}

	@XmlValue
	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	@XmlAttribute
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
