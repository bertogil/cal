package com.berto.dtaq;

///////////////////////////////////////////////////////////////////////////////
//
// Ejemplo de cola de datos por clave. Este programa utiliza las clases KeyedDataQueue
// para leer entradas de una cola de datos en el servidor. Las entradas se colocaron en la
// cola con el programa de ejemplo DQKeyedProducer.
//
// La clave es un número y los datos son una serie unicode. Este programa muestra
// muestra una forma de convertir la matriz de bytes en un objeto int Java
// y leer una matriz de bytes y convertirla a una serie Java.
//
// Este es el lado del consumidor del ejemplo de productor/consumidor. Lee
// entradas de la cola y las procesa.
//
// Sintaxis del mandato:
//    DQKeyedConsumer sistema
//
///////////////////////////////////////////////////////////////////////////////

import com.ibm.as400.access.*;

public class DQKeyedConsumer extends Object
{
   public static void main(String[] parameters)
   {
      System.out.println( " " );

      // Si no se ha especificado un nombre de sistema, visualizar texto de ayuda y salir.
      if (parameters.length >= 1)
      {

         // El primer parámetro es el sistema que contiene la cola de datos.
         String system = parameters[0];

         // Cree matrices de bytes para los límites de prioridad:
         // 100 +    = prioridad alta
         // 50 - 100 = prioridad media
         //  0 -  49 = prioridad baja

         byte [] key0 = new byte[4];
         key0[0] = 0;
         key0[1] = 0;
         key0[2] = 0;
         key0[3] = 0;

         byte [] key50  = new byte[4];
         key50[0] = (byte) (50 >>> 24);
         key50[1] = (byte) (50 >>> 16);
         key50[2] = (byte) (50 >>> 8);
         key50[3] = (byte) (50);

         byte [] key100 = new byte[4];
         key100[0] = (byte) (100 >>> 24);
         key100[1] = (byte) (100 >>> 16);
         key100[2] = (byte) (100 >>> 8);
         key100[3] = (byte) (100);

         try
         {
             // Cree un objeto AS400 para el servidor que tiene la cola de datos.
             AS400 as400 = new AS400(system);

             // Cree el objeto cola de datos que representa la cola de datos
             // en el servidor.

             QSYSObjectPathName name = new QSYSObjectPathName("JAVADEMO",
                                                              "PRODCON2",
                                                              "DTAQ");
             KeyedDataQueue dq = new KeyedDataQueue(as400, name.getPath());
             KeyedDataQueueEntry DQData = null;

             try
             {
                boolean Continue = true;

                // Seguir hasta que el usuario finalice la operación.
                while (Continue)
                {
                   // Busque un elemento de prioridad alta en la cola. Si
                   // encuentra uno, procéselo. Observe que el método peek no
                   // elimina el elemento si encuentra uno. Observe también que el tiempo de espera
                   // es 0. Si no encuentra ningún elemento, se recuperará el control con
                   // una entrada de cola de datos nula.
                   DQData = dq.read(key100, 0, "GE");

                   if (DQData != null)
                   {
                      processEntry(DQData);
                   }

                   // Si no se ha encontrado ningún elemento de prioridad alta, busque un valor medio
                   // para el elemento de prioridad.
                   else
                   {
                      DQData = dq.read(key50, 0, "GE");

                      if (DQData != null)
                      {
                         processEntry(DQData);
                      }

                      // Si no se ha encontrado ningún elemento de prioridad media, busque un valor bajo
                      // para el elemento de prioridad.
                      else
                      {
                         DQData = dq.read(key0, 0, "GE");

                         if (DQData != null)
                         {
                            processEntry(DQData);
                         }

                         else
                         {
                           System.out.println("No hay nada para procesar; se comprobará de nuevo en 30 segundos");
                           Thread.sleep(30000);
                         }
                      }
                   }
                }
             }
             catch (Exception e)
             {
                // Si alguna de las operaciones ha fallado, indique que la operación de cola de datos
                // ha fallado y envíe la excepción a la salida.
                System.out.println("No es posible leer en la cola de datos.");
                System.out.println(e);
             };

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
         System.out.println(" DQKeyedConsumer sistema");
         System.out.println("");
         System.out.println("Donde");
         System.out.println("");
         System.out.println(" sistema = Servidor que tiene la cola de datos");
         System.out.println("");
         System.out.println("Por ejemplo:");
         System.out.println("");
         System.out.println("");
         System.out.println(" DQKeyedConsumer miSistema");
         System.out.println("");
         System.out.println("");
      }

      System.exit (0);
   }

   static void processEntry(KeyedDataQueueEntry DQData)
   {
      try
      {
          // Los datos son una serie. Obtenga la serie de la entrada de cola de datos.
          // En la entrada de cola de datos, los datos son una matriz de bytes; por ello, convierta
          // la entrada de una matriz de bytes a una serie.
          String message  = new String(DQData.getData(), "UnicodeBig");

          // La clave es una matriz de bytes. Obtenga la clave de la entrada de cola de datos
          // y conviértala a un número.
          byte [] keyData = DQData.getKey();

          int keyValue = ((keyData[0] & 0xFF) << 24) +
                         ((keyData[1] & 0xFF) << 16) +
                         ((keyData[2] & 0xFF) <<  8) +
                          (keyData[3] & 0xFF);

          // Envíe la entrada a la salida.
          System.out.println("Prioridad: " + keyValue + "   nombre: " + message);

      }
      catch (Exception e)
      {
         // Si alguna de las operaciones ha fallado, indique que la operación de cola de datos
         // ha fallado y envíe la excepción a la salida.

         System.out.println("No es posible leer en la cola de datos");
         System.out.println(e);
      }
   }
}