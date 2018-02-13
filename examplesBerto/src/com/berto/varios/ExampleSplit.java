/**
 * 
 */
package com.berto.varios;

/**
 * @author berto.gil 10/12/2014
 * 
 */
public class ExampleSplit {
	public static void main(String args[]) {
		String numeros = "5:00:00";
		String[] numerosComoArray = numeros.split(":");
		for (int i = 0; i < numerosComoArray.length; i++) {
			System.out.println(numerosComoArray[i]);
		}
	}
}
