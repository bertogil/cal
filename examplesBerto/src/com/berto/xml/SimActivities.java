package com.berto.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Environment entity
 */

@XmlRootElement(name = "actividades")
public class SimActivities implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String idSimulation;
	private String section;
	private String code;
	private String status;
	private String typeBox;
	private String typeMachinist;
	private String valueTime;
	private String timeFixed;
	private String productiveness;
	private String minimeTime;
	private String maxTime;

	private List<SimActivities> activitiesList = new ArrayList<SimActivities>();

	public SimActivities(String idSimulation, String section,
			String code, String status, String typeBox, String typeMachinist,
			String valueTime, String timeFixed, String productiveness,
			String minimeTime, String maxTime,
			List<SimActivities> activitiesList) {
		super();
		this.idSimulation = idSimulation;
		this.section = section;
		this.code = code;
		this.status = status;
		this.typeBox = typeBox;
		this.typeMachinist = typeMachinist;
		this.valueTime = valueTime;
		this.timeFixed = timeFixed;
		this.productiveness = productiveness;
		this.minimeTime = minimeTime;
		this.maxTime = maxTime;
		this.activitiesList = activitiesList;
	}

	public SimActivities() {
	}

	public SimActivities(String idSimulation, String store, String client, String section,
			String code, String status, String typeBox, String typeMachinist,
			String valueTime, String timeFixed, String productiveness,
			String minimeTime, String maxTime) {
	}
	
	@XmlElement(name = "idSimulacion")
	public String getIdSimulation() {
		return idSimulation;
	}

	public void setIdSimulation(String idSimulation) {
		this.idSimulation = idSimulation;
	}

	@XmlElement(name = "seccion")
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@XmlElement(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement(name = "tipoCaja")
	public String getTypeBox() {
		return typeBox;
	}

	public void setTypeBox(String typeBox) {
		this.typeBox = typeBox;
	}

	@XmlElement(name = "tipoOperario")
	public String getTypeMachinist() {
		return typeMachinist;
	}

	public void setTypeMachinist(String typeMachinist) {
		this.typeMachinist = typeMachinist;
	}

	@XmlElement(name = "valorTiempo")
	public String getValueTime() {
		return valueTime;
	}

	public void setValueTime(String valueTime) {
		this.valueTime = valueTime;
	}

	@XmlElement(name = "tiempoFijo")
	public String getTimeFixed() {
		return timeFixed;
	}

	public void setTimeFixed(String timeFixed) {
		this.timeFixed = timeFixed;
	}

	@XmlElement(name = "productividad")
	public String getProductiveness() {
		return productiveness;
	}

	public void setProductiveness(String productiveness) {
		this.productiveness = productiveness;
	}

	@XmlElement(name = "tiempoMinimo")
	public String getMinimeTime() {
		return minimeTime;
	}

	public void setMinimeTime(String minimeTime) {
		this.minimeTime = minimeTime;
	}

	@XmlElement(name = "tiempoMaximo")
	public String getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(String maxTime) {
		this.maxTime = maxTime;
	}

	@XmlElement(name = "codigo")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@XmlElement(name = "actividad")
	public List<SimActivities> getActivitiesList() {
		return activitiesList;
	}

	public void setActivitiesList(List<SimActivities> activitiesList) {
		this.activitiesList = activitiesList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		SimActivities other = (SimActivities) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	public static SimActivities clone(SimActivities error) {
		try {
			return (SimActivities) error.clone();
		} catch (CloneNotSupportedException e) {
			// not possible
		}
		return null;
	}
}