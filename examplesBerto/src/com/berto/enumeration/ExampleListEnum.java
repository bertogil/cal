package com.berto.enumeration;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ExampleListEnum {

	private static List<DeliveryNoteType> typeList = Arrays.asList(DeliveryNoteType.values());

	public static void main(String[] args) throws SQLException {

		for (DeliveryNoteType nombre : typeList) {

			System.out.println(nombre.value);
		}
	}

}
