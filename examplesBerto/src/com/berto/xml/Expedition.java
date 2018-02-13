package com.berto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author berto.gil
 * 
 */

public class Expedition implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private String purchaseOrder;
	private String receptionDate;
	private String storageUnits;
	private String salesUnits;
	private String deliveryNote;
	private String route;
	private String routeDocument;
	private String serviceStore;
	private String situation;
	private String situationDate;
	private String destination;
	private String totalStorageUnits;
	private String totalSalesUnits;

	public Expedition() {
	}

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

	@XmlElement(name = "deliverynote")
	public String getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}

	@XmlElement(name = "route")
	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	@XmlElement(name = "routedocument")
	public String getRouteDocument() {
		return routeDocument;
	}

	public void setRouteDocument(String routeDocument) {
		this.routeDocument = routeDocument;
	}

	@XmlElement(name = "servicestore")
	public String getServiceStore() {
		return serviceStore;
	}

	public void setServiceStore(String serviceStore) {
		this.serviceStore = serviceStore;
	}

	@XmlElement(name = "situation")
	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	@XmlElement(name = "situationdate")
	public String getSituationDate() {
		return situationDate;
	}

	public void setSituationDate(String situationDate) {
		this.situationDate = situationDate;
	}

	@XmlElement(name = "destination")
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@XmlElement(name = "totalstorageunits")
	public String getTotalStorageUnits() {
		return totalStorageUnits;
	}

	public void setTotalStorageUnits(String totalStorageUnits) {
		this.totalStorageUnits = totalStorageUnits;
	}

	@XmlElement(name = "totalsalesunits")
	public String getTotalSalesUnits() {
		return totalSalesUnits;
	}

	public void setTotalSalesUnits(String totalSalesUnits) {
		this.totalSalesUnits = totalSalesUnits;
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
		Expedition other = (Expedition) obj;
		if (purchaseOrder == null) {
			if (other.purchaseOrder != null)
				return false;
		} else if (!purchaseOrder.equals(other.purchaseOrder))
			return false;
		return true;
	}

	public static Expedition clone(Expedition error) {
		try {
			return (Expedition) error.clone();
		} catch (CloneNotSupportedException e) {
			// not possible
		}
		return null;
	}

}
