package com.berto.string.java;

/**
 * Ejemplo rellenar String con ceros por la izquierda
 * 
 * @author berto.gil
 */

public class FillZerosString {

	public static void main(String args[]) throws Exception {
		String resultado = String.format("%010d", 1245);
		System.out.println(resultado);
	}
}
