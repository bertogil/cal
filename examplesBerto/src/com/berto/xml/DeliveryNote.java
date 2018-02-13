package com.berto.xml;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Environment entity
 */

@XmlRootElement(name = "documentos")
public class DeliveryNote implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String section;
	private String description;
	private String numberDeliveryNote;
	private String recipient;
	private String zipCode;
	private String route;
	private String secRoute;
	private String obrador;
	private String totalLine;
	private String unitLines;
	private String totalUnits;
	private String boxLines;
	private String totalBoxes;
	private String paletLines;
	private String totalPalets;
	private String totalBundles;
	private Float totalKilos;
	private Float totalVolume;
	private Date dateLoads;
	private Date hourLoads;

	public DeliveryNote(String section, String description,
			String numberDeliveryNote, String recipient, String zipCode,
			String route, String secRoute, String obrador, String totalLine,
			String unitLines, String totalUnits, String boxLines,
			String totalBoxes, String paletLines, String totalPalets,
			String totalBundles, Float totalKilos, Float totalVolume,
			Date dateLoads, Date hourLoads) {
		super();
		this.section = section;
		this.description = description;
		this.numberDeliveryNote = numberDeliveryNote;
		this.recipient = recipient;
		this.zipCode = zipCode;
		this.route = route;
		this.secRoute = secRoute;
		this.obrador = obrador;
		this.totalLine = totalLine;
		this.unitLines = unitLines;
		this.totalUnits = totalUnits;
		this.boxLines = boxLines;
		this.totalBoxes = totalBoxes;
		this.paletLines = paletLines;
		this.totalPalets = totalPalets;
		this.totalBundles = totalBundles;
		this.totalKilos = totalKilos;
		this.totalVolume = totalVolume;
		this.dateLoads = dateLoads;
		this.hourLoads = hourLoads;
	}

	public DeliveryNote() {
	}

	public DeliveryNote(String section, String description,
			String numberDeliveryNotes, String recipient, String zipCode,
			String route, String secRoute, String obrador, String totalLine,
			String unitLines, String totalUnits, String boxLines,
			String totalBoxes, String paletLines, String totalPalets,
			String totalBundles, String totalKilos, String totalVolume,
			Date dateLoads, Date hourLoads) {
	}

	@XmlAttribute(name = "seccId")
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@XmlAttribute(name = "seccDesc")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name = "numero")
	public String getNumberDeliveryNote() {
		return numberDeliveryNote;
	}

	public void setNumberDeliveryNote(String numberDeliveryNote) {
		this.numberDeliveryNote = numberDeliveryNote;
	}

	@XmlElement(name = "destinatario")
	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	@XmlElement(name = "codigoPostal")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@XmlElement(name = "hojaRuta")
	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	@XmlElement(name = "secHojaRuta")
	public String getSecRoute() {
		return secRoute;
	}

	public void setSecRoute(String secRoute) {
		this.secRoute = secRoute;
	}

	@XmlElement(name = "obrador")
	public String getObrador() {
		return obrador;
	}

	public void setObrador(String obrador) {
		this.obrador = obrador;
	}

	@XmlElement(name = "totalLineas")
	public String getTotalLine() {
		return totalLine;
	}

	public void setTotalLine(String totalLine) {
		this.totalLine = totalLine;
	}

	@XmlElement(name = "lineasUnids")
	public String getUnitLines() {
		return unitLines;
	}

	public void setUnitLines(String unitLines) {
		this.unitLines = unitLines;
	}

	@XmlElement(name = "totalUnids")
	public String getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(String totalUnits) {
		this.totalUnits = totalUnits;
	}

	@XmlElement(name = "lineasCajas")
	public String getBoxLines() {
		return boxLines;
	}

	public void setBoxLines(String boxLines) {
		this.boxLines = boxLines;
	}

	@XmlElement(name = "totalCajas")
	public String getTotalBoxes() {
		return totalBoxes;
	}

	public void setTotalBoxes(String totalBoxes) {
		this.totalBoxes = totalBoxes;
	}

	@XmlElement(name = "lineasPalets")
	public String getPaletLines() {
		return paletLines;
	}

	public void setPaletLines(String paletLines) {
		this.paletLines = paletLines;
	}

	@XmlElement(name = "totalPalets")
	public String getTotalPalets() {
		return totalPalets;
	}

	public void setTotalPalets(String totalPalets) {
		this.totalPalets = totalPalets;
	}

	@XmlElement(name = "totalBultos")
	public String getTotalBundles() {
		return totalBundles;
	}

	public void setTotalBundles(String totalBundles) {
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

	@XmlElement(name = "fechaCarga")
	public Date getDateLoads() {
		return dateLoads;
	}

	public void setDateLoads(Date dateLoads) {
		this.dateLoads = dateLoads;
	}

	@XmlElement(name = "horaCarga")
	public Date getHourLoads() {
		return hourLoads;
	}

	public void setHourLoads(Date hourLoads) {
		this.hourLoads = hourLoads;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((numberDeliveryNote == null) ? 0 : numberDeliveryNote
						.hashCode());
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
		DeliveryNote other = (DeliveryNote) obj;
		if (numberDeliveryNote == null) {
			if (other.numberDeliveryNote != null)
				return false;
		} else if (!numberDeliveryNote.equals(other.numberDeliveryNote))
			return false;
		return true;
	}

	public static DeliveryNote clone(DeliveryNote error) {
		try {
			return (DeliveryNote) error.clone();
		} catch (CloneNotSupportedException e) {
			// not possible
		}
		return null;
	}
}