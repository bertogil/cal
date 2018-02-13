package com.berto.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Environment entity
 */
@XmlRootElement(name = "secciones")
public class Section implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String description;

	private int totalLines;
	private int linesUnits;
	private int totalUnits;
	private int linesBoxes;
	private int totalBoxes;
	private int linesPalets;
	private int totalPalets;
	private int totalBundles;
	private Float totalKilos;
	private Float totalVolume;

	private List<DeliveryNote> deliveryNotesList = new ArrayList<DeliveryNote>();

	public Section(String id, String description, int totalLines,
			int linesUnits, int totalUnits, int linesBoxes, int totalBoxes,
			int linesPalets, int totalPalets, int totalBundles,
			Float totalKilos, Float totalVolume,
			List<DeliveryNote> deliveryNotesList) {
		super();
		this.id = id;
		this.description = description;
		this.totalLines = totalLines;
		this.linesUnits = linesUnits;
		this.totalUnits = totalUnits;
		this.linesBoxes = linesBoxes;
		this.totalBoxes = totalBoxes;
		this.linesPalets = linesPalets;
		this.totalPalets = totalPalets;
		this.totalBundles = totalBundles;
		this.totalKilos = totalKilos;
		this.totalVolume = totalVolume;
		this.deliveryNotesList = deliveryNotesList;

	}

	public Section() {
	}

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name = "desc")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name = "totalLineas")
	public int getTotalLines() {
		return totalLines;
	}

	public void setTotalLines(int totalLines) {
		this.totalLines = totalLines;
	}

	@XmlElement(name = "lineasUnids")
	public int getLinesUnits() {
		return linesUnits;
	}

	public void setLinesUnits(int linesUnits) {
		this.linesUnits = linesUnits;
	}

	@XmlElement(name = "totalUnids")
	public int getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(int totalUnits) {
		this.totalUnits = totalUnits;
	}

	@XmlElement(name = "lineasCajas")
	public int getLinesBoxes() {
		return linesBoxes;
	}

	public void setLinesBoxes(int linesBoxes) {
		this.linesBoxes = linesBoxes;
	}

	@XmlElement(name = "totalCajas")
	public int getTotalBoxes() {
		return totalBoxes;
	}

	public void setTotalBoxes(int totalBoxes) {
		this.totalBoxes = totalBoxes;
	}

	@XmlElement(name = "lineasPalets")
	public int getLinesPalets() {
		return linesPalets;
	}

	public void setLinesPalets(int linesPalets) {
		this.linesPalets = linesPalets;
	}

	@XmlElement(name = "totalPalets")
	public int getTotalPalets() {
		return totalPalets;
	}

	public void setTotalPalets(int totalPalets) {
		this.totalPalets = totalPalets;
	}

	@XmlElement(name = "totalBultos")
	public int getTotalBundles() {
		return totalBundles;
	}

	public void setTotalBundles(int totalBundles) {
		this.totalBundles = totalBundles;
	}

	@XmlElement(name = "totalKilos")
	public Float getTotalKilos() {
		return totalKilos;
	}

	public void setTotalKilos(Float totalKilos) {
		this.totalKilos = totalKilos;
	}

	@XmlElement(name = "totalVolumen")
	public Float getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(Float totalVolume) {
		this.totalVolume = totalVolume;
	}

	@XmlElementWrapper(name = "documentos")
	@XmlElement(name = "documento")
	public List<DeliveryNote> getDeliveryNotesList() {
		return deliveryNotesList;
	}

	public void setDeliveryNotesList(List<DeliveryNote> deliveryNotesList) {
		this.deliveryNotesList = deliveryNotesList;
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
		Section other = (Section) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static Section clone(Section error) {
		try {
			return (Section) error.clone();
		} catch (CloneNotSupportedException e) {
			// not possible
		}
		return null;
	}
}