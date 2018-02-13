package com.berto.dtaq;


///////////////////////////////////////////////////////////////////////////////
//
// Ejemplo de cola de datos. Este programa utiliza las clases de cola de datos para leer
// entradas de una cola de datos en el servidor. Las entradas se colocaron en la
// cola con el programa de ejemplo DQProducer.
//
// Este es el lado del consumidor del ejemplo de productor/consumidor. Lee
// entradas de la cola y las procesa.
//
// Sintaxis del mandato:
//    DQConsumerExample sistema
// @author berto.gil
///////////////////////////////////////////////////////////////////////////////


import com.ibm.as400.access.*;

public class DQConsumerExample extends Object
{
   public static void main(String[] parameters)
   {
      System.out.println( " " );

      // Si no se ha especificado un nombre de sistema, visualizar texto de ayuda y salir.
      if (parameters.length >= 1)
      {
         try
         {

             // El primer parámetro es el sistema que contiene la cola de datos.
             String system = parameters[0];

             // Cree un objeto AS400 para el servidor que tiene la cola de datos.
             AS400 as400 = new AS400(system);


             // Construya un formato de registro para el formato de la entrada de cola de datos.
             // Este formato coincide con el formato de la clase DQProducer. Un
             // registro está formado por los elementos siguientes:
             //    - un número de cuatro bytes -- el número de cliente
             //    - un número de cuatro bytes -- el número de pieza
             //    - una serie de 20 caracteres -- la descripción de la pieza
             //    - un número de cuatro bytes -- el número de piezas de este pedido

             // Primero cree los tipos de datos base.
             BinaryFieldDescription customerNumber =
                new BinaryFieldDescription(new AS400Bin4(), "CUSTOMER_NUMBER");

             BinaryFieldDescription partNumber =
                new BinaryFieldDescription(new AS400Bin4(), "PART_NUMBER");

             CharacterFieldDescription partName =
                new CharacterFieldDescription(new AS400Text(20, as400), "PART_NAME");

             BinaryFieldDescription quantity =
                new BinaryFieldDescription(new AS400Bin4(), "QUANTITY");

             // Construya un formato de registro y llénelo con los tipos de datos base.
             RecordFormat dataFormat = new RecordFormat();

             dataFormat.addFieldDescription(customerNumber);
             dataFormat.addFieldDescription(partNumber);
             dataFormat.addFieldDescription(partName);
             dataFormat.addFieldDescription(quantity);

             // Cree el objeto cola de datos que representa la cola de datos en
             // el servidor.
             DataQueue dq = new DataQueue(as400, "/QSYS.LIB/JAVADEMO.LIB/PRODCONS.DTAQ");

             boolean Continue = true;

             // Lea la primera entrada de la cola. El valor de tiempo de espera es
             // -1, por lo que este programa esperará indefinidamente a que llegue una entrada.
             System.out.println("*** Esperando una entrada para procesar ***");

             DataQueueEntry DQData = dq.read(-1);

             while (Continue)
             {

                // Se acaba de leer una entrada de la cola. Ponga los datos en
                // un objeto registro para que el programa pueda acceder a los campos de
                // los datos por nombre. El objeto registro también convertirá
                // los datos del formato del servidor al formato Java.
                Record data = dataFormat.getNewRecord(DQData.getData());

                // Obtenga dos valores del registro y visualícelos.
                Integer amountOrdered = (Integer) data.getField("QUANTITY");
                String  partOrdered   = (String)  data.getField("PART_NAME");

                System.out.println("Se necesita " + amountOrdered + " de "
                                   + partOrdered);
                System.out.println(" ");
                System.out.println("*** Esperando una entrada para procesar ***");

                // Espere la entrada siguiente.
                DQData = dq.read(-1);
             }
         }
         catch (Exception e)
         {
             // Si alguna de las operaciones ha fallado, indique que la operación de cola de datos
             // ha fallado y envíe la excepción a la salida.
             System.out.println("La operación de cola de datos ha fallado");
             System.out.println(e);
         }
      }

      // Visualice texto de ayuda si los parámetros son incorrectos.
      else
      {
         System.out.println("");
         System.out.println("");
         System.out.println("");
         System.out.println("Los parámetros no son correctos. La sintaxis del mandato es:");
         System.out.println("");
         System.out.println(" DQConsumerExample sistema");
         System.out.println("");
         System.out.println("Donde");
         System.out.println("");
         System.out.println(" sistema = Servidor que tiene la cola de datos");
         System.out.println("");
         System.out.println("Por ejemplo:");
         System.out.println("");
         System.out.println(" DQConsumerExample miSistema");
         System.out.println("");
         System.out.println("");
      }

      System.exit (0);
   }
}