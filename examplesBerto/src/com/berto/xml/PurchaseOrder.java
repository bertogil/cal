package com.berto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class PurchaseOrder implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idLote;
	private String idPurchaseOrder;
	private String receptionDate;
	private String quantity;
	private String expirationDate;
	private String status;
	private String situation;
	private String unlocked;

	public PurchaseOrder() {
	}

	@XmlElement(name = "idlote")
	public String getIdLote() {
		return idLote;
	}

	public void setIdLote(String idLote) {
		this.idLote = idLote;
	}

	@XmlElement(name = "idpurchaseorder")
	public String getIdPurchaseOrder() {
		return idPurchaseOrder;
	}

	public void setIdPurchaseOrder(String idPurchaseOrder) {
		this.idPurchaseOrder = idPurchaseOrder;
	}

	@XmlElement(name = "receptiondate")
	public String getReceptionDate() {
		return receptionDate;
	}

	public void setReceptionDate(String receptionDate) {
		this.receptionDate = receptionDate;
	}

	@XmlElement(name = "quantity")
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@XmlElement(name = "expirationdate")
	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@XmlElement(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement(name = "situation")
	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	@XmlElement(name = "unlocked")
	public String getUnlocked() {
		return unlocked;
	}

	public void setUnlocked(String unlocked) {
		this.unlocked = unlocked;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPurchaseOrder == null) ? 0 : idPurchaseOrder.hashCode());
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
		PurchaseOrder other = (PurchaseOrder) obj;
		if (idPurchaseOrder == null) {
			if (other.idPurchaseOrder != null)
				return false;
		} else if (!idPurchaseOrder.equals(other.idPurchaseOrder))
			return false;
		return true;
	}

}
