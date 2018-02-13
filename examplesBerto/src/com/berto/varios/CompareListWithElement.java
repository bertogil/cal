package com.berto.varios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.berto.xml.Matricula;

public class CompareListWithElement {

	private static List<Matricula> matriculaList = new ArrayList<Matricula>();

	private static Matricula matricula;

	private static Matricula matriculaComparacion = new Matricula("1", "5",
			"1", "", 1, matriculaList);
	private static Matricula matriculaResultado = new Matricula();

	public static void main(String[] args) {

		for (int i = 1; i < 10; i++) {
			matricula = new Matricula();
			matricula.setClient(String.valueOf(i));
			matriculaList.add(matricula);
		}

		// Retorna la posición del elemento.
		int indexElement = matriculaList.indexOf(matriculaComparacion);

		// Ordenar lista en base a un elemento
		Collections.sort(matriculaList, new Comparator<Matricula>() {
			public int compare(Matricula matricula1, Matricula matricula2) {
				// System.out.println("Matricula 1: " + matricula1.getClient());
				// System.out.println("Matricula Comparacion 2: "
				// + matriculaComparacion.getClient());
				// System.out.println("Orden: " +
				// matricula1.getClient().compareTo(
				// matriculaComparacion.getClient()));
				return (matricula1.getClient().compareTo(matriculaComparacion
						.getClient()));
			}
		});

		// Recorrer la lista
		Iterator<Matricula> iterador = matriculaList.listIterator();
		while (iterador.hasNext()) {
			Matricula matriculaIterator = (Matricula) iterador.next();
			if (matriculaIterator.getClient().equals(
					matriculaComparacion.getClient())) {
				matriculaResultado = matriculaIterator;
				System.out.println("Cliente encontrado con nº: "
						+ matriculaResultado.getClient());
			}
			System.out.println(matriculaIterator.getClient());
		}
	}
}
