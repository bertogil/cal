package com.berto.dtaq;

///////////////////////////////////////////////////////////////////////////////
//
// Ejemplo de cola de datos. Este programa utiliza la clase KeyedDataQueue para
// poner registros en una cola de datos.
//
// La clave es un número y los datos son una serie Unicode. Este programa muestra
// una forma de convertir un objeto int en una matriz de bytes y de convertir
// una serie Java en una matriz de bytes para que pueda escribirse en la cola.
//
// Este es el lado del productor del ejemplo de productor/consumidor. Coloca
// elementos de trabajo en la cola para que el consumidor los procese.
//
// Sintaxis del mandato:
//    DQKeyedProducer sistema
//
///////////////////////////////////////////////////////////////////////////////
import java.io.*;
import com.ibm.as400.access.*;

public class DQKeyedProducer extends Object {

    // Cree un lector para obtener entrada del usuario.
    static BufferedReader inputStream =
            new BufferedReader(new InputStreamReader(System.in), 1);

    public static void main(String[] parameters) {

        System.out.println(" ");



        // Si no se ha especificado el nombre del sistema, visualizar texto de ayuda y salir.

        if (parameters.length >= 1) {

            // El primer parámetro es el sistema que contiene la cola de datos.

            String system = "FCCLOG";

            System.out.println("La prioridad es un valor numérico. Los rangos de valores son:");
            System.out.println("  0 -  49 = prioridad baja");
            System.out.println(" 50 - 100 = prioridad media");
            System.out.println("100 +     = prioridad alta");
            System.out.println(" ");

            try {

                // Cree un objeto AS400 para el servidor que tiene la cola de datos.

                AS400 as400 = new AS400(system);

                // Utilice CommandCall para crear la biblioteca que contiene la
                // cola de datos.

                CommandCall crtlib = new CommandCall(as400);
                crtlib.run("CRTLIB JAVADEMO");

                // Cree el objeto cola de datos.

                QSYSObjectPathName name = new QSYSObjectPathName("JAVADEMO", "PRODCON2", "DTAQ");
                KeyedDataQueue dq = new KeyedDataQueue(as400, name.getPath());



                // Cree la cola de datos por si esta es la primera vez que este
                // programa se ejecuta. La excepción de La cola ya existe se captura
                // y no se tiene en cuenta. La longitud de la clave es de cuatro bytes, la longitud
                // de una entrada es de 96 bytes.

                try {
                    dq.create(4, 96);
                } catch (Exception e) {
                }
                ;

                // Obtenga los datos del usuario.

                System.out.print("Especifique nombre: ");
                String message = inputStream.readLine();

                System.out.print("Especifique prioridad: ");
                int priority = getInt();

                // Mientras haya datos para colocar en la cola.

                while (priority > 0) {

                    // Queremos escribir una serie Java como entrada en la cola.
                    // La entrada de la cola de datos es una matriz de bytes; por ello, convierta
                    // la serie a una matriz de bytes.

                    byte[] byteData = message.getBytes("UnicodeBigUnmarked");

                    // La clave es un número. La entrada de la cola de datos es una matriz
                    // de bytes, por lo que debe convertir el objeto int a una matriz de bytes;

                    byte[] byteKey = new byte[4];
                    byteKey[0] = (byte) (priority >>> 24);
                    byteKey[1] = (byte) (priority >>> 16);
                    byteKey[2] = (byte) (priority >>> 8);
                    byteKey[3] = (byte) (priority);


                    System.out.println("");
                    System.out.println("Escribiendo el registro en el servidor...");
                    System.out.println("");

                    // Escriba el registro en la cola de datos.

                    dq.write(byteKey, byteData);

                    // Obtenga el valor siguiente del usuario.

                    System.out.print("Especifique el mensaje: ");
                    message = inputStream.readLine();

                    System.out.print("Especifique la prioridad: ");
                    priority = getInt();
                }
            } catch (Exception e) {

                // Si alguna de las operaciones ha fallado, indique que la operación de cola de datos
                // ha fallado y envíe la excepción a la salida.

                System.out.println("La operación de cola de datos ha fallado");
                System.out.println(e);
            }
        } // Visualice texto de ayuda si los parámetros son incorrectos.
        else {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Los parámetros no son correctos. La sintaxis del mandato es:");
            System.out.println("");
            System.out.println("  DQKeyedProducter sistema");
            System.out.println("");
            System.out.println("Donde");
            System.out.println("");
            System.out.println(" sistema = servidor que tiene la cola de datos");
            System.out.println("");
            System.out.println("Por ejemplo:");
            System.out.println("");
            System.out.println("  DQKeyedProducer miSistema");
            System.out.println("");
            System.out.println("");
        }

        System.exit(0);
    }

    // Esta es la subrutina que obtiene una serie de caracteres del usuario
    // y la convierte a int.
    static int getInt() {
        int i = 0;
        boolean Continue = true;

        while (Continue) {

            try {
                String s = inputStream.readLine();

                i = (new Integer(s)).intValue();
                Continue = false;
            } catch (Exception e) {
                System.out.println(e);
                System.out.print("Especifique un número ==>");
            }
        }

        return i;
    }
}
