package com.abc.utilityclasses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.abc.constants.GlobalVariables;

public class BrowserLaunch extends GlobalVariables{
	
	@BeforeSuite(alwaysRun=true)
	public void Launch() {
		
		UtilityMethod utility=new UtilityMethod();
		utility.loadProperties();
		if(GlobalVariables.prop.getProperty("browsername").equalsIgnoreCase("chrome")) {
		//Step 1 - register the driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		//Step 2 - Object of browser related class
		driver=new ChromeDriver();
		}else if(GlobalVariables.prop.getProperty("browsername").equalsIgnoreCase("firefox")) {
		//Step 1- register the driver
		System.setProperty("webdriver.gecko.driver", "Resources/geckodriver.exe");
		driver=new FirefoxDriver();
		} else {
			System.setProperty("webdriver.edge.driver", "Resources/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.get(GlobalVariables.prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@AfterSuite(alwaysRun=true)
	public void TearDown() {
		driver.quit();
	}

}
