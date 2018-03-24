package com.sri.gab.logger;

import com.sri.gab.env.GABEnvProp;
import com.sri.gab.env.GABReadEnv;

//import org.apache.logging.log4j.ThreadContext;




public class LoggerTest {
	
	private static GABLogger log = GABLogger.getLogger(LoggerTest.class.getName());
	
		
	public static void main(String a[]) throws Exception{
		System.out.println("Log File Name is:" + GABReadEnv.getEnvValue(GABEnvProp.LoggerFileName));
		
	  for (int i=0;i<100;i++){
		log.debug("Hello");
	  log.debug("My Test Log Message");
	  }
	  System.out.println("Venu1 Logger Test Aysnc Logger - End");
	}

}
