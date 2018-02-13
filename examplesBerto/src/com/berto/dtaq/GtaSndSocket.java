package com.berto.dtaq;

/**
 *
 * @author berto.gil
 */

import java.io.*;
import java.net.*;
import com.ibm.as400.access.*;
import java.util.*;

public class GtaSndSocket {
    private static String HOSTELE;
    private static String CONFIG_DB;

    public static void main(String[] args) {

        // Declaramos Variables
        boolean salir = false;
        String comando = null;
        String telegrama = null;
        AS400 sys = null;

        // Inicializo Socket
        gtaSocket = null;
        gtaos = null;
        gtais = null;

        try {

            // Realizamos Conexión a AS400
            sys = new AS400(HOSTSGA);

            // Creamos Registro de Lectura de Cola de Datos
            CharacterFieldDescription campoLHost = new CharacterFieldDescription(new AS400Text(2, sys), "HOST");
            CharacterFieldDescription campoLTele = new CharacterFieldDescription(new AS400Text(3, sys), "TELE");
            CharacterFieldDescription campoLData = new CharacterFieldDescription(new AS400Text(145, sys), "DATA");
            RecordFormat rcdFmtLectura = new RecordFormat();
            rcdFmtLectura.addFieldDescription(campoLHost);
            rcdFmtLectura.addFieldDescription(campoLTele);
            rcdFmtLectura.addFieldDescription(campoLData);

            // Creamos Registro de Escritura a Cola de Datos
            CharacterFieldDescription campoEHost = new CharacterFieldDescription(new AS400Text(2, sys), "HOST");
            CharacterFieldDescription campoETele = new CharacterFieldDescription(new AS400Text(3, sys), "TELE");
            CharacterFieldDescription campoEData = new CharacterFieldDescription(new AS400Text(95, sys), "DATA");
            RecordFormat rcdFmtEscritura = new RecordFormat();
            rcdFmtEscritura.addFieldDescription(campoEHost);
            rcdFmtEscritura.addFieldDescription(campoETele);
            rcdFmtEscritura.addFieldDescription(campoEData);

            // Creamos Objetos de Colas de Datos
            DataQueue dataQL = new DataQueue(sys, "/QSYS.LIB/GTAOBJ.LIB/GTASDTAQ.DTAQ");
            DataQueue dataQE = new DataQueue(sys, "/QSYS.LIB/GTAOBJ.LIB/GTARDTAQ.DTAQ");

            System.err.println("**entro GtaSndSocket**");

            while (!salir) {


                // Esperamos un Entrada en la Cola de Lectura por 10 Segundos
                DataQueueEntry dqDatosL = dataQL.read(10);

                // Procesamos Información Leida
                if (dqDatosL == null) {

                    // No hay nada pendiente
                    // Cerramos el Puerto TCP/IP
                    cerrarPuerto();

                } else {

                    // Traducimos los Datos recibidos
                    Record rcdLectura = rcdFmtLectura.getNewRecord(dqDatosL.getData());
                    comando = (String) rcdLectura.getField("TELE");

                    // Procesamos Según Mandato
                    if (comando.equals("END")) {				// Finalizar

                        // Terminamos Ejecución
                        cerrarPuerto();
                        salir = true;

                    } else if (comando.equals("PNG")) {			// Ping

                        // Gestionamos Ping a Sistema GTA
                        if (abrirPuerto()) {
                            cerrarPuerto();
                        }

                    } else if (comando.equals("ABX")) {			// Añadir Caja

                        if (abrirPuerto()) {

                            telegrama = sndSocket(componerABX(rcdLectura));

                        } else {

                            // Error no puedo abrir puerto
                            telegrama = "ERR******";

                        } // endif

                        // Informamos del Estado
                        sndDtaq(dataQE, telegrama, rcdFmtEscritura);

                    } else if (comando.equals("CBD")) {			// Cambiar Caja

                        if (abrirPuerto()) {

                            telegrama = sndSocket(componerABX(rcdLectura));

                        } else {

                            // Error no puedo abrir puerto
                            telegrama = "ERR******";

                        } // endif

                        // Informamos del Estado
                        sndDtaq(dataQE, telegrama, rcdFmtEscritura);

                    } else if (comando.equals("TDN")) {			// Tarea Completada

                        if (abrirPuerto()) {

                            telegrama = sndSocket(componerTDN(rcdLectura));

                        } else {

                            // Error no puedo abrir puerto
                            telegrama = "ERR******";

                        } // endif

                        // Informamos del Estado
                        sndDtaq(dataQE, telegrama, rcdFmtEscritura);

                    } else if (comando.equals("GST")) {			// Estado bulto

                        if (abrirPuerto()) {

                            telegrama = sndSocket(componerGST(rcdLectura));

                        } else {

                            // Error no puedo abrir puerto
                            telegrama = "ERR******";

                        } // endif

                        // Informamos del Estado
                        sndDtaq(dataQE, telegrama, rcdFmtEscritura);

                    } else if (comando.equals("ACT")) {			// Contenido bulto

                        if (abrirPuerto()) {

                            telegrama = sndSocket(componerACT(rcdLectura));

                        } else {

                            // Error no puedo abrir puerto
                            telegrama = "ERR******";

                        } // endif

                        // Informamos del Estado
                        sndDtaq(dataQE, telegrama, rcdFmtEscritura);

                    } else if (comando.equals("ECT")) {			// Fin contenido bulto

                        if (abrirPuerto()) {

                            telegrama = sndSocket(componerECT(rcdLectura));

                        } else {

                            // Error no puedo abrir puerto
                            telegrama = "ERR******";

                        } // endif

                        // Informamos del Estado
                        sndDtaq(dataQE, telegrama, rcdFmtEscritura);


                    } // endif

                } // endif

            } // enddo


            // Realizamos Desconexiones
            sys.disconnectService(AS400.DATAQUEUE);

        } catch (Exception e) {

            System.err.println("**Error GtaSndSocket**");
            System.err.println("Exception: " + e);
            e.printStackTrace();

        } finally {

            sys.disconnectAllServices();
            cerrarPuerto();

        }


    }
    private static DataInputStream gtais;
    private static PrintStream gtaos;
    private static Socket gtaSocket;

    /**
     * Abre la Conexión Sockets
     * Fecha de creación: (02/12/2004 15:47:25)
     * @return boolean
     */
    private static boolean abrirPuerto() {

        // Declaramos variables
        boolean retorno = true;

        try {

            if (gtaSocket == null) {

                Integer port = new Integer(PORTGTA);

//			gtaSocket = new Socket("192.168.44.42", 20002);
                gtaSocket = new Socket(HOSTGTA, port.intValue());
                gtaSocket.setSoTimeout(5000);							// Espera de 5 Segundos
                gtaos = new PrintStream(gtaSocket.getOutputStream());
                gtais = new DataInputStream(gtaSocket.getInputStream());

            } // endif

        } catch (Exception e) {

            retorno = false;

            try {

                if (gtaos != null) {
                    gtaos.close();
                }
                if (gtais != null) {
                    gtais.close();
                }
                if (gtaSocket != null) {
                    gtaSocket.close();
                }

            } catch (Exception e2) {
            }


        }

        if (!retorno) {

            gtaos = null;
            gtais = null;
            gtaSocket = null;

        } // endif


        return retorno;
    }

    /**
     * Cierra la Conexión Sockets
     * Fecha de creación: (02/12/2004 15:47:25)
     * @return boolean
     */
    private static void cerrarPuerto() {


        try {

            if (gtaos != null) {
                gtaos.close();
            }
            if (gtais != null) {
                gtais.close();
            }
            if (gtaSocket != null) {
                gtaSocket.close();
            }

        } catch (Exception e) {
        }

        gtaos = null;
        gtais = null;
        gtaSocket = null;


    }

    /**
     * Genera el Formato de Socket ABX
     * Fecha de creación: (02/12/2004 15:47:25)
     * @return boolean
     */
    private static String componerABX(Record rcdLectura) {

        StringBuffer telegrama = new StringBuffer(111);
        try {

            // Cabecera de Telegrama
            telegrama.append((char) '@');
            //telegrama.append((String) rcdLectura.getField("HOST"));
            telegrama.append(HOSTELE);
            telegrama.append((String) rcdLectura.getField("TELE"));

            // Datos
            String datos = (String) rcdLectura.getField("DATA");
            telegrama.append((String) datos.substring(0, 105));

        } catch (Exception e) {

            telegrama.append("ERROR********");

        }

        return telegrama.toString();
    }

    /**
     * Envia Respuesta por DTAQ
     * Fecha de creación: (02/12/2004 15:47:25)
     * @return boolean
     */
    private static void sndDtaq(DataQueue dataQE, String telegrama, RecordFormat rcdFmtEscritura) {


        try {

            // Generamos Registro a Enviar por la cola de Datos
            Record rcdEscritura = new Record(rcdFmtEscritura);
            rcdEscritura.setField("HOST", HOSTELE);
            rcdEscritura.setField("TELE", telegrama.substring(0, 3));
            rcdEscritura.setField("DATA", telegrama.substring(3));
            byte[] byteData = rcdEscritura.getContents();

            // Enviamos Respuesta
            dataQE.write(byteData);


        } catch (Exception e) {
        }

    }

    /**
     * Envia Socket a GTA
     * Fecha de creación: (02/12/2004 15:47:25)
     * @return boolean
     */
    private static String sndSocket(String telegrama) {

        // Declaramos Variables
        StringBuffer telereto = new StringBuffer(3);
        StringBuffer socketreto = new StringBuffer(30);
        String respuesta = null;
        String comando = null;
        String datos = "  ";
        String telegrasnd = telegrama + '\r' + '\n';
        int envio = 0;
        int chr;

        try {

            // Se intenta el envio 2 veces
            while (envio < 2) {

                // Enviamos Socket
                gtaos.print(telegrasnd);
                gtaos.flush();
                envio++;

                // Esperamos Respuesta
                while ((chr = gtais.read()) != '\n') {
                    socketreto.append((char) chr);
                }

                // Verificamos Respuesta
                respuesta = socketreto.toString();
                comando = respuesta.substring(3, 6);

                // Si respuesta es NAK reintentamos
                if (!comando.equals("NAK")) {
                    envio++;
                }

                // Respuestas Correctas (ACK/DUP)
                if (comando.equals("DUP")) {
                    comando = "OK ";
                }

                if (comando.equals("ACK")) {

                    comando = "OK ";

                    // Recuperamos Datos de GTA
                    if (respuesta.length() > 6) {
                        datos = respuesta.substring(6, (respuesta.length() - 1));
                    } else {
                        datos = "******";
                    } // endif

                } // endif

            } // enddo

            // componemos telegrama de retorno
            telereto.append(comando);
            telereto.append(datos);


        } catch (Exception e) {

            // Indicamos Error y salimos
            telereto.append("ERR******");

            // Cerramos Puerto
            cerrarPuerto();

        }

        return telereto.toString();
    }

    /**
     * Genera el Formato de Socket GST
     * Fecha de creación: (02/12/2004 15:47:25)
     * @return boolean
     */
    private static String componerGST(Record rcdLectura) {

        StringBuffer telegrama = new StringBuffer(16);

        try {

            // Cabecera de Telegrama
            telegrama.append((char) '@');
            //telegrama.append((String) rcdLectura.getField("HOST"));
            telegrama.append(HOSTELE);
            telegrama.append((String) rcdLectura.getField("TELE"));

            // Datos
            String datos = (String) rcdLectura.getField("DATA");
            telegrama.append((String) datos.substring(0, 10));

        } catch (Exception e) {

            telegrama.append("ERROR********");

        }

        return telegrama.toString();
    }

    /**
     * Genera el Formato de Socket TDN
     * Fecha de creación: (02/12/2004 15:47:25)
     * @return boolean
     */
    private static String componerTDN(Record rcdLectura) {

        StringBuffer telegrama = new StringBuffer(18);

        try {

            // Cabecera de Telegrama
            telegrama.append((char) '@');
            //telegrama.append((String) rcdLectura.getField("HOST"));
            telegrama.append(HOSTELE);
            telegrama.append((String) rcdLectura.getField("TELE"));

            // Datos
            String datos = (String) rcdLectura.getField("DATA");
            telegrama.append((String) datos.substring(0, 12));

        } catch (Exception e) {

            telegrama.append("ERROR********");

        }

        return telegrama.toString();
    }

    /**
     * Genera el Formato de Socket ACT
     * Fecha de creación: (02/12/2004 15:47:25)
     * @return boolean
     */
    private static String componerACT(Record rcdLectura) {

        StringBuffer telegrama = new StringBuffer(100);

        try {

            // Cabecera de Telegrama
            telegrama.append((char) '@');
            //telegrama.append((String) rcdLectura.getField("HOST"));
            telegrama.append(HOSTELE);
            telegrama.append((String) rcdLectura.getField("TELE"));

            // Datos
            String datos = (String) rcdLectura.getField("DATA");
            telegrama.append((String) datos.substring(0, 94));

        } catch (Exception e) {

            telegrama.append("ERROR********");

        }

        return telegrama.toString();
    }

    /**
     * Genera el Formato de Socket ECT
     * Fecha de creación: (02/12/2004 15:47:25)
     * @return boolean
     */
    private static String componerECT(Record rcdLectura) {

        StringBuffer telegrama = new StringBuffer(16);

        try {

            // Cabecera de Telegrama
            telegrama.append((char) '@');
            //telegrama.append((String) rcdLectura.getField("HOST"));
            telegrama.append(HOSTELE);
            telegrama.append((String) rcdLectura.getField("TELE"));

            // Datos
            String datos = (String) rcdLectura.getField("DATA");
            telegrama.append((String) datos.substring(0, 10));

        } catch (Exception e) {

            telegrama.append("ERROR********");

        }

        return telegrama.toString();
    }

    // Inicializamos variables de Servicio
    static {
        try {

            // Tomamos las propiedades de la conexion del fichero TxRcvXMLCli.propierties
            PropertyResourceBundle dbProp = (PropertyResourceBundle) PropertyResourceBundle.getBundle(CONFIG_DB);

            HOSTGTA = dbProp.getString("ENVIRONMENT.hostGTA");
            PORTGTA = dbProp.getString("ENVIRONMENT.portGTA");
            HOSTELE = dbProp.getString("ENVIRONMENT.hostTele");
            HOSTSGA = dbProp.getString("ENVIRONMENT.hostSGA");

        } catch (Exception e) {

            System.err.println("Err - Asignando propiedades a GtaSndSocket: " + e);
            e.printStackTrace();

        }

    } // static		static final String CONFIG_DB = "GtaSndSocket";	static String HOSTELE = null;	// Datos Configuración Bibliotecas
    static String HOSTGTA = null;
    static String HOSTSGA = null;
    static String PORTGTA = null;
}
