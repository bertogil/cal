package com.berto.xml;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class XmlFormatter {

	public XmlFormatter() {
	}

	public String format(String unformattedXml) {
		try {
			final Document document = parseXmlFile(unformattedXml);

			OutputFormat format = new OutputFormat(parseXmlFile(unformattedXml));
			format.setIndenting(false);
			format.setIndent(2);
			Writer out = new StringWriter();
			XMLSerializer serializer = new XMLSerializer(out, format);
			serializer.serialize(document);

			return out.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Document parseXmlFile(String in) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(in));
			return db.parse(is);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		System.out.println(new XmlFormatter().format(readFileParm("c:\\a_4559955.xml")));
	}

	private static String readFileParm(String param) {
		File fileOrigin = null;
		FileReader fr = null;
		BufferedReader br = null;
		String result = "";

		try {
			/** Recuperamos el fichero de parÃ¡metros */
			fileOrigin = new File(param);

			/** Leemos el fichero */
			fr = new FileReader(fileOrigin);
			br = new BufferedReader(fr);

			String line;
			/** Recuperamos los parÃ¡metros */
			while ((line = br.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		} finally {
			try {
				if (null != fr) {
					/** Cerramos el fichero */
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

		return result;

	}

}