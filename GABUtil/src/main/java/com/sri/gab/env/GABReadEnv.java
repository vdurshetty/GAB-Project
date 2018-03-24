package com.sri.gab.env;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GABReadEnv
{
    public GABReadEnv()
    {
    }

    public static Properties getEnvProperties()
    {
        return prop;
    }

    public static String getEnvValue(String key)
    {
        return prop.getProperty(key);
    }

    static Properties prop;

    static 
    {
        prop = new Properties();
        try
        {
            File f = new File(GABEnvProp.configProperties);
            if(f.exists())
                prop.load(new FileInputStream(f));
            else
            	System.out.println((new StringBuilder("Unable to locate ")).append(f.getAbsolutePath()).toString());
        }
        catch(IOException ex)
        {
        	System.out.println("Unable to fetch config properties -" + ex.getMessage());
        }
    }
}
