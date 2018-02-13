package com.berto.xml;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadPendingPreparationXml {
	public static void main(String[] args) {

		NumberFormat formatter;

		try {

			formatter = new DecimalFormat("#,###");

			File file = new File("C:\\pendingpreparation.xml");
			JAXBContext jaxbContext = JAXBContext
					.newInstance(PendingPreparat.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			PendingPreparat result = (PendingPreparat) jaxbUnmarshaller
					.unmarshal(file);

			// String weightString = result.getPendingPreparationList().get(0)
			// .getWeight().trim();
			//
			// String weightString1 = result.getPendingPreparationList().get(1)
			// .getWeight().trim();

			// String valueStringToLong = weightString.replace(',', '.');
			// String valueStringToLong1 = weightString1.replace(',', '.');
			// System.out.println("Ejemplo de String a Float cambiando coma = "
			// + new Float(valueStringToLong));

			// long weight = Long.valueOf(weightString.replaceAll(",", ".")
			// .toString());
			// long weight1 = Long.valueOf(weightString1.replaceAll(",", ".")
			// .toString());

			System.out.println(result);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
