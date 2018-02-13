package com.berto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author berto.gil
 * 
 */

@XmlRootElement(name = "secciones")
public class SectionsConfiguration implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String seccId;
	private String hourInitJournal;
	private String typeHourInitJournal;
	private String timeJournalMedia;
	private String typeTimeJournalMedia;

	public SectionsConfiguration(String seccId, String hourInitJournal,
			String typeHourInitJournal, String timeJournalMedia,
			String typeTimeJournalMedia) {
		super();
		this.hourInitJournal = hourInitJournal;
		this.typeHourInitJournal = typeHourInitJournal;
		this.timeJournalMedia = timeJournalMedia;
		this.typeTimeJournalMedia = typeTimeJournalMedia;
		this.seccId = seccId;

	}

	public SectionsConfiguration() {
	}

	@XmlElement(name = "seccId")
	public String getSeccId() {
		return seccId;
	}

	public void setSeccId(String seccId) {
		this.seccId = seccId;
	}

	@XmlElement(name = "horaIniJornada")
	public String getHourInitJournal() {
		return hourInitJournal;
	}

	public void setHourInitJournal(String hourInitJournal) {
		this.hourInitJournal = hourInitJournal;
	}

	@XmlElement(name = "tiempoJornadaMedia")
	public String getTimeJournalMedia() {
		return timeJournalMedia;
	}

	public void setTimeJournalMedia(String timeJournalMedia) {
		this.timeJournalMedia = timeJournalMedia;
	}

	@XmlElement(name = "tipoHoraIniJornada")
	public String getTypeHourInitJournal() {
		return typeHourInitJournal;
	}

	public void setTypeHourInitJournal(String typeHourInitJournal) {
		this.typeHourInitJournal = typeHourInitJournal;
	}

	@XmlElement(name = "tipoTiempoJornadaMedia")
	public String getTypeTimeJournalMedia() {
		return typeTimeJournalMedia;
	}

	public void setTypeTimeJournalMedia(String typeTimeJournalMedia) {
		this.typeTimeJournalMedia = typeTimeJournalMedia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seccId == null) ? 0 : seccId.hashCode());
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
		SectionsConfiguration other = (SectionsConfiguration) obj;
		if (seccId == null) {
			if (other.seccId != null)
				return false;
		} else if (!seccId.equals(other.seccId))
			return false;
		return true;
	}

	public static SectionsConfiguration clone(SectionsConfiguration error) {
		try {
			return (SectionsConfiguration) error.clone();
		} catch (CloneNotSupportedException e) {
			// not possible
		}
		return null;
	}
}