package com.berto.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class CrearXmlDesdeObjeto {

	public static void main(String[] args) {
		
		List<Matricula> matriculaList = new ArrayList<Matricula>();
		generateXML(new Matricula("M1234", "780", "lot1", "ref1", 25, matriculaList));
	}

	public static void generateXML(Matricula matricula) {

		try {

			JAXBContext jc = JAXBContext.newInstance(Matricula.class);
			Marshaller jaxbMarshaller = jc.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(matricula, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
