package com.berto.api.googlemaps;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.h2.util.IOUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Recupera datos de la api de googlemaps
 * 
 * @author berto.gil
 */
public class TestApiGoogleMaps {

	private static final String ADDRESS = "Carrer de Bellavista 33 L'Hospitalet de Llobregat";
	private static final String URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
	private static String statusCode;

	public static void main(String[] args) throws Exception {
		GAddress codigos = geocode(ADDRESS);
	}

	public static GAddress geocode(String address) throws Exception {
		URL url = new URL(URL + URLEncoder.encode(address, "UTF-8") + "&sensor=true");
		URLConnection conn = url.openConnection();
		ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
		IOUtils.copy(conn.getInputStream(), output);
		output.close();

		GAddress gaddr = new GAddress();
		JSONObject json = JSONObject.fromObject(output.toString());

		// Resultados contiene todo lo que este dentro de la etiqueta results
		JSONArray resultados = json.getJSONArray("results");

		statusCode = json.getString("status");

		if (statusCode.equals("OK")) {

			// Resultado contiene el primer resultado
			JSONObject resultado = resultados.getJSONObject(0);
			// Recuperamos los datos de la etiqueta geometry
			JSONObject geometry = resultado.getJSONObject("geometry");
			JSONObject location = geometry.getJSONObject("location");

			// Address_components contiene todo lo que este dentro de la
			// etiqueta
			// address_components
			JSONArray address_components = resultado.getJSONArray("address_components");
			System.out.println(address_components);
			System.out.println("------------------------------------------------------------");
			for (int i = 0; i < address_components.size(); i++) {
				JSONObject address_component = address_components.getJSONObject(i);
				System.out.println(address_component);
			}
			
			System.out.println(address_components);
			
			System.out.println("------------------------------------------------------------");

			try {
				// Address_component contiene todo lo que este dentro de la
				// primera
				// etiqueta de address_component
				JSONObject address_component = address_components.getJSONObject(0);
				JSONObject address_component1 = address_components.getJSONObject(1);
				JSONObject address_component2 = address_components.getJSONObject(2);
				JSONObject address_component3 = address_components.getJSONObject(3);
				JSONObject address_component4 = address_components.getJSONObject(4);
				JSONObject address_component5 = address_components.getJSONObject(5);
				JSONObject address_component6 = address_components.getJSONObject(6);

				// Long_name1 contiene el valor de la primera etiqueta
				// long_name1
				String street_number = address_component.getString("long_name");
				String street = address_component1.getString("long_name");
				String locality = address_component2.getString("long_name");
				String country = address_component5.getString("short_name");

				System.out.println("Calle: " + street);
				System.out.println("Localidad: " + locality);
				System.out.println("País: " + country);

				gaddr.setAddress(street);
				gaddr.setFullAddress(street + " " + street_number);
				gaddr.setZipCode(address_component6.getString("long_name"));
				gaddr.setLat(Double.parseDouble(location.getString("lat")));
				gaddr.setLng(Double.parseDouble(location.getString("lng")));
				gaddr.setCity(locality);
				gaddr.setState(country);
				gaddr.setCode(200);
			} catch (IndexOutOfBoundsException e) {
			}
		} else {
			gaddr.setCode(600);
		}
		// Control de error sin datos

		return gaddr;
	}

	/*
	 * Permite anidar query para json nested objects, ie. Placemark[0].address
	 */
	private static Object query(JSONObject jo, String query) {
		try {
			String[] keys = query.split("\\.");
			Object r = queryHelper(jo, keys[0]);
			for (int i = 1; i < keys.length; i++) {
				r = queryHelper(JSONObject.fromObject(r), keys[i]);
			}
			return r;
		} catch (Exception e) {
			return "";
		}
	}

	/* Ayuda a encontrar en los objetos: Placemark[0] */
	private static Object queryHelper(JSONObject jo, String query) {
		int openIndex = query.indexOf('[');
		int endIndex = query.indexOf(']');
		if (openIndex > 0) {
			String key = query.substring(0, openIndex);
			int index = Integer.parseInt(query.substring(openIndex + 1, endIndex));
			return jo.getJSONArray(key).get(index);
		}
		return jo.get(query);
	}

	/* Metodo que reemplaza simbolos raros */
	public static String replaceCodigos(String codigo) {

		codigo = codigo.replace('(', ' ');
		codigo = codigo.replace(')', ' ');
		codigo = codigo.replace('/', ' ');
		codigo = codigo.replace('\\', ' ');
		codigo = codigo.replace('*', ' ');
		codigo = codigo.replace('?', ' ');
		codigo = codigo.replace('[', ' ');
		codigo = codigo.replace(']', ' ');
		codigo = codigo.replace(',', ' ');
		codigo = codigo.replace('-', ' ');
		codigo = codigo.replace('.', ' ');
		// codigo = codigo.replace('#', 'Ñ');

		return codigo;
	}
}
