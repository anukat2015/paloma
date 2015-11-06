package com.paloit.paloma.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import java.security.InvalidKeyException;
import java.security.Key;

/**
 * Static method using Strings.
 * @author DTRANG
 *
 */
public final class CustomStringUtils {

	/**
	 * Key of encryption.
	 */
	private static final String ENCRYPTION_KEY = "Bar12345Bar12345";
	
	/**
	 * MD5 type of encryption.
	 */
	private static final String ENCRYPTION_AES = "AES";  
		
	/**
	 * Encrypt the string in aes.
	 * @param input
	 * @return encrypted String
	 * 
	 */
	public static byte[] encryptAes(String input) throws Exception{
		
		 // Create key and cipher 
		Key aesKey = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), ENCRYPTION_AES);
		Cipher cipher = Cipher.getInstance(ENCRYPTION_AES);
		
		// encrypt the text
		cipher.init(Cipher.ENCRYPT_MODE, aesKey);
		byte[] encrypted = cipher.doFinal(input.getBytes());
			
		return encrypted;
		
	}
	
	/**
	 * Decrypt the string in aes.
	 * @param input
	 * @return decrypted String
	 * 
	 */
	public static String decryptAes(String input) throws Exception{
		
		 // Create key and cipher 
		Key aesKey = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), ENCRYPTION_AES);
		Cipher cipher = Cipher.getInstance(ENCRYPTION_AES);
		
		// Decrypt the text
		cipher.init(Cipher.DECRYPT_MODE, aesKey);
		String decrypted = new String(cipher.doFinal(input.getBytes()));
		
		return decrypted;
		
	}
}
