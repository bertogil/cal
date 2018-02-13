package com.berto.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadTimeRanksXml {
	public static void main(String[] args) {

		try {

			File file = new File("C:\\timeranks.xml");
			JAXBContext jaxbContext = JAXBContext
					.newInstance(TimeRanks.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			TimeRanks result = (TimeRanks) jaxbUnmarshaller
					.unmarshal(file);
			System.out.println(result);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
