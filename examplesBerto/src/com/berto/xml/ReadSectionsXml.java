package com.berto.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadSectionsXml {
	public static void main(String[] args) {

		try {

			File file = new File("C:\\deliverynotes.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Sections.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Sections result = (Sections) jaxbUnmarshaller.unmarshal(file);
			System.out.println(result);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
