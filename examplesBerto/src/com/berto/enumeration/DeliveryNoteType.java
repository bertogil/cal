package com.berto.enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author berto.gil
 */

public enum DeliveryNoteType {
	SRV("SRV", "Servido"), APL("APL", "Aplazado"), ANU("ANU", "Anulado"), PEN("PEN", "Pendiente"), RP("RP",
			"Rechazo Parcial"), REC("REC", "Recogida");

	public final String value, description;

	DeliveryNoteType(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public static List<String> keys() {
		List<String> k = new ArrayList<String>();
		for (DeliveryNoteType s : DeliveryNoteType.values()) {
			k.add(s.value);
		}
		return k;
	}

	public static List<String> descriptions() {
		List<String> d = new ArrayList<String>();
		for (DeliveryNoteType s : DeliveryNoteType.values()) {
			d.add(s.description);
		}
		return d;
	}

	public String toString() {
		return description;
	}

}
