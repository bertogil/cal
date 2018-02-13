package com.berto.xml;

/**
 *
 * @author berto.gil
 */
//Example XML document
/*
An XML Document Containing a Simple Contact List
Start example

<?xml version="1.0" standalone="yes"?>

<folks>
   <person>
       <phone>306 555-9999</phone>
       <email>joe@webserver.net</email>
       <name>Wang, Joe</name>
   </person>
   <person>
       <phone>704 555-0000</phone>
       <name>Pet, Rob</name>
       <email>rob@server.com</email>
   </person>
</folks>

*/

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DOMCheck {
   static public void main(String[] arg) {
       String filename = null;
       boolean validate = false;

       if(arg.length == 1) {
           filename = arg[0];
       } else if(arg.length == 2) {
           if(!arg[0].equals("-v"))
               usage();
           validate = true;
           filename = arg[1];
       } else {
           usage();
       }

       // Create a new factory to create parsers that will
       // be aware of namespaces and will validate or
       // not according to the flag setting.
       DocumentBuilderFactory dbf =
DocumentBuilderFactory.newInstance();
       dbf.setValidating(validate);
       dbf.setNamespaceAware(true);

       // Use the factory to create a parser (builder) and use
       // it to parse the document.
       try {
           DocumentBuilder builder = dbf.newDocumentBuilder();
           builder.setErrorHandler(new MyErrorHandler());
           InputSource is = new InputSource(filename);
           Document doc = builder.parse(is);
       } catch (SAXException e) {
           System.exit(1);
       } catch (ParserConfigurationException e) {
           System.err.println(e);
           System.exit(1);
       } catch (IOException e) {
           System.err.println(e);
           System.exit(1);
       }
   }
   private static void usage() {
       System.err.println("Usage: DOMCheck [-v] <filename>");
       System.exit(1);
   }
}
class MyErrorHandler implements ErrorHandler {
  public void warning(SAXParseException e) throws SAXException {
    show("Warning", e);
    throw (e);
  }

  public void error(SAXParseException e) throws SAXException {
    show("Error", e);
    throw (e);
  }

  public void fatalError(SAXParseException e) throws SAXException {
    show("Fatal Error", e);
    throw (e);
  }

  private void show(String type, SAXParseException e) {
    System.out.println(type + ": " + e.getMessage());
    System.out.println("Line " + e.getLineNumber() + " Column "
        + e.getColumnNumber());
    System.out.println("System ID: " + e.getSystemId());
  }
}
