package com.berto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author berto.gil
 * 
 */

@XmlRootElement(name = "tramosHorarios")
public class TimeRanks implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String ranks;
	private int deliveryNotes;
	private String timeRrhhAvailable;
	private String timeRrhhUtilized;
	private String timeRrhhIdleness;
	private String timeAditional;

	public TimeRanks(String ranks, int totalDeliveryNotes,
			String timeRrhhAvailable, String timeRrhhUtilized,
			String timeRrhhIdleness, String timeAditional) {
		super();
		this.ranks = ranks;
		this.deliveryNotes = totalDeliveryNotes;
		this.timeAditional = timeAditional;
		this.timeRrhhAvailable = timeRrhhAvailable;
		this.timeRrhhIdleness = timeRrhhIdleness;
		this.timeRrhhUtilized = timeRrhhUtilized;

	}

	public TimeRanks() {
	}

	@XmlAttribute(name = "tramo")
	public String getRanks() {
		return ranks;
	}

	public void setRanks(String ranks) {
		this.ranks = ranks;
	}

	@XmlElement(name = "pedidos")
	public int getDeliveryNotes() {
		return deliveryNotes;
	}

	public void setDeliveryNotes(int totalDeliveryNotes) {
		this.deliveryNotes = totalDeliveryNotes;
	}

	@XmlElement(name = "tiempoRRHHDisponible")
	public String getTimeRrhhAvailable() {
		return timeRrhhAvailable;
	}

	public void setTimeRrhhAvailable(String totalTimeRrhhAvailable) {
		this.timeRrhhAvailable = totalTimeRrhhAvailable;
	}

	@XmlElement(name = "tiempoRRHHUtilizado")
	public String getTimeRrhhUtilized() {
		return timeRrhhUtilized;
	}

	public void setTimeRrhhUtilized(String totalTimeRrhhUtilized) {
		this.timeRrhhUtilized = totalTimeRrhhUtilized;
	}

	@XmlElement(name = "tiempoRRHHOciosidad")
	public String getTimeRrhhIdleness() {
		return timeRrhhIdleness;
	}

	public void setTimeRrhhIdleness(String totalTimeRrhhIdleness) {
		this.timeRrhhIdleness = totalTimeRrhhIdleness;
	}

	@XmlElement(name = "tiempoAdicional")
	public String getTimeAditional() {
		return timeAditional;
	}

	public void setTimeAditional(String totalTimeAditional) {
		this.timeAditional = totalTimeAditional;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ranks == null) ? 0 : ranks.hashCode());
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
		TimeRanks other = (TimeRanks) obj;
		if (ranks == null) {
			if (other.ranks != null)
				return false;
		} else if (!ranks.equals(other.ranks))
			return false;
		return true;
	}

	public static TimeRanks clone(TimeRanks error) {
		try {
			return (TimeRanks) error.clone();
		} catch (CloneNotSupportedException e) {
			// not possible
		}
		return null;
	}
}