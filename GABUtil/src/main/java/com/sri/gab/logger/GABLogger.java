package com.sri.gab.logger;
import org.apache.logging.log4j.core.Logger;


// This is a logger wrapper class and is required to be used in all the classes where the logging is needed.
public class GABLogger extends Logger{

	private static final long serialVersionUID = -3322235225498326070L;

	private GABLogger(String fqcn){
		super(GABLoggerContext.getContext(),fqcn, GABLoggerContext.getMessageFactory(fqcn) );
	}
	 
	public static GABLogger getLogger(String fqcn){
		return new GABLogger(fqcn);
	}
}