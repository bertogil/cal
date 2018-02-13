package com.berto.string.java;

/**
 * Ejemplo del método split en java
 * @author berto.gil
 */

public class StringSplit1 {

    public static void main(String args[]) throws Exception {
        String url = "01-ECI_11";
        String[] arrayUrl = url.split("_");
     
// En este momento tenemos un array en el que cada elemento es un color.
       
            String tti = arrayUrl[0];
            String cti = arrayUrl[1];
            System.out.println("tti= " + tti);
            System.out.println("cti= " + cti);
       
    }
}
