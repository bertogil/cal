package com.berto.xml;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author berto.gil
 * 
 */

@XmlRootElement(name = "invoiceslist")
public class Invoice implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private DecimalFormat formatter = new DecimalFormat("###,###.###");

	private String client;	
	private String month;
	private String year;
	private String urlFilesZipMonth;
	private String idInvoice;
	private String urlInvoice;
	private String amount = "0.00000";
	private String taxation = "0.00000";
	private String dateInvoice;
	private String urlServices;
	private String urlAmount;
	private String urlFilesZip;
	private String description;

	private List<Invoice> invoicesList = new ArrayList<Invoice>();
	private String[] urlRelatedDocumentsList;

	public Invoice() {
	}

	@XmlElement(name = "client")
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@XmlElement(name = "month")
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@XmlElement(name = "year")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@XmlElement(name = "urlFilesZipMonth")
	public String getUrlFilesZipMonth() {
		return urlFilesZipMonth;
	}

	public void setUrlFilesZipMonth(String urlFilesZipMonth) {
		this.urlFilesZipMonth = urlFilesZipMonth;
	}

	@XmlElement(name = "idInvoice")
	public String getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(String idInvoice) {
		this.idInvoice = idInvoice;
	}

	@XmlElement(name = "urlInvoice")
	public String getUrlInvoice() {
		return urlInvoice;
	}

	public void setUrlInvoice(String urlInvoice) {
		this.urlInvoice = urlInvoice;
	}

	@XmlElement(name = "amount")
	public String getAmount() {
		return formatter.format(Double.parseDouble(amount));
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@XmlElement(name = "taxation")
	public String getTaxation() {
		return formatter.format(Double.parseDouble(taxation));
	}

	public void setTaxation(String taxation) {
		this.taxation = taxation;
	}

	@XmlElement(name = "dateInvoice")
	public String getDateInvoice() {
		return dateInvoice;
	}

	public void setDateInvoice(String dateInvoice) {
		this.dateInvoice = dateInvoice;
	}

	@XmlElement(name = "urlServices")
	public String getUrlServices() {
		return urlServices;
	}

	public void setUrlServices(String urlServices) {
		this.urlServices = urlServices;
	}

	@XmlElement(name = "urlAmount")
	public String getUrlAmount() {
		return urlAmount;
	}

	public void setUrlAmount(String urlAmount) {
		this.urlAmount = urlAmount;
	}

	@XmlElement(name = "urlFilesZip")
	public String getUrlFilesZip() {
		return urlFilesZip;
	}

	public void setUrlFilesZip(String urlFilesZip) {
		this.urlFilesZip = urlFilesZip;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElementWrapper(name = "invoices")
	@XmlElement(name = "invoice")
	public List<Invoice> getInvoicesList() {
		return invoicesList;
	}

	public void setInvoicesList(List<Invoice> invoicesList) {
		this.invoicesList = invoicesList;
	}

	@XmlElementWrapper(name = "urlRelatedDocuments")
	@XmlElement(name = "urlRelatedDocument")
	public String[] getUrlRelatedDocumentsList() {
		return urlRelatedDocumentsList;
	}

	public void setUrlRelatedDocumentsList(String[] urlRelatedDocumentsList) {
		this.urlRelatedDocumentsList = urlRelatedDocumentsList;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
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
		Invoice other = (Invoice) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		return true;
	}

	public static Invoice clone(Invoice error) {
		try {
			return (Invoice) error.clone();
		} catch (CloneNotSupportedException e) {
			// not possible
		}
		return null;
	}

}
