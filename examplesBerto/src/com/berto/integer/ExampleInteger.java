package com.berto.integer;

public class ExampleInteger {
	public static void main(String[] args) {
		Integer a = 150;
		Integer b = 150;
		System.out.println(a == b); // false

		/*
		 * En este caso estamos ante una de las optimizaciones de la máquina virtual .
		 * Acabamos de construir 4 objetos ,sin embargo existe una diferencia entre
		 * ellos . Aunque les consideramos Integers a los 4 resulta que dos de ellos
		 * tienen el tamaño de un tipo “byte”. Ante esta situación la maquina virtual
		 * realiza una optimización y decide que para los números muy pequeños del
		 * tamaño de un byte generará un pool de objetos. Recordemos que los objetos
		 * Integer son inmutables, la optimización parece razonable. Así pues aunque
		 * nosotros en nuestro código pensamos que hemos construido 4 objetos. Realmente
		 * solo se han construido 3
		 */

		Integer a1 = 2;
		Integer b1 = 2;
		System.out.println(a1 == b1); // true

	}
}
