package com.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class can be utilized for reading and writing the .properties files
 * @author Admin
 *
 */
public class PropUtil { 
	public String getValue(String filePath, String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value =null;
		Properties prop = new Properties();
		try {
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	public String[] getLocator(String key) {
		String dir = System.getProperty("user.dir")+"/src/main/resources/OR.properties";
		String locator= getValue(dir,key);
		String []parts =locator.split("##");
		return parts;
	}
}
