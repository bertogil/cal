/********************************************************************************
 *
 * Autor :    Berto Gil
 * Función :  Genera un fichero XLS con el listado de producción
 *                  y lo envía a los destinatarios
 *
 *********************************************************************************/
package com.berto.varios;

import java.io.*;

import java.sql.*;

import org.apache.poi.hssf.usermodel.*;
import java.util.*;
import java.text.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * 
 * @author berto.gil
 */
public class CreateExcelProduccion {

	private static String wCli = "";
	private static String wAlm = "";

	public static void main(String[] args) throws IOException {

		// Cliente
		wCli = "672";
		wAlm = "76";

		String cSrv = "10.232.1.100";
		String cFrm = "informatica@fcclogistica.com";
		String wTxtSub = "Listado de produccion";
		String wTxtMsj = "En el fichero adjunto les enviamos el contenido del documento requerido"
				+ ". Un saludo.";
		Properties props = new Properties();
		Session session = null;
		MimeMessage msg = null;

		// Variables
		SQLWarning w;
		String DBurl = "jdbc:db2://FCCLOG";
		String driver = "com.ibm.db2.jdbc.app.DB2Driver";
		String excel = "ListadoProduccion.xls";
		int contfilas = 2;
		String fecha = "";
		String consulta = "";

		HSSFCell cell;
		HSSFRow fila;

		// Se abre el fichero Excel
		POIFSFileSystem fichero = new POIFSFileSystem(new FileInputStream(
				"C:/intercambio/" + excel));

		// Se obtiene el libro Excel
		HSSFWorkbook wb = new HSSFWorkbook(fichero);

		// Se obtiene la primera hoja
		HSSFSheet sheet = wb.getSheetAt(0);

		try {

			// Sql lineas
			String sqlLin = "SELECT * FROM ALMDAT" + wAlm
					+ ".PFLPCT WHERE PLCLIE=" + wCli
					+ " ORDER BY PLFECH, PLTIPO";

			// Registramos el Driver DB2/400
			Class.forName(driver);

			// Nos conectamos al Driver
			Connection con = DriverManager.getConnection(DBurl, "", "");

			if ((w = con.getWarnings()) != null) {
				while (w != null) {
					System.out.println("SQLWarning: " + w.getSQLState() + '\t'
							+ w.getMessage() + '\t' + w.getErrorCode() + '\t');
					w = w.getNextWarning();
				} // enddo
			} // endif

			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery(sqlLin);

			if (rs1.next()) {
				do {

					// FECHA
					fila = sheet.createRow((short) contfilas);
					cell = fila.createCell((short) 0);
					try {
						cell = fila.createCell((short) 0);
						fecha = rs1.getString(2).trim();
						cell.setCellValue(formatoFecha(fecha));
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// CALIFICADOR
					try {
						cell = fila.createCell((short) 1);
						cell.setCellValue(rs1.getString(3).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// PENDIENTE AL INICIO DEL DÍA PEDIDOS
					try {
						cell = fila.createCell((short) 2);
						cell.setCellValue(rs1.getString(4).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// PENDIENTE AL INICIO DEL DÍA LÍNEAS
					try {
						cell = fila.createCell((short) 3);
						cell.setCellValue(rs1.getString(5).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// PENDIENTE AL INICIO DEL DÍA UNIDADES
					try {
						cell = fila.createCell((short) 4);
						cell.setCellValue(rs1.getString(6).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}
					// TRANS ANTES 13H PED
					try {
						cell = fila.createCell((short) 5);
						cell.setCellValue(rs1.getString(7).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// TRANS ANTES 13H LINEAS
					try {
						cell = fila.createCell((short) 6);
						cell.setCellValue(rs1.getString(8).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// TRANS ANTES 13H UNIDADES
					try {
						cell = fila.createCell((short) 7);
						cell.setCellValue(rs1.getString(9).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}
					// TRANS DESPUES 13H PED
					try {
						cell = fila.createCell((short) 8);
						cell.setCellValue(rs1.getString(10).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// TRANS DESPUES 13H LINEAS
					try {
						cell = fila.createCell((short) 9);
						cell.setCellValue(rs1.getString(11).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// TRANS DESPUES 13H UNIDADES
					try {
						cell = fila.createCell((short) 10);
						cell.setCellValue(rs1.getString(12).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// EFECTIVOS = TRASMITIDOS - ANULADOS PED
					try {
						cell = fila.createCell((short) 11);
						cell.setCellValue(rs1.getString(13).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// EFECTIVOS = TRASMITIDOS - ANULADOS LINEAS
					try {
						cell = fila.createCell((short) 12);
						cell.setCellValue(rs1.getString(14).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// EFECTIVOS = TRASMITIDOS - ANULADOS UNIDADES
					try {
						cell = fila.createCell((short) 13);
						cell.setCellValue(rs1.getString(15).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// ANULADO ANTES DEL COMPROMISO PED
					try {
						cell = fila.createCell((short) 14);
						cell.setCellValue(rs1.getString(16).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// ANULADO ANTES DEL COMPROMISO LÍNEAS
					try {
						cell = fila.createCell((short) 15);
						cell.setCellValue(rs1.getString(17).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// ANULADO ANTES DEL COMPROMISO UNIDADES
					try {
						cell = fila.createCell((short) 16);
						cell.setCellValue(rs1.getString(18).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// ANULADO A LAS 22:00
					try {
						cell = fila.createCell((short) 17);
						cell.setCellValue(rs1.getString(19).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// ANULADO A LAS 22:00
					try {
						cell = fila.createCell((short) 18);
						cell.setCellValue(rs1.getString(20).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// ANULADO A LAS 22:00
					try {
						cell = fila.createCell((short) 19);
						cell.setCellValue(rs1.getString(21).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// PREPARADO A LAS 22:00
					try {
						cell = fila.createCell((short) 20);
						cell.setCellValue(rs1.getString(22).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// PREPARADO A LAS 22:00
					try {
						cell = fila.createCell((short) 21);
						cell.setCellValue(rs1.getString(23).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// PREPARADO A LAS 22:00
					try {
						cell = fila.createCell((short) 22);
						cell.setCellValue(rs1.getString(24).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// PENDIENTE A LAS 22:00
					try {
						cell = fila.createCell((short) 23);
						cell.setCellValue(rs1.getString(25).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// PENDIENTE A LAS 22:00
					try {
						cell = fila.createCell((short) 24);
						cell.setCellValue(rs1.getString(26).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// PENDIENTE A LAS 22:00
					try {
						cell = fila.createCell((short) 25);
						cell.setCellValue(rs1.getString(27).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// PENDIENTE DE EMBARCAR A LAS 22:00 PED
					try {
						cell = fila.createCell((short) 26);
						cell.setCellValue(rs1.getString(28).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// PENDIENTE DE EMBARCAR A LAS 22:00 LÍNEAS
					try {
						cell = fila.createCell((short) 27);
						cell.setCellValue(rs1.getString(29).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// PENDIENTE DE EMBARCAR A LAS 22:00 UNIDADES
					try {
						cell = fila.createCell((short) 28);
						cell.setCellValue(rs1.getString(30).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// EMBARCADOS A LAS 19:00
					try {
						cell = fila.createCell((short) 29);
						cell.setCellValue(rs1.getString(31).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// EMBARCADOS A LAS 19:00
					try {
						cell = fila.createCell((short) 30);
						cell.setCellValue(rs1.getString(32).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// EMBARCADOS A LAS 19:00
					try {
						cell = fila.createCell((short) 31);
						cell.setCellValue(rs1.getString(33).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// EMBARCADOS A LAS 19:00 DEL DÍA
					try {
						cell = fila.createCell((short) 32);
						cell.setCellValue(rs1.getString(34).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// EMBARCADOS A LAS 19:00 DEL DÍA
					try {
						cell = fila.createCell((short) 33);
						cell.setCellValue(rs1.getString(35).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					// EMBARCADOS A LAS 19:00 DEL DÍA
					try {
						cell = fila.createCell((short) 34);
						cell.setCellValue(rs1.getString(36).trim());
					} catch (Exception e) {
						cell.setCellValue("");
					}

					contfilas++;

				} while (rs1.next());

				rs1.close();
				stmt1.close();

			}

			// Escribimos los resultados en el fichero Excel
			FileOutputStream fileOut = new FileOutputStream("/home/SndMail/"
					+ excel);
			wb.write(fileOut);

			props.put("mail.smtp.host", cSrv);
			session = Session.getDefaultInstance(props, null);
			session.setDebug(false);
			msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(cFrm));
			msg.setSubject(wTxtSub);

			// Lanzamos la consulta para recuperar las direcciones de e-mail
			stmt1 = con.createStatement();
			consulta = "SELECT * FROM ALMDAT" + wAlm
					+ ".WEUSRMA WHERE USRDIV='@EB' AND USRCLI=" + wCli;
			rs1 = stmt1.executeQuery(consulta);

			// Verificamos si tenemos registros
			boolean mas1 = rs1.next();
			if (mas1) {
				msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
						rs1.getString("USRMAI").trim()));
			}

			// Cargamos direcciones
			mas1 = rs1.next();
			while (mas1) {

				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						rs1.getString("USRMAI").trim()));
				mas1 = rs1.next();

			}

			// Cerramos cursor
			rs1.close();
			stmt1.close();

			// Creamos Mensaje
			// -------------------------------------------------------------------------------------

			// Creamos 1º Parte del Body del Mensaje
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText(wTxtMsj);

			// Añadimos 1º parte del Body al Mensaje
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);

			// Creamos Nueva Parte del Body del Mensaje
			MimeBodyPart mbpx = new MimeBodyPart();

			// Adjuntamos fichero
			FileDataSource fds = new FileDataSource("/home/SndMail/" + excel);
			mbpx.setDataHandler(new DataHandler(fds));
			mbpx.setFileName(excel);
			mp.addBodyPart(mbpx);

			// Añadimos Multipartes al mensaje
			msg.setContent(mp);

			// Tomamos Fecha del Dia
			java.util.Date Hoy = new java.util.Date();
			DateFormat SpainDate = DateFormat.getDateInstance(DateFormat.SHORT,
					new Locale("ES", "ES"));

			// Indicamos Fecha del Mail
			msg.setSentDate(Hoy);

			// Lanzamos el Mail
			Transport.send(msg);

			// Borramos fichero excel
			borraLineas(contfilas);

			// Cerramos fichero
			fileOut.close();

			// Cerramos Conexión JDBC.
			con.close();

			// Muestra mensaje OK
			System.out
					.println("Mensaje enviado correctamente por e-mail.\nPulse Intro para continuar.");

		} catch (Exception e) {

			System.err
					.println("Se ha producido un error al intentar grabar el fichero: "
							+ excel + " " + e);
			System.out
					.println("Por favor, póngase en contacto con el departamento de sistemas.");

		} // fin try

	} // public static void main

	/**
	 * Da formato a la fecha
	 */
	static String formatoFecha(String fecha) {

		String ano = "";
		String mes = "";
		String dia = "";

		ano = fecha.substring(0, 4);
		mes = fecha.substring(4, 6);
		dia = fecha.substring(6, 8);

		String wFecha = (dia + "/" + mes + "/" + ano);

		return wFecha;

	}

	/**
	 * Borra líneas de producto dependiendo del nº de filas. Los otros campos se
	 * borran antes de rellenarlos con los datos correctos en el método main.
	 * 
	 * @param contfilas
	 */
	public static void borraLineas(int contfilas) {

		String excel = "ListadoProduccion.xls";

		try {
			// Se abre el fichero Excel
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					"/home/SndMail/" + excel));

			// Se obtiene el libro Excel
			HSSFWorkbook wb = new HSSFWorkbook(fs);

			// Se obtiene la primera hoja
			HSSFSheet sheet = wb.getSheetAt(0);

			// Se crean los objetos necesarios
			HSSFRow fila;

			// Bucle para el borrado de las lineas
			for (int i = 2; i < contfilas; i++) {
				fila = sheet.getRow(i);
				sheet.removeRow(fila);
			}

			FileOutputStream fileOut = new FileOutputStream("/home/SndMail/"
					+ excel);
			wb.write(fileOut);

		} catch (IOException ex) {
			System.out.println("Error al borrar las lineas del fichero.");

		} // fin try

	} // public static void borrarLineas
}
