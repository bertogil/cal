package com.berto.varios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.berto.xml.SectionsConfiguration;

/**
 * @author berto.gil
 * 
 */

@XmlRootElement(name = "configuraciones")
public class ConfigParms implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private String store;
	private String client;

	private List<SectionsConfiguration> sectionsConfigurationList = new ArrayList<SectionsConfiguration>();

	public ConfigParms(String store, String client,
			List<SectionsConfiguration> sectionsConfigurationList) {
		super();
		this.store = store;
		this.client = client;
		this.sectionsConfigurationList = sectionsConfigurationList;
	}

	public ConfigParms() {
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
	public List<SectionsConfiguration> getSectionsConfigurationList() {
		return sectionsConfigurationList;
	}

	public void setSectionsConfigurationList(
			List<SectionsConfiguration> sectionsConfigurationList) {
		this.sectionsConfigurationList = sectionsConfigurationList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((store == null) ? 0 : store.hashCode());
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
		ConfigParms other = (ConfigParms) obj;
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
			return false;
		return true;
	}

	public static ConfigParms clone(ConfigParms error) {
		try {
			return (ConfigParms) error.clone();
		} catch (CloneNotSupportedException e) {
			// not possible
		}
		return null;
	}
}