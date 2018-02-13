package com.berto.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadMatriculaXml {
	public static void main(String[] args) {

		try {

			File file = new File("C:\\matricula.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Matricula.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Matricula result = (Matricula) jaxbUnmarshaller.unmarshal(file);
			System.out.println(result);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
