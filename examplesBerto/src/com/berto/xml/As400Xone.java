/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.berto.xml;

/**
 *
 * @author berto.gil
 */
import java.io.File;
import java.io.PrintWriter;
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

public class As400Xone {

    public static void main(String[] argv) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation impl = builder.getDOMImplementation();
        Document doc = impl.createDocument(null, null, null);
        // Raiz
        Element rutas = doc.createElement("rutas");
        doc.appendChild(rutas);
        // Primer nivel ruta
        Element ruta = doc.createElement("ruta");
        rutas.appendChild(ruta);
        // Segundo nivel Albaranes
        Element albaranes = doc.createElement("albaranes");
        ruta.appendChild(albaranes);
        // Tercer nivel Albaran
        Element albaran = doc.createElement("albaran");
        albaranes.appendChild(albaran);

        // Elementos ruta
        // Almacen
        Element almacen = doc.createElement("almacen");
        ruta.appendChild(almacen);
        almacen.appendChild(doc.createTextNode("A99"));
        // Agencia
        Element agencia = doc.createElement("agencia");
        ruta.appendChild(agencia);
        agencia.appendChild(doc.createTextNode("agencia1"));
        // Conductor
        Element conductor = doc.createElement("conductor");
        ruta.appendChild(conductor);
        conductor.appendChild(doc.createTextNode("conductor1"));
        // Matricula
        Element matricula = doc.createElement("matricula");
        ruta.appendChild(matricula);
        matricula.appendChild(doc.createTextNode("0000-AAA"));

        // Elementos albaran
        // Tipo
        Element tipo = doc.createElement("tipo");
        albaran.appendChild(tipo);
        tipo.appendChild(doc.createTextNode("E"));
        // Almacen
        albaran.appendChild(almacen);
        // Codigo Cliente
        Element codcliente = doc.createElement("codcliente");
        albaran.appendChild(codcliente);
        codcliente.appendChild(doc.createTextNode("00990"));
        // Cliente
        Element cliente = doc.createElement("cliente");
        albaran.appendChild(cliente);
        cliente.appendChild(doc.createTextNode("00990"));
        // Direccion
        Element direccion = doc.createElement("direccion");
        albaran.appendChild(direccion);
        direccion.appendChild(doc.createTextNode("direccion1"));
        // Poblacion
        Element poblacion = doc.createElement("poblacion");
        albaran.appendChild(poblacion);
        poblacion.appendChild(doc.createTextNode("poblacion1"));
        // Provincia
        Element provincia = doc.createElement("provincia");
        albaran.appendChild(provincia);
        provincia.appendChild(doc.createTextNode("provincia1"));
        // Codigo postal
        Element cp = doc.createElement("cp");
        albaran.appendChild(cp);
        cp.appendChild(doc.createTextNode("cp"));
        // Observaciones
        Element observaciones = doc.createElement("observaciones");
        albaran.appendChild(observaciones);
        observaciones.appendChild(doc.createTextNode("observaciones"));
        // Bultos
        Element bultos = doc.createElement("bultos");
        albaran.appendChild(bultos);
        //bultos.appendChild(doc.createTextNode("2"));

        ruta.setAttribute("id", "codigoruta");
        ruta.setAttribute("value", "numero viaje");
        ruta.setAttribute("telf", "123456789");
        albaran.setAttribute("id", "codigoalbaran");
        bultos.setAttribute("total", "2");

        DOMSource domSource = new DOMSource(doc);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult sr = new StreamResult(new File("C:\\AS400-Xone.xml"));
        transformer.transform(domSource, sr);
    }
}
