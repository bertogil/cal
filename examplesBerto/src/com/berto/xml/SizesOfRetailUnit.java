package com.berto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sizeofretailunit")
public class SizesOfRetailUnit implements Serializable, Cloneable {

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

	public SizesOfRetailUnit(String length, String width, String height, String volume, String weight,
			String numberOfRetailUnitsForEachStorageUnit, String storageUnitsPerPallet) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
		this.volume = volume;
		this.weight = weight;
		this.numberOfRetailUnitsForEachStorageUnit = numberOfRetailUnitsForEachStorageUnit;
		this.storageUnitsPerPallet = storageUnitsPerPallet;
	}

	public SizesOfRetailUnit() {
		super();
	}

	@XmlElement(name = "lenght")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((numberOfRetailUnitsForEachStorageUnit == null) ? 0
				: numberOfRetailUnitsForEachStorageUnit.hashCode());
		result = prime * result + ((storageUnitsPerPallet == null) ? 0 : storageUnitsPerPallet.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
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
		SizesOfRetailUnit other = (SizesOfRetailUnit) obj;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (numberOfRetailUnitsForEachStorageUnit == null) {
			if (other.numberOfRetailUnitsForEachStorageUnit != null)
				return false;
		} else if (!numberOfRetailUnitsForEachStorageUnit.equals(other.numberOfRetailUnitsForEachStorageUnit))
			return false;
		if (storageUnitsPerPallet == null) {
			if (other.storageUnitsPerPallet != null)
				return false;
		} else if (!storageUnitsPerPallet.equals(other.storageUnitsPerPallet))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		if (width == null) {
			if (other.width != null)
				return false;
		} else if (!width.equals(other.width))
			return false;
		return true;
	}

}
