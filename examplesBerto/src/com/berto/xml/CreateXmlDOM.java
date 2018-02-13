package com.berto.xml;

/**
 *
 * @author berto.gil
 */
import java.io.File;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXmlDOM {

    public static void main(String[] argv) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation impl = builder.getDOMImplementation();
        Document doc = impl.createDocument(null, null, null);
        // Raiz
        Element pod = doc.createElement("pod");
        doc.appendChild(pod);
        // Primer nivel
        Element ruta = doc.createElement("ruta");
        pod.appendChild(ruta);
        // Segundo nivel
        Element albaran = doc.createElement("albaran");
        pod.appendChild(albaran);


        // Elementos ruta
        // Almacen
        Element almacen = doc.createElement("almacen");
        ruta.appendChild(almacen);
        almacen.appendChild(doc.createTextNode("A99"));
        // Fecha Inicio
        Element fechainicio = doc.createElement("fechainicio");
        ruta.appendChild(fechainicio);
        fechainicio.appendChild(doc.createTextNode("2010-01-01"));
        // Hora inicio
        Element horainicio = doc.createElement("horainicio");
        ruta.appendChild(horainicio);
        horainicio.appendChild(doc.createTextNode("12:00:00"));
        // Fecha fin
        Element fechafin = doc.createElement("fechafin");
        ruta.appendChild(fechafin);
        fechafin.appendChild(doc.createTextNode("2010-01-01"));
        // Hora fin
        Element horafin = doc.createElement("horafin");
        ruta.appendChild(horafin);
        horafin.appendChild(doc.createTextNode("12:00:00"));


        // Elementos Albaran
        // Almacen
        albaran.appendChild(almacen);
        // Cliente
        Element cliente = doc.createElement("cliente");
        albaran.appendChild(cliente);
        cliente.appendChild(doc.createTextNode("00990"));
        // Estado
        Element estado = doc.createElement("estado");
        albaran.appendChild(estado);

        //Element estado = doc.createElement("estado");
        //albaran.appendChild(estado);
        //estado.appendChild(doc.createTextNode("B"));
        // Motivo
        Element motivo = doc.createElement("motivo");
        estado.appendChild(motivo);
        motivo.appendChild(doc.createTextNode("AJU"));
        // Fecha
        Element fecha = doc.createElement("fecha");
        estado.appendChild(fecha);
        fecha.appendChild(doc.createTextNode("2010-01-01"));
        // Hora
        Element hora = doc.createElement("hora");
        estado.appendChild(hora);
        hora.appendChild(doc.createTextNode("12:00:00"));
        // Foto
        Element foto = doc.createElement("foto");
        estado.appendChild(foto);
        foto.appendChild(doc.createTextNode("dd83de9f-7d99-40b4-a5cd-4610dbfc6d43.jpg"));
        // Bultos
        Element bultos = doc.createElement("bultos");
        albaran.appendChild(bultos);
        //bultos.appendChild(doc.createTextNode("2"));


        ruta.setAttribute("id", "codigoruta");
        ruta.setAttribute("value", "numero viaje");
        albaran.setAttribute("id", "codigoalbaran");
        estado.setAttribute("id", "1");
        bultos.setAttribute("total", "2");

        DOMSource domSource = new DOMSource(doc);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        // StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(new File("C:\\Xone-AS400.xml"));
        transformer.transform(domSource, sr);
        // System.out.println(sw.toString());
    }
}
