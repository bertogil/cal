package com.berto.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author berto.gil
 */
@XmlRootElement(name = "pendingPreparations")
public class PendingPreparat {

	private int order;
	private int groupExtraction;
	private int client;
	private String route;
	private String deliveryNote;
	private int extraction;
	private int priority;
	private String matricula;
	private int lines;
	private Float volume;
	private Float weight;
	private String pickAndPass;
	private List<PendingPreparat> pendingPreparationList;

	public PendingPreparat() {
	}

	@XmlElement(name = "client")
	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	@XmlElement(name = "matricula")
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@XmlElement(name = "deliveryNote")
	public String getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}

	@XmlElement(name = "groupExtraction")
	public int getGroupExtraction() {
		return groupExtraction;
	}

	public void setGroupExtraction(int groupExtraction) {
		this.groupExtraction = groupExtraction;
	}

	@XmlElement(name = "priority")
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@XmlElement(name = "extraction")
	public int getExtraction() {
		return extraction;
	}

	public void setExtraction(int extraction) {
		this.extraction = extraction;
	}

	@XmlElement(name = "route")
	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	@XmlElement(name = "order")
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@XmlElement(name = "lines")
	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	@XmlElement(name = "volume")
	public Float getVolume() {
		return volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}

	@XmlElement(name = "weight")
	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	@XmlElement(name = "pickAndPass")
	public String getPickAndPass() {
		return pickAndPass;
	}

	public void setPickAndPass(String pickAndPass) {
		this.pickAndPass = pickAndPass;
	}

	@XmlElement(name = "pendingPreparation")
	public List<PendingPreparat> getPendingPreparationList() {
		return pendingPreparationList;
	}

	public void setPendingPreparationList(
			List<PendingPreparat> pendingPreparationList) {
		this.pendingPreparationList = pendingPreparationList;
	}

}
