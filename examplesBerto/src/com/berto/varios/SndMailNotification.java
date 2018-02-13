package com.berto.varios;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class SndMailNotification {

	private static final String TO = "juanjose.delgado@logiters.com";
	private static final String NOTIFICATION = "berto.gil@logiters.com";
	private static final String FROM = "berto.gil@logiters.com";
	private static final String SMTP = "srvcorreo.aitena.es";
	private static final String USER = "berto.gil@aitena.es";
	private static final String PASSWORD = "daraqber";

	public static void main(String[] args) {

		{
			try {
				// Propiedades de la conexión
				Properties props = new Properties();
				props.setProperty("mail.smtp.host", SMTP);
				props.setProperty("mail.smtp.port", "25");
				props.put("mail.smtp.auth", "true");

				Authenticator auth = new MiAutenticador();

				// Preparamos la sesion
				Session session = Session.getDefaultInstance(props, auth);
				// Crear un mensaje vacío
				Message mensaje = new MimeMessage(session);
				// Rellenar los atributos y el contenido
				// Asunto
				mensaje.setSubject("Hola Mundo con acuse de recibo");
				// Emisor del mensaje
				mensaje.setFrom(new InternetAddress(FROM));
				// Receptor del mensaje
				mensaje.addRecipient(Message.RecipientType.TO,
						new InternetAddress(TO));
				// Rellenar el cuerpo del mensaje
				mensaje.setText("Este es el cuerpo del mensaje");
				// Acuse de recibo
				mensaje.addHeader("Disposition-Notification-To", NOTIFICATION);
				/*
				 * Añadir la prioridad 1 => La más alta 2 => Alta 3 => Normal 4
				 * => Baja 5 => La más baja
				 */
				// mensaje.addHeader("X-Priority", "1");
				// Enviar el mensaje
				Transport.send(mensaje);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static class MiAutenticador extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(USER, PASSWORD);
		}
	}
}
