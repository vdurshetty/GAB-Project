package com.sri.gab.db.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sri.gab.env.GABEnvProp;
import com.sri.gab.env.GABPassword;
import com.sri.gab.env.GABReadEnv;
import com.sri.gab.logger.GABLogger;
import com.sri.gab.security.CipherTextInfo;

public class JdbcConnection {
	
	GABLogger log = GABLogger.getLogger(JdbcConnection.class.getName());
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.error("Unable to load Driver :" + e.getMessage());
			return null;
		}
		Connection connection = null;
		try {
			String url = GABReadEnv.getEnvValue(GABEnvProp.DBUrl);
			String uname = GABReadEnv.getEnvValue(GABEnvProp.DBUserName);
			String pwd = GABPassword.getPassword(GABEnvProp.DBPwd);
			pwd = CipherTextInfo.decrypt(pwd);
			connection = DriverManager.getConnection(url, uname,pwd);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Connection Failed! Check output console :" + e.getMessage());
		}
		return connection;
	}
	
	public static void main(String[] a) throws Exception {
		JdbcConnection jcon = new JdbcConnection();
		System.out.println("connection is :"+ jcon.getConnection());
		Connection conn = jcon.getConnection();
		
		PreparedStatement pst = conn.prepareStatement("select * from users");
		
		ResultSet rs = pst.executeQuery();
		
		while (rs.next()) {	
			
			System.out.println("User id :" + rs.getInt(1));
			System.out.println("User Name :" + rs.getString(2));
		}
		rs.close();
		pst.close();
		conn.close();
	}
		

}