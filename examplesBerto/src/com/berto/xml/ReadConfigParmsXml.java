package com.berto.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.berto.varios.ConfigParms;

public class ReadConfigParmsXml {
	public static void main(String[] args) {

		try {

			File file = new File("C:\\configuraciones.xml");
			JAXBContext jaxbContext = JAXBContext
					.newInstance(ConfigParms.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ConfigParms result = (ConfigParms) jaxbUnmarshaller.unmarshal(file);
			System.out.println(result);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
