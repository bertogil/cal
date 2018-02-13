package com.berto.xml;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "reimpresiones")
public class RePrint {

	private String id;
	private String document;
	private String numberDocument;
	private String extraction;
	private String client;
	private String groupExtraction;
	private String route;
	private String deliveryNote;
	private String date;
	private List<RePrint> reprintList;

	public RePrint() {
	}
	
	public RePrint(String id, String document, String numberDocument,
			String extraction, String client, String groupExtraction,
			String route, String deliveryNote, String date,
			List<RePrint> reprintList) {
		super();
		this.id = id;
		this.document = document;
		this.numberDocument = numberDocument;
		this.extraction = extraction;
		this.client = client;
		this.groupExtraction = groupExtraction;
		this.route = route;
		this.deliveryNote = deliveryNote;
		this.date = date;
		this.reprintList = reprintList;
	}



	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "client")
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@XmlElement(name = "document")
	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	@XmlElement(name = "numdocument")
	public String getNumberDocument() {
		return numberDocument;
	}

	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}

	@XmlElement(name = "extraction")
	public String getExtraction() {
		return extraction;
	}

	public void setExtraction(String extraction) {
		this.extraction = extraction;
	}

	@XmlElement(name = "groupExtraction")
	public String getGroupExtraction() {
		return groupExtraction;
	}

	public void setGroupExtraction(String groupExtraction) {
		this.groupExtraction = groupExtraction;
	}

	@XmlElement(name = "route")
	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	@XmlElement(name = "deliveryNote")
	public String getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}

	@XmlElement(name = "date")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@XmlElement(name = "reimpresion")
	public List<RePrint> getReprintList() {
		return reprintList;
	}

	public void setReprintList(List<RePrint> reprintList) {
		this.reprintList = reprintList;
	}

}
