package com.berto.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadTotalTimeRanksXml {
	public static void main(String[] args) {

		try {

			File file = new File("C:\\totaltimeranks.xml");
			JAXBContext jaxbContext = JAXBContext
					.newInstance(TotalTimeRanks.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			TotalTimeRanks result = (TotalTimeRanks) jaxbUnmarshaller
					.unmarshal(file);
			System.out.println(result);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
