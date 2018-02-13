package com.berto.varios;

import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ExampleSaxCdata extends DefaultHandler {
	private Stack<String> currentElement = new Stack<String>();

	public void startElement(String uri, String localName, String qName,
			Attributes attrs) throws SAXException {
		currentElement.push(qName);
	}

	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException {
		currentElement.pop();
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String cdata = new String(ch, start, length);
		System.out.println("Element '" + currentElement.peek()
				+ "' contains text: " + cdata);
	}

	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);
		SAXParser parser = factory.newSAXParser();
		parser.parse("c://saxcdata.xml", new ExampleSaxCdata());
	}
}