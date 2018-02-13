package com.berto.mail;

import javax.mail.Session;

public class SimpleEmail {

	private static final String BODY = "Cuerpo del correo";
	private static final String SUBJECT = "Asunto del correo";
	private static final String TO_MAIL = "berto.gil@gmail.com";
	private static final String FROM_MAIL = "bgil@id-logistics.com";
	private static final String REPLY_TO = "bgil@id-logistics.com";

	public static void main(String[] args) {

		Session session = null;

		System.out.println("Ejemplo envío email");

		// Ejemplo mensaje con html
		String message = "<i>Hola!</i><br>";
		message += "<b>Prueba b</b><br>";
		message += "<font color=red>Prueba color</font>";

		EmailUtil.sendEmail(session, TO_MAIL, FROM_MAIL, REPLY_TO, SUBJECT, BODY);
	}

}