package com.berto.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadInvoice {

	public static void main(String[] args) {

		try {

			File file = new File("C:\\invoices.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Invoice.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Invoice result = (Invoice) jaxbUnmarshaller.unmarshal(file);
			//System.out.println(result);
			System.out.println(result.getInvoicesList().get(0).getAmount());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
