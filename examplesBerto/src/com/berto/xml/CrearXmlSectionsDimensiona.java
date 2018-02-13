package com.berto.xml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class CrearXmlSectionsDimensiona {

	private static List<DeliveryNote> deliveryNotesList = new ArrayList<DeliveryNote>();
	private static List<Section> sectionList = new ArrayList<Section>();

	private static List<Sections> sectionsList = new ArrayList<Sections>();

	public static void main(String[] args) {

		List<Sections> sectionsList = new ArrayList<Sections>();
		generateXML(new Sections("MKD", "MD", getSectionsList()));
	}

	public static void generateXML(Sections sectionsList) {

		try {

			JAXBContext jc = JAXBContext.newInstance(Sections.class);
			Marshaller jaxbMarshaller = jc.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(sectionsList, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static List<Section> getSectionsList() {
		DeliveryNote deliveryNote = new DeliveryNote("1", "PESCADO", "1", "1",
				"28019", "ruta", "sec", "S", "25", "12", "12", "12", "32", "1",
				"23", "12", 1f, 2f, new Date(), new Date());
		DeliveryNote deliveryNote1 = new DeliveryNote("2", "REFRIGERADO", "2",
				"2", "28019", "ruta", "sec", "S", "25", "12", "12", "12", "32",
				"2", "23", "12", 1f, 2f, new Date(), new Date());
		deliveryNotesList.add(deliveryNote);
		deliveryNotesList.add(deliveryNote1);
		Section section = new Section("1", "PESCADO", 1, 10, 11, 12, 13, 14, 1,
				1, 1f, 1f, deliveryNotesList);
		Section section1 = new Section("2", "REFRIGERADO", 1, 10, 11, 12, 13,
				14, 1, 1, 1f, 1f, deliveryNotesList);
		sectionList.add(section);
		sectionList.add(section1);
		return sectionList;
	}

}
