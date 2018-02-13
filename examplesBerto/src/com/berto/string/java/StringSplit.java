package com.berto.string.java;

/**
 * Ejemplo del método split en java
 * @author berto.gil
 */

public class StringSplit {

    public static void main(String args[]) throws Exception {
        String url = "http://www.nacex.es/seguimientoFormularioExterno.do?"
                +
                "intcli=&usr=FCCLOGISTICA&pas=914DB4791Bf61068B77B70A66213E89E";
        String[] arrayUrl = url.split("&");

// En este momento tenemos un array en el que cada elemento es un color.
        for (int i = 0; i < arrayUrl.length; i++) {
            System.out.println(arrayUrl[i]);
        }
    }
}
