package com.berto.security.as400;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400SecurityException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author berto.gil
 */
public class ExampleAuthenticate {

    static BufferedReader inputStream =
            new BufferedReader(new InputStreamReader(System.in), 1);

    public static void main(String[] parameters) throws AS400SecurityException, IOException {

        // Declaramos variables
        boolean wOk = false;

        // As400
        String system = "FCCLOG";

        // Crea el objeto AS400 con el sistema correspondiente
        AS400 as400 = new AS400(system);

        // Pide datos
        System.out.print("Usuario: ");
        String pUsr = inputStream.readLine();

        System.out.print("Password: ");
        String pPass = inputStream.readLine();

        try {
            // Comprueba si usuario y password son correctos
            wOk = as400.authenticate(pUsr, pPass);

            if (wOk = true) {
                // Chekeamos el Usuario/Pass
                as400 = new AS400(system, pUsr, pPass);
                System.out.println("");
                System.out.println("El usuario está validado ...");
                System.out.println("");
            }
        } catch (Exception e) {
            System.err.println("Err - Chekeando usuario (" + pUsr + ") (" + pPass + ") :" + e);
            wOk = false;
        } finally {
            as400.disconnectAllServices();
            as400 = null;
        } // endtry
    }
}
