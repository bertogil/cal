package com.berto.xml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Environment entity
 */
public class TotalSection implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String totalDeliveryNotes;
	private String totalTime;
	private String totalRrhh;
	private String totalAdicional;

	public TotalSection(String id, String totalDeliveryNotes, String totalTime,
			String totalRrhh, String totalAdicional) {
		super();
		this.id = id;
		this.totalDeliveryNotes = totalDeliveryNotes;
		this.totalTime = totalTime;
		this.totalRrhh = totalRrhh;
		this.totalAdicional = totalAdicional;
	}

	public TotalSection() {
	}

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@XmlElement(name = "tiempoRRHH")
	public String getTotalRrhh() {
		return totalRrhh;
	}

	public void setTotalRrhh(String totalRrhh) {
		this.totalRrhh = totalRrhh;
	}

	@XmlElement(name = "tiempoAdicional")
	public String getTotalAdicional() {
		return totalAdicional;
	}

	public void setTotalAdicional(String totalAdicional) {
		this.totalAdicional = totalAdicional;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TotalSection other = (TotalSection) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static TotalSection clone(TotalSection error) {
		try {
			return (TotalSection) error.clone();
		} catch (CloneNotSupportedException e) {
			// not possible
		}
		return null;
	}
}