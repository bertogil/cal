package com.berto.security.timereport;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.jboss.security.Util;

/**
 * Secutiry helper
 *
 */
public class SecurityHelper 
{
    public static void main( String[] args )
    {
    	System.out.print("Introduce la contraseña a codificar:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
			System.out.println(encryptPassword(br.readLine()));
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
    
	public static String encryptPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		byte[] passwordBytes = password.getBytes();
		byte[] hash = digest.digest(passwordBytes);
		String passwordHash = Util.encodeBase64(hash);
		return passwordHash;
	}
	
}
