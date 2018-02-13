package com.berto.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadReferencesXml {
	public static void main(String[] args) {

		try {

			File file = new File("C:\\referencesOnline.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Reference.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Reference result = (Reference) jaxbUnmarshaller.unmarshal(file);
			System.out.println(result);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
