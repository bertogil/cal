package com.berto.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Environment entity
 */

@XmlRootElement(name = "totalesSeccion")
public class TotalSections implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String idSimulation;
	private String totalDeliveryNotes;
	private String totalTime;
	private String totalRrhh;
	private String totalAdicional;

	private List<TotalSection> totalSectionList = new ArrayList<TotalSection>();

	public TotalSections(String idSimulation, String totalDeliveryNotes,
			String totalTime, String totalRrhh, String totalAdicional,
			List<TotalSection> totalSectionList) {
		super();
		this.idSimulation = idSimulation;
		this.totalDeliveryNotes = totalDeliveryNotes;
		this.totalTime = totalTime;
		this.totalRrhh = totalRrhh;
		this.totalAdicional = totalAdicional;
		this.totalSectionList = totalSectionList;
	}

	public TotalSections() {
	}

	@XmlElement(name = "idSimulacion")
	public String getIdSimulation() {
		return idSimulation;
	}

	public void setIdSimulation(String idSimulation) {
		this.idSimulation = idSimulation;
	}

	@XmlElement(name = "totalPedidos")
	public String getTotalDeliveryNotes() {
		return totalDeliveryNotes;
	}

	public void setTotalDeliveryNotes(String totalDeliveryNotes) {
		this.totalDeliveryNotes = totalDeliveryNotes;
	}

	@XmlElement(name = "totalTiempo")
	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	@XmlElement(name = "totalRRHH")
	public String getTotalRrhh() {
		return totalRrhh;
	}

	public void setTotalRrhh(String totalRrhh) {
		this.totalRrhh = totalRrhh;
	}

	@XmlElement(name = "totalAdicional")
	public String getTotalAdicional() {
		return totalAdicional;
	}

	public void setTotalAdicional(String totalAdicional) {
		this.totalAdicional = totalAdicional;
	}

	@XmlElement(name = "seccion")
	public List<TotalSection> getTotalSectionList() {
		return totalSectionList;
	}

	public void setTotalSectionList(List<TotalSection> totalSectionList) {
		this.totalSectionList = totalSectionList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idSimulation == null) ? 0 : idSimulation.hashCode());
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
		TotalSections other = (TotalSections) obj;
		if (idSimulation == null) {
			if (other.idSimulation != null)
				return false;
		} else if (!idSimulation.equals(other.idSimulation))
			return false;
		return true;
	}

	public static TotalSections clone(TotalSections error) {
		try {
			return (TotalSections) error.clone();
		} catch (CloneNotSupportedException e) {
			// not possible
		}
		return null;
	}
}