package com.berto.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadTotalSectionsXml {
	public static void main(String[] args) {

		try {

			File file = new File("C:\\totalsections.xml");
			JAXBContext jaxbContext = JAXBContext
					.newInstance(TotalSections.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			TotalSections result = (TotalSections) jaxbUnmarshaller
					.unmarshal(file);
			System.out.println(result);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
