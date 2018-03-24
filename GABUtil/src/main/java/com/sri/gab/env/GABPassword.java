package com.sri.gab.env;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import com.sri.gab.logger.GABLogger;

public class GABPassword {
	
	static GABLogger log = GABLogger.getLogger(GABPassword.class.getName());
	
	public static Properties getAllPasswords() {
		Properties prop = new Properties();
        try
        {
			String pwdFileName = GABReadEnv.getEnvValue(GABEnvProp.PasswordFile);
			File pwdFile = new File(pwdFileName);
			if (!pwdFile.exists()){
				log.debug("Password File '" + pwdFile.getAbsolutePath() + "' not found!");
			}
            prop.load(new FileInputStream(pwdFile));
            if (!prop.containsKey(GABEnvProp.DBPwd)){
            	prop.setProperty(GABEnvProp.DBPwd , "");
            } 
            if (!prop.containsKey(GABEnvProp.EmailPwd)){
            	prop.setProperty(GABEnvProp.EmailPwd , "");
            } 
            if (!prop.containsKey(GABEnvProp.SmsPwd)){
            	prop.setProperty(GABEnvProp.SmsPwd , "");
            } 
        }
        catch(IOException ex)
        {
        	log.error("Unable to fetch passwords from password file" + ex.getMessage());
        }
		return prop;
	}
	
	public static String getPassword(String pwdType) {
		String pwd = null;
		Properties prop = new Properties();
        try
        {
			String pwdFileName = GABReadEnv.getEnvValue(GABEnvProp.PasswordFile);
			File pwdFile = new File(pwdFileName);
			if (!pwdFile.exists()){
				log.debug("Password File '" + pwdFile.getAbsolutePath() + "' not found!");
				return null;
			}
            prop.load(new FileInputStream(pwdFile));
            if (prop.containsKey(pwdType)){
            	pwd = prop.getProperty(pwdType);
            } 
        }
        catch(IOException ex)
        {
        	log.error("Unable to fetch password from password file" + ex.getMessage());
        }
		return pwd;
	}
	
	public static boolean savePasswords(Properties passwords) {
		boolean status = false;
		try{
			String pwdFileName = GABReadEnv.getEnvValue(GABEnvProp.PasswordFile);
			File pwdFile = new File(pwdFileName);
			if (!pwdFile.exists()){
				pwdFile.createNewFile();
			}
			
			String pwdLines="";
			if (passwords.containsKey(GABEnvProp.DBPwd)) {
				pwdLines = GABEnvProp.DBPwd + "=" + passwords.get(GABEnvProp.DBPwd) + "\n";
			} else {
				pwdLines = GABEnvProp.DBPwd + "="  + "\n";
			}
			if (passwords.containsKey(GABEnvProp.EmailPwd)) {
				pwdLines = pwdLines + GABEnvProp.EmailPwd + "=" + passwords.get(GABEnvProp.EmailPwd) + "\n";
			} else {
				pwdLines = pwdLines + GABEnvProp.EmailPwd + "=" + "\n";
			}
			if (passwords.containsKey(GABEnvProp.SmsPwd)) {
				pwdLines = pwdLines + GABEnvProp.SmsPwd + "=" + passwords.get(GABEnvProp.SmsPwd) + "\n";
			} else {
				pwdLines = pwdLines + GABEnvProp.SmsPwd + "=" + "\n";
			}
			writeToFile(pwdFileName,pwdLines);
		}catch(Exception e){
        	log.error("Unable to save passwords into password file" + e.getMessage());
		}
		return status;
	}
	
	private static boolean writeToFile(String fileName,String pwdLines) throws Exception{
		boolean status=false;
		FileWriter fw = new FileWriter(fileName,false);
		fw.write(pwdLines);
        fw.close();
		return status;
	}
	

}
