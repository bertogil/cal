package com.berto.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class PrettyXml {

	public static void main(String[] args) {

		System.out.println(prettyFormat("c:\\a_4559955.xml", 2));

	}

	public static String prettyFormat(String input, int indent) {
		try {
			Source xmlInput = new StreamSource(new StringReader(readFileParm(input)));
			StringWriter stringWriter = new StringWriter();
			StreamResult xmlOutput = new StreamResult(stringWriter);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			transformerFactory.setAttribute("indent-number", indent);
			Transformer transformer = transformerFactory.newTransformer();
			//transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(xmlInput, xmlOutput);
			return xmlOutput.getWriter().toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String prettyFormat(String input) {
		return prettyFormat(input, 2);
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
