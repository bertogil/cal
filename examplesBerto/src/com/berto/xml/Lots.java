package com.berto.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "loteslist")
public class Lots implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private String idLote;
	private String client;
	private String reference;
	private String stockStorageUnit;
	private String stockSalesUnit;
	private String quantityIssuesUnit;
	private String quantityIssuaesSales;
	private String otherExitUnit;
	private String otherExitSales;
	private String totalUnit;
	private String totalSales;

	private List<Expedition> expeditionsList = new ArrayList<Expedition>();
	private List<LotsHistory> lotHistoryList = new ArrayList<LotsHistory>();
	private List<Lots> lotsList = new ArrayList<Lots>();
	private List<PurchaseOrder> purchaseOrdersList = new ArrayList<PurchaseOrder>();
	private List<Stock> stockList = new ArrayList<Stock>();
	private List<Stock> otherOutputList = new ArrayList<Stock>();
	private List<Stock> loteChangeList = new ArrayList<Stock>();

	public Lots() {
	}

	@XmlElement(name = "idlote")
	public String getIdLote() {
		return idLote;
	}

	public void setIdLote(String idLote) {
		this.idLote = idLote;
	}

	@XmlElement(name = "cliente")
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@XmlElement(name = "reference")
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@XmlElement(name = "stockstorageunit")
	public String getStockStorageUnit() {
		return stockStorageUnit;
	}

	public void setStockStorageUnit(String stockStorageUnit) {
		this.stockStorageUnit = stockStorageUnit;
	}

	@XmlElement(name = "stocksalesunit")
	public String getStockSalesUnit() {
		return stockSalesUnit;
	}

	public void setStockSalesUnit(String stockSalesUnit) {
		this.stockSalesUnit = stockSalesUnit;
	}

	@XmlElement(name = "quantityissuesunit")
	public String getQuantityIssuesUnit() {
		return quantityIssuesUnit;
	}

	public void setQuantityIssuesUnit(String quantityIssuesUnit) {
		this.quantityIssuesUnit = quantityIssuesUnit;
	}

	@XmlElement(name = "quantityissuaessales")
	public String getQuantityIssuaesSales() {
		return quantityIssuaesSales;
	}

	public void setQuantityIssuaesSales(String quantityIssuaesSales) {
		this.quantityIssuaesSales = quantityIssuaesSales;
	}

	@XmlElement(name = "otherexitunit")
	public String getOtherExitUnit() {
		return otherExitUnit;
	}

	public void setOtherExitUnit(String otherExitUnit) {
		this.otherExitUnit = otherExitUnit;
	}

	@XmlElement(name = "otherexitsales")
	public String getOtherExitSales() {
		return otherExitSales;
	}

	public void setOtherExitSales(String otherExitSales) {
		this.otherExitSales = otherExitSales;
	}

	@XmlElement(name = "totalunit")
	public String getTotalUnit() {
		return totalUnit;
	}

	public void setTotalUnit(String totalUnit) {
		this.totalUnit = totalUnit;
	}

	@XmlElement(name = "totalsales")
	public String getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(String totalSales) {
		this.totalSales = totalSales;
	}

	@XmlElementWrapper(name = "purchaseorderslist")
	@XmlElement(name = "purchaseorder")
	public List<PurchaseOrder> getPurchaseOrdersList() {
		return purchaseOrdersList;
	}

	public void setPurchaseOrdersList(List<PurchaseOrder> purchaseOrdersList) {
		this.purchaseOrdersList = purchaseOrdersList;
	}

	@XmlElementWrapper(name = "expeditionslist")
	@XmlElement(name = "expedition")
	public List<Expedition> getExpeditionsList() {
		return expeditionsList;
	}

	public void setExpeditionsList(List<Expedition> expeditionsList) {
		this.expeditionsList = expeditionsList;
	}

	@XmlElement(name = "lote")
	public List<Lots> getLotsList() {
		return lotsList;
	}

	public void setLotsList(List<Lots> lotsList) {
		this.lotsList = lotsList;
	}

	@XmlElementWrapper(name = "historyloteslist")
	@XmlElement(name = "historylotes")
	public List<LotsHistory> getLotHistoryList() {
		return lotHistoryList;
	}

	public void setLotHistoryList(List<LotsHistory> lotHistoryList) {
		this.lotHistoryList = lotHistoryList;
	}

	@XmlElementWrapper(name = "stockslist")
	@XmlElement(name = "stock")
	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

	@XmlElementWrapper(name = "otheroutputslist")
	@XmlElement(name = "otheroutput")
	public List<Stock> getOtherOutputList() {
		return otherOutputList;
	}

	public void setOtherOutputList(List<Stock> otherOutputList) {
		this.otherOutputList = otherOutputList;
	}

	@XmlElementWrapper(name = "loteschangelist")
	@XmlElement(name = "lotechange")
	public List<Stock> getLoteChangeList() {
		return loteChangeList;
	}

	public void setLoteChangeList(List<Stock> loteChangeList) {
		this.loteChangeList = loteChangeList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLote == null) ? 0 : idLote.hashCode());
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
		Lots other = (Lots) obj;
		if (idLote == null) {
			if (other.idLote != null)
				return false;
		} else if (!idLote.equals(other.idLote))
			return false;
		return true;
	}

}
