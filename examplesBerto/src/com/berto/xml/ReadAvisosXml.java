package com.berto.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadAvisosXml {
	public static void main(String[] args) {

		try {

			File file = new File("C:\\avisos.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Aviso.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Aviso result = (Aviso) jaxbUnmarshaller.unmarshal(file);
			for (int i = 0; i < result.getAvisoList().size(); i++) {
				Aviso resultList = result.getAvisoList().get(i);

				// Titulo
				for (int indiceTitulo = 0; indiceTitulo < resultList
						.getTituloList().size(); indiceTitulo++) {

					System.out.println("Titulo: "
							+ resultList.getTituloList().get(indiceTitulo)
									.getLinea());

					// Información
					for (int indiceInformation = 0; indiceInformation < resultList
							.getInformacionList().size(); indiceInformation++) {

						System.out.println("Información: "
								+ resultList.getInformacionList()
										.get(indiceInformation).getLinea());

					}

					// Instrucciones
					for (int indiceInstrucciones = 0; indiceInstrucciones < resultList
							.getInstruccionesList().size(); indiceInstrucciones++) {

						System.out.println("Instrucciones: "
								+ resultList.getInformacionList()
										.get(indiceInstrucciones).getLinea());

					}

				}
				System.out.println("");

			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
