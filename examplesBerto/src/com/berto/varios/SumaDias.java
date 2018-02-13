/**
 * 
 */
package com.berto.varios;

import java.util.Calendar;
import java.util.Date;

/**
 * @author berto.gil 13/01/2015
 * 
 */
public class SumaDias {
	public static void main(String[] args) {
		Date fechaSumada = sumarRestarDiasFecha(new Date(), 2);
		System.out.println(fechaSumada);
	}

	public static Date sumarRestarDiasFecha(Date fecha, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o
													// restar en caso de días<0
		return calendar.getTime(); // Devuelve el objeto Date con los nuevos
									// días añadidos
	}
}
