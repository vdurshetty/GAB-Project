package com.sri.gab.db.dao;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

import com.sri.gab.db.util.HibernateUtil;



public class HibernateUtilTest {
	
	@Test
	public void testHibernateSession() {
		SessionFactory SF = HibernateUtil.getSessionFactory();
		Assert.assertNotNull(SF);
	}

}
