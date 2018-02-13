package com.berto.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Environment entity
 */
@XmlRootElement(name = "deliveryNotes")
public class Sections implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String store;
	private String client;

	private List<Section> sectionList = new ArrayList<Section>();

	public Sections(String store, String client, List<Section> sectionList) {
		super();
		this.store = store;
		this.client = client;
		this.sectionList = sectionList;

	}

	public Sections() {
	}

	public Sections(String store, String client) {
	}

	@XmlElement(name = "almacen")
	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	@XmlElement(name = "cliente")
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@XmlElementWrapper(name = "secciones")
	@XmlElement(name = "seccion")
	public List<Section> getSectionList() {
		return sectionList;
	}

	public void setSectionList(List<Section> sectionList) {
		this.sectionList = sectionList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sections other = (Sections) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		return true;
	}

	public static Sections clone(Sections error) {
		try {
			return (Sections) error.clone();
		} catch (CloneNotSupportedException e) {
			// not possible
		}
		return null;
	}
}