package com.sri.gab.logger;

import org.junit.Assert;
import org.junit.Test;


public class GABLoggerTest {
	
	
	private static GABLogger log = GABLogger.getLogger(GABLoggerTest.class.getName());
	
	@Test
	public void logMessage(){
		log.error("Error Message");
		Assert.assertEquals("","");
	}


}
