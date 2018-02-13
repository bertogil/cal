package com.berto.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EjemploFranXml {
	private static String iDoc;

	public static void main(String[] args) {
		iDoc = getIDoc("c:/ejemploFranXml.xml");
	}

	/** Método que recupera el iDoc */
	private static String getIDoc(String TDXparamArchivo) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File(TDXparamArchivo));
			doc.getDocumentElement().normalize();

			/** Recuperamos lista de datos de la etiqueta */
			NodeList nodeList = doc
					.getElementsByTagName("Bulto");

			if (nodeList.getLength() != 0) {
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node elementNode = nodeList.item(i);
					if (elementNode.getNodeType() == Node.ELEMENT_NODE) {
						Element elemento = (Element) elementNode;

						/** Recuperamos idoc */
						iDoc = getTagValue("Fichero",
								elemento);
						System.out.println(iDoc);
					}
				}
			}

		
		} catch (Exception e) {
			e.printStackTrace();

		}
		return iDoc;
	}

	/** Método que recupera el valor de una etiqueta */
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();
		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();

	}

}
