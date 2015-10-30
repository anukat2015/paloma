package com.paloit.paloma.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Static method using Strings.
 * @author DTRANG
 *
 */
public final class CustomStringUtils {

	/**
	 * MD5 type of encryption.
	 */
	private static final String ENCRYPTION_MD5 = "MD5";  
	
	/**
	 * Encrypt the string in md5.
	 * @param input
	 * @return encrypted String
	 */
	public static String encryptMd5(String input){
		
		String md5 = null;
  
        if(null == input) {
        	return null;         
        }
        try {   
	        //Create MessageDigest object for MD5
	        MessageDigest digest = MessageDigest.getInstance(ENCRYPTION_MD5);
	         
	        //Update input string in message digest
	        digest.update(input.getBytes(), 0, input.length());
	 
	        //Converts message digest value in base 16 (hex) 
	        md5 = new BigInteger(1, digest.digest()).toString(16);
	        
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;		
	}
}
