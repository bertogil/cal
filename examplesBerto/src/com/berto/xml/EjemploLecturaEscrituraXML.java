package com.berto.xml;

/**
 *
 * @author berto.gil
 * Lee y escribe fichero xml
 */
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EjemploLecturaEscrituraXML {

    private static String nodoName;
    private static String nodoValue;

    public static void main(String[] args) {

        try {
            // Lectura de fichero_origen.xml
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File("C:\\ejemplo.xml"));

            // Ahora documento es el XML leido en memoria.

            // Nos devuelve el nodo raíz del documento XML.
            Node nodoRaiz = documento.getFirstChild();
            nodoName = nodoRaiz.getNodeName();
            nodoValue = nodoRaiz.getTextContent();

            // Devuelve nodos hijos de un nodo dado
            NodeList listaNodosHijos = nodoRaiz.getChildNodes();
            for (int i = 0; i < listaNodosHijos.getLength(); i++) {
                Node unNodoHijo = listaNodosHijos.item(i);
            }

            // Obtener los atributos de un nodo
            // NamedNodeMap atributos = documento.getAttributes();
            // Node unAtributo = atributos.getNamedItem("DOCUMENTO");
            // String valorAtributo = unAtributo.getNodeValue();

            // Escritura de fichero_destino.xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File("C:\\ejemploR.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
