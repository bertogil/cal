package com.berto.dtaq;

///////////////////////////////////////////////////////////////////////////////
//
// Ejemplo de cola de datos. Este programa utiliza la clase DataQueue para
// poner registros en una cola de datos.
//
// Este ejemplo utiliza las clases de registro y de formato de registro para
// poner datos en la cola. Los datos de serie se convierten de Unicode a ebcdic
// y los números se convierten de formato Java a formato del servidor. Dado que
// los datos se convierten, las entradas de cola de datos pueden ser leídas por un
// programa del servidor o un programa iSeries Access para Windows y otro programa Java.
//
// Este es el lado del productor del ejemplo de productor/consumidor. Coloca
// elementos de trabajo en la cola para que el consumidor los procese.
//
// Sintaxis del mandato:
//    DQProducerExample sistema
// @author berto.gil
///////////////////////////////////////////////////////////////////////////////
import java.io.*;
import com.ibm.as400.access.*;

public class DQProducerExample extends Object {
    // Create a reader to get input from the user.

    static BufferedReader inputStream =
            new BufferedReader(new InputStreamReader(System.in), 1);

    public static void main(String[] parameters) {
        System.out.println(" ");

        // if the system name was not specified, display help text and exit.
        if (parameters.length >= 1) {
            try {
                // The first parameter is the system that contains the data queue.
                String system = parameters[0];

                // Create an AS400 object for the server that has the data queue.
                AS400 as400 = new AS400(system);

                // Construya un formato de registro para el formato de la entrada de cola de datos.
                // Este formato coincide con el formato de la clase DQConsumer. Un
                // registro está formado por los elementos siguientes:
                //    - un número de cuatro bytes -- el número de cliente
                //    - un número de cuatro bytes -- el número de pieza
                //    - una serie de 20 caracteres -- la descripción de la pieza
                //    - un número de cuatro bytes -- el número de piezas de este pedido

                // First create the base data types.
                CharacterFieldDescription customerNumber =
                        new CharacterFieldDescription(new AS400Text(20, as400), "CUSTOMER_NUMBER");

                CharacterFieldDescription partNumber =
                      new CharacterFieldDescription(new AS400Text(20, as400), "PART_NUMBER");

                CharacterFieldDescription partName =
                        new CharacterFieldDescription(new AS400Text(20, as400), "PART_NAME");

                CharacterFieldDescription quantity =
                       new CharacterFieldDescription(new AS400Text(20, as400), "QUANTITY");

                // Build a record format and fill it with the base data types.
                RecordFormat dataFormat = new RecordFormat();
                dataFormat.addFieldDescription(customerNumber);
                dataFormat.addFieldDescription(partNumber);
                dataFormat.addFieldDescription(partName);
                dataFormat.addFieldDescription(quantity);

                // Create the library that contains the data queue
                // using CommandCall.
                CommandCall crtlib = new CommandCall(as400);
                crtlib.run("CRTLIB JAVADEMO");

                // Create the data queue object.
                DataQueue dq = new DataQueue(as400, "/QSYS.LIB/JAVADEMO.LIB/PRODCONS.DTAQ");

                // Create the data queue just in case this is the first time this
                // program has run.  The queue already exists exception is caught
                // and ignored.
                try {
                    dq.create(96);
                } catch (Exception e) {
                }
                ;

                // Get the first field of data from the user.
                System.out.print("Enter customer number (or 0 to quit): ");
                int customer = getInt();

                // While there is data to put on the queue.
                while (customer > 0) {
                    // Get the rest of the data for this order from the user.
                    System.out.print("Enter part number: ");
                    int part = getInt();

                    System.out.print("Enter quantity: ");
                    int quantityToOrder = getInt();

                    String description = "part " + part;

                    // Create a record based on the record format.  The record
                    // is empty now but will eventually contain the data.
                    Record data = new Record(dataFormat);

                    // Set the values we received from the user into the record.
                    data.setField("CUSTOMER_NUMBER", String.valueOf(new Integer(customer)));
                    data.setField("PART_NUMBER",  String.valueOf(new Integer(part)));
                    data.setField("QUANTITY",  String.valueOf(new Integer(quantityToOrder)));
                    data.setField("PART_NAME", description);

                    // Convert the record into a byte array.  The byte array is
                    // what is actually put to the data queue.
                    byte[] byteData = data.getContents();

                    System.out.println("");
                    System.out.println("Writing record to the server ...");
                    System.out.println("");

                    // Write the record to the data queue.
                    dq.write(byteData);

                    // Get the next value from the user.
                    System.out.print("Enter customer number (or 0 to quit): ");
                    customer = getInt();
                }
            } catch (Exception e) {
                // If any of the above operations failed say the data queue
                // operation failed and output the exception.

                System.out.println("Data Queue operation failed");
                System.out.println(e);
            }
        } // Display help text when parameters are incorrect.
        else {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Parameters are not correct. Command syntax is:");
            System.out.println("");
            System.out.println(" DQProducter system");
            System.out.println("");
            System.out.println("Where");
            System.out.println("");
            System.out.println(" system = Server that has the data queue");
            System.out.println("");
            System.out.println("For example:");
            System.out.println("");
            System.out.println(" DQProducerExample mySystem");
            System.out.println("");
            System.out.println("");
        }

        System.exit(0);
    }

    // This is the subroutine that gets a character string from the user
    // and converts it into an int.
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
                System.out.print("Please enter a number ==>");
            }
        }

        return i;
    }
}
