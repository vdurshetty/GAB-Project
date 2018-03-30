package com.sri.gab.security;

/**
 * A utility class that encrypts or decrypts a file.
 * @author www.codejava.net
 *
 */
public class CryptoUtils {
		private static String asciiToHex(String asciiStr) {
		    char[] chars = asciiStr.toCharArray();
		    StringBuilder hex = new StringBuilder();
		    for (char ch : chars) {
		        hex.append(Integer.toHexString((int) ch));
		    }
		 
		    return hex.toString();
		}
		  
		private static String hexToAscii(String hexStr) {
		    StringBuilder output = new StringBuilder("");
		     
		    for (int i = 0; i < hexStr.length(); i += 2) {
		        String str = hexStr.substring(i, i + 2);
		        output.append((char) Integer.parseInt(str, 16));
		    }
		     
		    return output.toString();
		}
		
		public static void main(String a[]) throws Exception{
			
	         try {
	        	 String inputStr = "VenugopalSri";
	    		String name = asciiToHex(inputStr);
	    		System.out.println("The Given Key is :" + inputStr);
				System.out.println("Hexa decimal value :" + name);
				System.out.println("Hexa decimal value to String :" + hexToAscii(name));
		  
		        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	            ex.printStackTrace();
	        }
	    }
}