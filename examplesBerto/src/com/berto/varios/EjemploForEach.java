package com.berto.varios;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class EjemploForEach {

	private static List<String> funcionList = new ArrayList<String>();

	public static void main(String[] args) throws ParseException {
		getFuncionList();
		for (String funcion : funcionList) {
			String attribute = "serviceManager" + funcion;
			System.out.println(attribute);
		}

	}

	public static List<String> getFuncionList() {
		funcionList.add("user");
		funcionList.add("cmdasignamulti");
		funcionList.add("cmdasignarslot");
		funcionList.add("cmdchangeslot");
		funcionList.add("cmdreubica");
		funcionList.add("cmdnotify");
		funcionList.add("cmdplay");
		funcionList.add("cmdchangemode");
		funcionList.add("cmdreprint");
		funcionList.add("groupasignation");
		funcionList.add("login");
		funcionList.add("logout");
		funcionList.add("logs");
		funcionList.add("lote");
		funcionList.add("matricula");
		funcionList.add("notify");
		funcionList.add("pendingpreparat");
		funcionList.add("reparto");
		funcionList.add("reprint");
		funcionList.add("slot");
		funcionList.add("slotnavegation");
		funcionList.add("stationactual");
		funcionList.add("stationprevious");
		funcionList.add("statussystem");
		funcionList.add("typebox");
		funcionList.add("reubicacion");
		return funcionList;
	}
}
