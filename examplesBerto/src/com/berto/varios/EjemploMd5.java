package com.berto.varios;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class EjemploMd5 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// Ejemplo de codificacion MD5 con return del resultado
		System.out.println("Ejemplo MD5: " + getMD5("berto1"));
		// Ejemplo de codificacion MD5 con otro código
		System.out.println("Codificacion Base64: " + getMD5Chuki("berto1"));
	}

	public static String getMD5(String entrada) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(entrada.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static String getMD5Chuki(String entrada)
			throws NoSuchAlgorithmException {
		String result = "";
		MessageDigest md = MessageDigest
				.getInstance(MessageDigestAlgorithms.MD5);
		md.update(entrada.getBytes());
		byte[] digest = md.digest();

		// Se escribe byte a byte en hexadecimal
		for (byte b : digest) {

			result = result + Integer.toHexString(0xFF & b);

		}
		System.out.println("Ejemplo MD5 código Ckuki: " + result);

		// Se escribe codificado base 64. Se necesita la librería
		// commons-codec-x.x.x.jar de Apache
		byte[] encoded = Base64.encodeBase64(digest);
		return new String(encoded);
	}

}
