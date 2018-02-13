package com.berto.varios;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class PagedList<T> {

	@XmlAttribute
	public String style;

	@XmlElements({ @XmlElement(name = "titulo", type = TextosMensaje.class),
			@XmlElement(name = "informacion", type = TextosMensaje.class),
			@XmlElement(name = "instrucciones", type = TextosMensaje.class)
	// additional as needed
	})
	public List<T> items;
}