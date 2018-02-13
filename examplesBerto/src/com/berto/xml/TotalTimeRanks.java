package com.berto.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author berto.gil
 * 
 */

@XmlRootElement(name = "totalTramos")
public class TotalTimeRanks implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String idSimulation;
	private int totalDeliveryNotes;
	private String totalTimeRrhhAvailable;
	private String totalTimeRrhhUtilized;
	private String totalTimeRrhhIdleness;
	private String totalTimeAditional;

	private List<TimeRanks> timeRanksList = new ArrayList<TimeRanks>();

	public TotalTimeRanks(String idSimulation, int totalDeliveryNotes,
			String totalTimeRrhhAvailable, String totalTimeRrhhUtilized,
			String totalTimeRrhhIdleness, String totalTimeAditional,
			List<TimeRanks> timeRanksList) {
		super();
		this.idSimulation = idSimulation;
		this.totalDeliveryNotes = totalDeliveryNotes;
		this.totalTimeAditional = totalTimeAditional;
		this.totalTimeRrhhAvailable = totalTimeRrhhAvailable;
		this.totalTimeRrhhIdleness = totalTimeRrhhIdleness;
		this.totalTimeRrhhUtilized = totalTimeRrhhUtilized;
		this.timeRanksList = timeRanksList;
	}

	public TotalTimeRanks() {
	}

	@XmlElement(name = "idSimulacion")
	public String getIdSimulation() {
		return idSimulation;
	}

	public void setIdSimulation(String idSimulation) {
		this.idSimulation = idSimulation;
	}

	@XmlElement(name = "totalPedidos")
	public int getTotalDeliveryNotes() {
		return totalDeliveryNotes;
	}

	public void setTotalDeliveryNotes(int totalDeliveryNotes) {
		this.totalDeliveryNotes = totalDeliveryNotes;
	}

	@XmlElement(name = "totalTiempoRRHHDisponible")
	public String getTotalTimeRrhhAvailable() {
		return totalTimeRrhhAvailable;
	}

	public void setTotalTimeRrhhAvailable(String totalTimeRrhhAvailable) {
		this.totalTimeRrhhAvailable = totalTimeRrhhAvailable;
	}

	@XmlElement(name = "totalTiempoRRHHUtilizado")
	public String getTotalTimeRrhhUtilized() {
		return totalTimeRrhhUtilized;
	}

	public void setTotalTimeRrhhUtilized(String totalTimeRrhhUtilized) {
		this.totalTimeRrhhUtilized = totalTimeRrhhUtilized;
	}

	@XmlElement(name = "totalTiempoRRHHOciosidad")
	public String getTotalTimeRrhhIdleness() {
		return totalTimeRrhhIdleness;
	}

	public void setTotalTimeRrhhIdleness(String totalTimeRrhhIdleness) {
		this.totalTimeRrhhIdleness = totalTimeRrhhIdleness;
	}

	@XmlElement(name = "totalTiempoAdicional")
	public String getTotalTimeAditional() {
		return totalTimeAditional;
	}

	public void setTotalTimeAditional(String totalTimeAditional) {
		this.totalTimeAditional = totalTimeAditional;
	}

	@XmlElementWrapper(name = "tramosHorarios")
	@XmlElement(name = "tramoHorario")
	public List<TimeRanks> getTimeRanksList() {
		return timeRanksList;
	}

	public void setTimeRanksList(List<TimeRanks> timeRanksList) {
		this.timeRanksList = timeRanksList;
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
		TotalTimeRanks other = (TotalTimeRanks) obj;
		if (idSimulation == null) {
			if (other.idSimulation != null)
				return false;
		} else if (!idSimulation.equals(other.idSimulation))
			return false;
		return true;
	}

	public static TotalTimeRanks clone(TotalTimeRanks error) {
		try {
			return (TotalTimeRanks) error.clone();
		} catch (CloneNotSupportedException e) {
			// not possible
		}
		return null;
	}
}