package com.berto.utilidades.date;

/**
 *
 * @author berto.gil
 */
import java.util.Calendar;

public class MostrarHora {

    public static void main(String[] args) {
        String hora, hor, min, seg;
        Calendar fecha = Calendar.getInstance();
        hor = Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
        min = Integer.toString(fecha.get(Calendar.MINUTE));
        seg = Integer.toString(fecha.get(Calendar.SECOND));
        hora = hor + ":" + min + ":" + seg;
        System.out.println(hora);
    }
}
