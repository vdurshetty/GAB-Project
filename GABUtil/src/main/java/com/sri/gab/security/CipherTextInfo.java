package com.sri.gab.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.sri.gab.logger.GABLogger;


// This class is used to encrypt and decrypt the given string based on AES algorithm 
public class CipherTextInfo {
   
	   private static GABLogger log = GABLogger.getLogger(CipherTextInfo.class.getName());
		
		private static byte[] key = {
	            0x11, 0x48, 0x69, 0x73, 0x49, 0x7a, 0x41, 0x51, 0x65, 0x63, 0x7b, 0x65, 0x74, 0x42, 0x62, 0x69
	    };//"thisIsASecretKey";
		
		//static  byte[]  key = "!@#$!@#$%^&**&^%".getBytes();
		final static String algorithm="AES";
		
		
		public static String encrypt(String data) throws CryptoException {
		  String returnEncryptStr = null;
		   if (data==null) {
			   return returnEncryptStr;
		   }
		   try 
		   {
			   byte[] dataToSend = data.getBytes();
			   Cipher c = Cipher.getInstance(algorithm);
			   SecretKeySpec k =  new SecretKeySpec(key, algorithm);
		       c.init(Cipher.ENCRYPT_MODE, k);
			   byte[] encryptedData = c.doFinal(dataToSend);
			   byte[] encryptedByteValue =    new Base64().encode(encryptedData);
			   returnEncryptStr = new String(encryptedByteValue);//.toString();
		   } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
		       //e.printStackTrace();
		       log.error("Unable to encrypt given input data: ",e.getMessage());
		       throw new CryptoException(e.getMessage());
		   }
		   return  returnEncryptStr;
		}

		public static String decrypt(String data) throws CryptoException{
		   String returnEncryptStr = null;
		   if (data==null) {
			   return returnEncryptStr;
		   }
		   try {
			   byte[] encryptedData  = new Base64().decode(data);
			   Cipher c = Cipher.getInstance(algorithm);
			   SecretKeySpec k = new SecretKeySpec(key, algorithm);
		       c.init(Cipher.DECRYPT_MODE, k);
			   byte[] decrypted = c.doFinal(encryptedData);
		       returnEncryptStr = new String(decrypted);

		   } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			       //e.printStackTrace();
			       log.error("Unable to decrypt given input data: ",e.getMessage());
			       throw new CryptoException(e.getMessage());
	   }
		   return returnEncryptStr;
		}
        
      }