/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.berto.utilidades.date;

/**
 *
 * @author berto.gil
 */
import java.util.Scanner;

public class SeparateNumber {

    public static void main(String args[]) {
        Scanner teclear = new Scanner(System.in);
        int numero;

        System.out.print("Escribe un numero de 4 digitos: \n");
        numero = teclear.nextInt();

        // Debemos separar un número de 4 dígitos en sus 4 partes
        int i = 3;
        int[] digitos = {0, 0, 0, 0};

        while (numero > 0) {
            digitos[i--] = numero % 10;
            numero /= 10;
        }

        for (i = 0; i < 4; i++) {
            System.out.println("Dígito #" + i + " = " + digitos[i]);
        }
    }
}
