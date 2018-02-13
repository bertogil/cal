package com.berto.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadSimActivitiesXml {
	public static void main(String[] args) {

		try {

			File file = new File("C:\\simactivities.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(SimActivities.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			SimActivities result = (SimActivities) jaxbUnmarshaller
					.unmarshal(file);
			System.out.println(result);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
