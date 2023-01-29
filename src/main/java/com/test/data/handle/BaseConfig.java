package com.test.data.handle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class BaseConfig {
	static FileInputStream fs;
	
	public static String getConfig(String value) {
		String path ="./config.properties";
		//read = FileInputStream ==> data convert into byte code
		try {
			fs= new FileInputStream(path);//file not found exception
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// read actual note pad data with java = class knowns as Properties class
		Properties pro = new Properties();
		try {
			pro.load(fs);// IO exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//read single config data
		String configName =pro.get(value).toString();
		
		
		return 	configName;
	}
public static void main(String[] args) {
	String value =BaseConfig.getConfig("POST_URL");
	System.out.println(value);
	
}
	
}
