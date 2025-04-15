package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	
	public String getKeyValuePair(String value) throws Throwable {
		
		/*
		 Method to read the data from properties file (External Resource)
		 */
		
		FileInputStream F = new FileInputStream("./data/commons.properties.txt");
		Properties p = new Properties();
		p.load(F);
		
		String Value = p.getProperty(value);
		return Value;
		
	}

}
