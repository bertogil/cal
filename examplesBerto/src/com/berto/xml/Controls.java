package com.berto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class Controls implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String pickingunit;
	private String batchcontrol;
	private String quarantinecontrol;
	private String expirationdatecontrol;
	private String daysbeforeexpirationdatewarning;
	private String manufaturedatecontrol;
	private String serialnumbercontrol;
	private String alcoholcontrol;
	private String minimumstockqty;

	@XmlElement(name = "pickingunit")
	public String getPickingunit() {
		return pickingunit;
	}

	public void setPickingunit(String pickingunit) {
		this.pickingunit = pickingunit;
	}

	@XmlElement(name = "batchcontrol")
	public String getBatchcontrol() {
		return batchcontrol;
	}

	public void setBatchcontrol(String batchcontrol) {
		this.batchcontrol = batchcontrol;
	}

	@XmlElement(name = "quarantinecontrol")
	public String getQuarantinecontrol() {
		return quarantinecontrol;
	}

	public void setQuarantinecontrol(String quarantinecontrol) {
		this.quarantinecontrol = quarantinecontrol;
	}

	@XmlElement(name = "expirationdatecontrol")
	public String getExpirationdatecontrol() {
		return expirationdatecontrol;
	}

	public void setExpirationdatecontrol(String expirationdatecontrol) {
		this.expirationdatecontrol = expirationdatecontrol;
	}

	@XmlElement(name = "daysbeforeexpirationdatewarning")
	public String getDaysbeforeexpirationdatewarning() {
		return daysbeforeexpirationdatewarning;
	}

	public void setDaysbeforeexpirationdatewarning(String daysbeforeexpirationdatewarning) {
		this.daysbeforeexpirationdatewarning = daysbeforeexpirationdatewarning;
	}

	@XmlElement(name = "manufaturedatecontrol")
	public String getManufaturedatecontrol() {
		return manufaturedatecontrol;
	}

	public void setManufaturedatecontrol(String manufaturedatecontrol) {
		this.manufaturedatecontrol = manufaturedatecontrol;
	}

	@XmlElement(name = "serialnumbercontrol")
	public String getSerialnumbercontrol() {
		return serialnumbercontrol;
	}

	public void setSerialnumbercontrol(String serialnumbercontrol) {
		this.serialnumbercontrol = serialnumbercontrol;
	}

	@XmlElement(name = "alcoholcontrol")
	public String getAlcoholcontrol() {
		return alcoholcontrol;
	}

	public void setAlcoholcontrol(String alcoholcontrol) {
		this.alcoholcontrol = alcoholcontrol;
	}

	@XmlElement(name = "minimumstockqty")
	public String getMinimumstockqty() {
		return minimumstockqty;
	}

	public void setMinimumstockqty(String minimumstockqty) {
		this.minimumstockqty = minimumstockqty;
	}

}
