package com.berto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author berto.gil
 * 
 */

public class LotsHistory implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private String date;
	private String hour;
	private String documentType;
	private String document;
	private String reasonMovement;
	private String reasonBlockage;
	private String recipient;
	private String remarks;
	private String movedAmountStorageUnits;
	private String movedAmountsSalesUnits;
	private String availableStorageUnits;
	private String availableSalesUnits;
	private String bloquedStorageUnits;
	private String bloquedaSalesUnits;
	private String physicalStorageUnits;
	private String physicalSalesUnits;

	public LotsHistory() {
	}

	@XmlElement(name = "date")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@XmlElement(name = "hour")
	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	@XmlElement(name = "documenttype")
	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	@XmlElement(name = "document")
	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	@XmlElement(name = "reasonmovement")
	public String getReasonMovement() {
		return reasonMovement;
	}

	public void setReasonMovement(String reasonMovement) {
		this.reasonMovement = reasonMovement;
	}

	@XmlElement(name = "reasonblockage")
	public String getReasonBlockage() {
		return reasonBlockage;
	}

	public void setReasonBlockage(String reasonBlockage) {
		this.reasonBlockage = reasonBlockage;
	}

	@XmlElement(name = "recipient")
	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	@XmlElement(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@XmlElement(name = "movedamountstorageunits")
	public String getMovedAmountStorageUnits() {
		return movedAmountStorageUnits;
	}

	public void setMovedAmountStorageUnits(String movedAmountStorageUnits) {
		this.movedAmountStorageUnits = movedAmountStorageUnits;
	}

	@XmlElement(name = "movedamountssalesunits")
	public String getMovedAmountsSalesUnits() {
		return movedAmountsSalesUnits;
	}

	public void setMovedAmountsSalesUnits(String movedAmountsSalesUnits) {
		this.movedAmountsSalesUnits = movedAmountsSalesUnits;
	}

	@XmlElement(name = "availablestorageunits")
	public String getAvailableStorageUnits() {
		return availableStorageUnits;
	}

	public void setAvailableStorageUnits(String availableStorageUnits) {
		this.availableStorageUnits = availableStorageUnits;
	}

	@XmlElement(name = "availablesalesunits")
	public String getAvailableSalesUnits() {
		return availableSalesUnits;
	}

	public void setAvailableSalesUnits(String availableSalesUnits) {
		this.availableSalesUnits = availableSalesUnits;
	}

	@XmlElement(name = "bloquedstorageunits")
	public String getBloquedStorageUnits() {
		return bloquedStorageUnits;
	}

	public void setBloquedStorageUnits(String bloquedStorageUnits) {
		this.bloquedStorageUnits = bloquedStorageUnits;
	}

	@XmlElement(name = "bloquedasalesunits")
	public String getBloquedaSalesUnits() {
		return bloquedaSalesUnits;
	}

	public void setBloquedaSalesUnits(String bloquedaSalesUnits) {
		this.bloquedaSalesUnits = bloquedaSalesUnits;
	}

	@XmlElement(name = "physicalstorageunits")
	public String getPhysicalStorageUnits() {
		return physicalStorageUnits;
	}

	public void setPhysicalStorageUnits(String physicalStorageUnits) {
		this.physicalStorageUnits = physicalStorageUnits;
	}

	@XmlElement(name = "physicalsalesunits")
	public String getPhysicalSalesUnits() {
		return physicalSalesUnits;
	}

	public void setPhysicalSalesUnits(String physicalSalesUnits) {
		this.physicalSalesUnits = physicalSalesUnits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((document == null) ? 0 : document.hashCode());
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
		LotsHistory other = (LotsHistory) obj;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		return true;
	}

}
