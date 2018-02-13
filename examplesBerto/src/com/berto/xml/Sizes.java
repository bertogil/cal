package com.berto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class Sizes implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String length;
	private String width;
	private String height;
	private String volume;
	private String weight;
	private String numberOfRetailUnitsForEachStorageUnit;
	private String storageUnitsPerPallet;

	@XmlElement(name = "length")
	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	@XmlElement(name = "width")
	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	@XmlElement(name = "height")
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@XmlElement(name = "volume")
	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	@XmlElement(name = "weight")
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@XmlElement(name = "numberofretailunitsforeachstorageunit")
	public String getNumberOfRetailUnitsForEachStorageUnit() {
		return numberOfRetailUnitsForEachStorageUnit;
	}

	public void setNumberOfRetailUnitsForEachStorageUnit(String numberOfRetailUnitsForEachStorageUnit) {
		this.numberOfRetailUnitsForEachStorageUnit = numberOfRetailUnitsForEachStorageUnit;
	}

	@XmlElement(name = "storageunitsperpallet")
	public String getStorageUnitsPerPallet() {
		return storageUnitsPerPallet;
	}

	public void setStorageUnitsPerPallet(String storageUnitsPerPallet) {
		this.storageUnitsPerPallet = storageUnitsPerPallet;
	}

}
