package com.sri.gab.env;

import org.junit.Test;

import org.junit.Assert;

public class GABReadEnvTest {
	@Test
	public void readLoggerFileName() {
		String loggerFileName = GABReadEnv.getEnvValue(GABEnvProp.LoggerFileName);
		Assert.assertEquals("conf/log4j2.xml", loggerFileName);
	}
	
	@Test
	public void readHibernateConfFile() {
		String loggerFileName = GABReadEnv.getEnvValue(GABEnvProp.HibernateConfFile);
		Assert.assertEquals("conf/hibernate.cfg.xml", loggerFileName);
	}
	
	
	@Test
	public void readDBConfig() {
		String dbURL = GABReadEnv.getEnvValue(GABEnvProp.DBUrl);
		String dbUser = GABReadEnv.getEnvValue(GABEnvProp.DBUserName);
		Assert.assertEquals("jdbc:postgresql://localhost:5432/postgres", dbURL);
		Assert.assertEquals("postgres", dbUser);
	}
	
}
