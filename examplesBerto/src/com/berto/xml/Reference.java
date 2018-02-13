package com.berto.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "referenceslist")
public class Reference implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idReference;
	private String description;
	private String shortDescription;
	private String expirationDate;
	private String quantity;
	private String reason;

	private String area;
	private String street;
	private String typeOfProduct;
	private String valueStorageUnit;
	private String barcodeRetailUnit;
	private String barcodeStorageUnit;

	private List<Lots> lotesList = new ArrayList<Lots>();
	private List<Reference> referencesList = new ArrayList<Reference>();
	private Sizes sizeOfRetailUnit;
	private Sizes sizeOfStorageUnit;
	private Sizes palletSize;
	private Controls controls;

	public Reference() {
	}

	@XmlElement(name = "idreference")
	public String getIdReference() {
		return idReference;
	}

	public void setIdReference(String idReference) {
		this.idReference = idReference;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name = "shortdescription")
	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@XmlElement(name = "area")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@XmlElement(name = "street")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@XmlElement(name = "typeofproduct")
	public String getTypeOfProduct() {
		return typeOfProduct;
	}

	public void setTypeOfProduct(String typeOfProduct) {
		this.typeOfProduct = typeOfProduct;
	}

	@XmlElement(name = "valuestorageunit")
	public String getValueStorageUnit() {
		return valueStorageUnit;
	}

	public void setValueStorageUnit(String valueStorageUnit) {
		this.valueStorageUnit = valueStorageUnit;
	}

	@XmlElement(name = "barcoderetailunit")
	public String getBarcodeRetailUnit() {
		return barcodeRetailUnit;
	}

	public void setBarcodeRetailUnit(String barcodeRetailUnit) {
		this.barcodeRetailUnit = barcodeRetailUnit;
	}

	@XmlElement(name = "barcodestorageunit")
	public String getBarcodeStorageUnit() {
		return barcodeStorageUnit;
	}

	public void setBarcodeStorageUnit(String barcodeStorageUnit) {
		this.barcodeStorageUnit = barcodeStorageUnit;
	}

	@XmlElement(name = "expirationdate")
	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@XmlElement(name = "quantity")
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@XmlElement(name = "reason")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@XmlElement(name = "sizeofretailunit")
	public Sizes getSizeOfRetailUnit() {
		return sizeOfRetailUnit;
	}

	public void setSizeOfRetailUnit(Sizes sizeOfRetailUnit) {
		this.sizeOfRetailUnit = sizeOfRetailUnit;
	}

	@XmlElement(name = "sizeofstorageunit")
	public Sizes getSizeOfStorageUnit() {
		return sizeOfStorageUnit;
	}

	public void setSizeOfStorageUnit(Sizes sizeOfStorageUnit) {
		this.sizeOfStorageUnit = sizeOfStorageUnit;
	}

	@XmlElement(name = "palletsize")
	public Sizes getPalletSize() {
		return palletSize;
	}

	public void setPalletSize(Sizes palletSize) {
		this.palletSize = palletSize;
	}

	@XmlElement(name = "controls")
	public Controls getControls() {
		return controls;
	}

	public void setControls(Controls controls) {
		this.controls = controls;
	}

	@XmlElementWrapper(name = "loteslist")
	@XmlElement(name = "lote")
	public List<Lots> getLotesList() {
		return lotesList;
	}

	public void setLotesList(List<Lots> lotesList) {
		this.lotesList = lotesList;
	}

	@XmlElement(name = "reference")
	public List<Reference> getReferencesList() {
		return referencesList;
	}

	public void setReferencesList(List<Reference> referencesList) {
		this.referencesList = referencesList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idReference == null) ? 0 : idReference.hashCode());
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
		Reference other = (Reference) obj;
		if (idReference == null) {
			if (other.idReference != null)
				return false;
		} else if (!idReference.equals(other.idReference))
			return false;
		return true;
	}

}
