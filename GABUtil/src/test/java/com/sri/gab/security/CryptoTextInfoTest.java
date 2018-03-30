package com.sri.gab.security;

import org.junit.Assert;
import org.junit.Test;


public class CryptoTextInfoTest {

	
	@Test
	public void encryptPassword()  {
		String inputStr = "Testing";
		String encryptStr = null;
		try { 
			encryptStr = CipherTextInfo.encrypt(inputStr);
		} catch (CryptoException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("+xQiFB4WHFqd3rsH1PKSTQ==",encryptStr );
	}
	
	@Test
	public void decryptPassword()  {
		String inputStr = "+xQiFB4WHFqd3rsH1PKSTQ==";
		String decryptStr = null;
		try { 
			decryptStr = CipherTextInfo.decrypt(inputStr);
		} catch (CryptoException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("Testing",decryptStr );
	}
	
	@Test
	public void errorDecrypt()  {
		String inputStr = "+xQiFB4WssfdsdfHFqd3rsH1PKSTQ==ee";
		String decryptStr = null;
		try { 
			decryptStr = CipherTextInfo.decrypt(inputStr);
		} catch (CryptoException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(null,decryptStr );
	}

	
}
