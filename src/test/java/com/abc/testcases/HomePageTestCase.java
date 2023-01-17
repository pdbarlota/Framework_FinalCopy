package com.abc.testcases;

import org.testng.annotations.Test;

import com.abc.pages.HomePage;
import com.abc.pages.PIMPage;
import com.abc.utilityclasses.BrowserLaunch;
import com.abc.utilityclasses.ReadExcel;

public class HomePageTestCase extends ReadExcel {
	
	
	@Test(description="Verify that user should get the Company inforation ")
	public void TC3() {
		HomePage homepage=new HomePage("Admin", "admin123");
		//homepage.GetTheDisplayInformation();;
		if(homepage.getWelcome().isDisplayed()) {
			System.out.println("Test Case Pass");
			
		} else {
			System.out.println("Test Case fail");
		}
	}
	
	
	//Homepage Test cases 
	
		@Test(description="Verify that admin should be able to add new employee")
		public void TC4() {
		  //BrowserLaunch browserLaunchObj = new BrowserLaunch();
			//browserLaunchObj.launchBrowser();
			PIMPage pimpage=new PIMPage("Admin","admin123");
			if (BrowserLaunch.driver.getCurrentUrl().contains("dashboard"))
				System.out.println("Test Case is pass -user is able to login with valid credential");
			else
				System.out.println("Test Case is Fail -user is unable to login with valid credential");
			pimpage.getPIMLink().click();
			pimpage.getAddEmployeeBtn().click();
			pimpage.AddEmployee("Test", "Testing");
			
		}


}
