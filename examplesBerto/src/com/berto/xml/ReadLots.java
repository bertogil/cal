package com.berto.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadLots {
	public static void main(String[] args) {

		try {

			File file = new File("C:\\detaillots.xml");
			JAXBContext jaxbContext = JAXBContext
					.newInstance(Lots.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Lots result = (Lots) jaxbUnmarshaller
					.unmarshal(file);
			System.out.println(result);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
