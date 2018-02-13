package com.berto.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadRePrintXml {
	public static void main(String[] args) {

		try {

			File file = new File("C:\\reprint.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(RePrint.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			RePrint result = (RePrint) jaxbUnmarshaller.unmarshal(file);
			System.out.println(result);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
