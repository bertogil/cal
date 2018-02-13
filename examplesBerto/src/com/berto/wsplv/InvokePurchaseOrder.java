package com.berto.wsplv;

/**
 * Clase que genera un WebService para cambiar el estado de una orden de compra
 * @autor: Berto Gil
 * @param client Cliente del pedido
 * @param purchaseOrder Nota de entrada a cambiar en web
 * @param urlParam Url que se genera al concatenar client+purchaseOrder
 *
 * @version 01/07/10
 */
import java.net.*;
import java.io.*;

public class InvokePurchaseOrder {

    public static void main(String[] args) throws IOException {

        String cadena;
        String client = args[0];
        String purchaseOrder = args[1];
        String urlParam = client + "/" + purchaseOrder;

        try {
            // Creamos un objeto de tipo URL
            // URL url = new URL("http://bgilh:8080/plv/seam/resource/ws/purchaseOrder/");
            URL url = new URL("http://blfccl2:8080/plv/seam/resource/ws/purchaseOrder/");
            URL urlParm = new URL(url, urlParam);

            // Creamos autentificación
            Authenticator au = new Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("admin@plv.com", "aq+kp2".toCharArray());
                }
            };
            Authenticator.setDefault(au);

            // Abrimos una conexión hacia esa URL, que devolverá un canal de
            // entrada por el cual se podrá leer todo lo que llegue
            BufferedReader paginaHtml =
                    new BufferedReader(new InputStreamReader(urlParm.openStream()));

            // Leemos y presentamos el contenido del fichero en pantalla
            // línea a línea
            // TODO: Se recupera el ok del webService pero no lo utilizamos
            while ((cadena = paginaHtml.readLine()) != null) {
                System.out.println(cadena);
            }

        } catch (UnknownHostException e) {
            System.out.println(
                    "Debes estar conectado para que esto funcione bien.");
        }
    }
}
