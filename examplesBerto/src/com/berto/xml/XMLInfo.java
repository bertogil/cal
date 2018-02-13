package com.berto.xml;

/**
 *
 * @author berto.gil
 * Clase que lee un fichero xml y nos muestra los elementos de
 * los que consta
 */

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLInfo {

  public static void main(String args[]) {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse("c:\\ejemplo.xml");
      Node root = document.getDocumentElement();
      System.out.print("Here is the document's root node:");
      System.out.println(" " + root.getNodeName());
      System.out.println("Here are its child elements: ");
      NodeList childNodes = root.getChildNodes();
      Node currentNode;

      for (int i = 0; i < childNodes.getLength(); i++) {
        currentNode = childNodes.item(i);
        System.out.println(currentNode.getNodeName());
      }

      // get first child of root element
      currentNode = root.getFirstChild();

      System.out.print("The first child of root node is: ");
      System.out.println(currentNode.getNodeName());

      // get next sibling of first child
      System.out.print("whose next sibling is: ");
      currentNode = currentNode.getNextSibling();
      System.out.println(currentNode.getNodeName());

      // print value of next sibling of first child
      System.out.println("value of " + currentNode.getNodeName() + " element is: "
          + currentNode.getFirstChild().getNodeValue());

      // print name of parent of next sibling of first child
      System.out.print("Parent node of " + currentNode.getNodeName() + " is: "
          + currentNode.getParentNode().getNodeName());
    }
    // handle exception creating DocumentBuilder
    catch (ParserConfigurationException parserError) {
      System.err.println("Parser Configuration Error");
      parserError.printStackTrace();
    }

    // handle exception reading data from file
    catch (IOException fileException) {
      System.err.println("File IO Error");
      fileException.printStackTrace();
    }

    // handle exception parsing XML document
    catch (SAXException parseException) {
      System.err.println("Error Parsing Document");
      parseException.printStackTrace();
    }
  }
}
