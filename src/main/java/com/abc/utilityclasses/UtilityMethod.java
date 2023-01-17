package com.abc.utilityclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.abc.constants.GlobalVariables;

public class UtilityMethod {
	
	
	public void loadProperties() {
		GlobalVariables.prop=new Properties(); //properties object has been created in method 
		try {
			GlobalVariables.prop.load(new FileInputStream("src/test/resources/config.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("Config.properties file not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
