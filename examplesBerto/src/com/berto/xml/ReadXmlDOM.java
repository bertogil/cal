package com.berto.xml;

/**
 *
 * @author berto.gil
 */
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadXmlDOM {

    public static void main(String[] args) throws Exception {
        String file = "C:\\ejemplo.xml";
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
        domBuilder.parse(file);
        //System.out.println("'" + args[0] + "' is well-formed.");
        System.out.println("'" + file + "' is well-formed.");
    }
}
