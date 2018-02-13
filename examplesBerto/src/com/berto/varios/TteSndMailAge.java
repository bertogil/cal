package com.berto.varios;

/*
 * Este programa envia un E-mail con los siguientes parametros
 *
 *	1.- Agencia a la que enviar.
 *	2.- Directorio de Ficheros.
 *
 * Autor: I±aky Martin Lucas   14/10/1999
 */

import java.util.*;
import java.text.*;
import java.io.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import java.sql.*;

public class TteSndMailAge {

	private static final String SMTP = "mail.smtp.host";
	public static final String DRIVER = "com.ibm.as400.access.AS400JDBCDriver";
	public static final String JDBC = "jdbc:as400://FCCLOG";
	public static final String PASSWORD = "fccl";
	public static final String USER = "sistemas";
	public static Connection con;

	// Ejecuci¾n de procesos en AS/400
	static Process wRun;

	public TteSndMailAge() {
		super();
	}

	public static void main(String[] args) {

		SQLWarning w;
		Statement stmt1;
		Statement stmt2;
		String Qry1;
		String Qry2;
		ResultSet rs1;
		ResultSet rs2;
		Properties props = new Properties();
		Session session = null;
		MimeMessage msg = null;
		boolean mas1;
		boolean mas2;
		boolean bCC = false;
		String wAge = "";
		String wDir = "";
		String wFile;
		String wCmd;
		String wHrs= "01:00";
		StringBuffer wTxt = new StringBuffer("");

		try {

			/* Cargamos Parametros */
			// wAge = args[0]; // Agencia
			// wDir = args[1]; // Directorio del Fichero

			wAge = "00999"; // Agencia
			wDir = "C:/intercambio"; // Directorio del Fichero

		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.exit(1);
		}

		try {

			// Registramos el Driver DB2/400
			Class.forName(DRIVER);

			// Nos conectamos al Driver
			con = DriverManager.getConnection(JDBC, USER, PASSWORD);

			if ((w = con.getWarnings()) != null) {
				while (w != null) {
					System.out.println("SQLWarning: " + w.getSQLState() + '\t'
							+ w.getMessage() + '\t' + w.getErrorCode() + '\t');
					w = w.getNextWarning();
				} // enddo
			} // endif

			// Tomamos Fecha del Dia
			java.util.Date Hoy = new java.util.Date();
			DateFormat SpainDate = DateFormat.getDateInstance(DateFormat.SHORT,
					new Locale("ES", "ES"));

			// Leemos Script de Mail para la Agencia
			stmt2 = con.createStatement();

			// Lanzamos la consulta
			Qry2 = "SELECT * FROM TTEDAT.TTASMA WHERE ASMAGE='" + wAge.trim()
					+ "'";
			rs2 = stmt2.executeQuery(Qry2);

			// Verificamos si tenemos registros
			mas2 = rs2.next();
			while (mas2) {

				// Procesamos Mandatos
				wCmd = rs2.getString("ASMTIP").trim();

				// Servidor de Correo
				if (wCmd.compareTo("SYS") == 0) {
					props.put(SMTP, rs2.getString("ASMTXT").trim());
					session = Session.getDefaultInstance(props, null);
					session.setDebug(false);
					msg = new MimeMessage(session);
				} // Endif

				// Direcci¾n From
				if (wCmd.compareTo("FRM") == 0) {
					msg.setFrom(new InternetAddress(rs2.getString("ASMTXT")
							.trim()));
				} // Endif

				// Direcci¾n To
				if (wCmd.compareTo("TO") == 0) {
					msg.setRecipient(Message.RecipientType.TO,
							new InternetAddress(rs2.getString("ASMTXT").trim()));
				} // Endif

				// Direcci¾n CC
				if (wCmd.compareTo("CC") == 0) {
					if (bCC) {
						msg.addRecipient(Message.RecipientType.CC,
								new InternetAddress(rs2.getString("ASMTXT")
										.trim()));
					} else {
						msg.setRecipient(Message.RecipientType.CC,
								new InternetAddress(rs2.getString("ASMTXT")
										.trim()));
						bCC = true;
					} // endif
				} // Endif

				// Subject
				if (wCmd.compareTo("SUB") == 0) {
					msg.setSubject(rs2.getString("ASMTXT").trim() + " "
							+ SpainDate.format(Hoy));
				} // Endif

				// Texto para el Body del Mensaje.
				if (wCmd.compareTo("BOD") == 0) {
					wTxt.append(rs2.getString("ASMTXT").trim() + '\n');
				} // endif

				// Leemos nuevo registro del cursor
				mas2 = rs2.next();

			} // enddo

			// Cerramos la Tabla
			rs2.close();
			stmt2.close();

			// Creamos 1€ Parte del Body del Mensaje
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText(wTxt.toString());

			// A±adimos 1€ parte del Body al Mensaje
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);

			wFile = "alclie.txt";
			File fFile = new File(wDir + "/" + wFile);
			if (fFile.isFile()) {

				// Creamos Nueva Parte del Body del Mensaje
				MimeBodyPart mbpx = new MimeBodyPart();

				// Adjuntamos fichero
				FileDataSource fds = new FileDataSource(fFile);
				mbpx.setDataHandler(new DataHandler(fds));
				mbpx.setFileName(wFile);
				mp.addBodyPart(mbpx);


			} else {


			} // endif


			// A±adimos Multipartes al mensaje
			msg.setContent(mp);

			// Indicamos Fecha del Mail
			msg.setSentDate(Hoy);

			// Lanzamos el Mail
			Transport.send(msg);

			// Cerramos Conexi¾n JDBC.
			con.close();

		} catch (MessagingException mex) {

			System.out.println("Error en Envio del Mensaje TteSndMailAge");
			mex.printStackTrace();
			System.out.println();
			Exception ex = mex;
			do {
				if (ex instanceof SendFailedException) {
					SendFailedException sfex = (SendFailedException) ex;
					Address[] invalid = sfex.getInvalidAddresses();
					if (invalid != null) {
						System.out.println("    ** Invalid Addresses");
						if (invalid != null) {
							for (int i = 0; i < invalid.length; i++)
								System.out.println("         " + invalid[i]);
						} // endif
					} // endif

					Address[] validUnsent = sfex.getValidUnsentAddresses();
					if (validUnsent != null) {
						System.out.println("    ** ValidUnsent Addresses");
						if (validUnsent != null) {
							for (int i = 0; i < validUnsent.length; i++)
								System.out
										.println("         " + validUnsent[i]);
						} // endif
					} // endif

					Address[] validSent = sfex.getValidSentAddresses();
					if (validSent != null) {
						System.out.println("    ** ValidSent Addresses");
						if (validSent != null) {
							for (int i = 0; i < validSent.length; i++)
								System.out.println("         " + validSent[i]);
						} // endif
					} // endif
				} // endif

				System.out.println();

			} while ((ex = ((MessagingException) ex).getNextException()) != null);

		} catch (SQLException e) {
			while (e != null) {
				System.err.println("SQLException: " + e.getSQLState() + '\t'
						+ e.getMessage() + '\t' + e.getErrorCode());
				e = e.getNextException();
			} // enddo

		} catch (Exception e) {
			System.err.println("Exception: " + e);
			e.printStackTrace();

		} // endtry

	} // end-main
}