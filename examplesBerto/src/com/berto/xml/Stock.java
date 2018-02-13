package com.berto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author berto.gil
 * 
 */

public class Stock implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private String purchaseOrder;
	private String receptionDate;
	private String storageUnits;
	private String salesUnits;
	private String expirationDate;
	private String situation;
	private String status;
	private String deliveryNote;
	private String document;
	private String date;
	private String reason;
	private String remarks;

	@XmlElement(name = "purchaseorder")
	public String getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@XmlElement(name = "receptiondate")
	public String getReceptionDate() {
		return receptionDate;
	}

	public void setReceptionDate(String receptionDate) {
		this.receptionDate = receptionDate;
	}

	@XmlElement(name = "storageunits")
	public String getStorageUnits() {
		return storageUnits;
	}

	public void setStorageUnits(String storageUnits) {
		this.storageUnits = storageUnits;
	}

	@XmlElement(name = "salesunits")
	public String getSalesUnits() {
		return salesUnits;
	}

	public void setSalesUnits(String salesUnits) {
		this.salesUnits = salesUnits;
	}

	@XmlElement(name = "expirationdate")
	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@XmlElement(name = "situation")
	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	@XmlElement(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement(name = "deliverynote")
	public String getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}

	@XmlElement(name = "document")
	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	@XmlElement(name = "date")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@XmlElement(name = "reason")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@XmlElement(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((purchaseOrder == null) ? 0 : purchaseOrder.hashCode());
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
		Stock other = (Stock) obj;
		if (purchaseOrder == null) {
			if (other.purchaseOrder != null)
				return false;
		} else if (!purchaseOrder.equals(other.purchaseOrder))
			return false;
		return true;
	}

	public static Stock clone(Stock error) {
		try {
			return (Stock) error.clone();
		} catch (CloneNotSupportedException e) {
			// not possible
		}
		return null;
	}
}