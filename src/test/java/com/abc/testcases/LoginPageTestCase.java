package com.abc.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.abc.pages.LoginPage;
import com.abc.utilityclasses.Reporter;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class LoginPageTestCase extends Reporter {
	
	@Test(description="Verify that user should not be able to login with invalid credential",groups= {"smoke"},priority=1)
	public void TC1() throws IOException {
		//Test Case Description --->CreateTest
		startTest("Verify that user should not be able to login with invalid credential");
		//testcase=report.createTest("Verify that user should not be able to login with invalid credential").assignCategory("smoke");
		LoginPage loginpage=new LoginPage();
		//loginpage.UserLogin(ReadExcel.getStringCellData(this.getClass().getEnclosingMethod().getName(),"username"),ReadExcel.getStringCellData(this.getClass().getEnclosingMethod().getName(),"password"));
		loginpage.UserLogin("admin1","admin");
		InfoTest("Enter the username");
		InfoTest("Enter the password");
		InfoTest("click on the login button");
		/*testcase.log(Status.INFO, "Enter the username");
		testcase.log(Status.INFO, "enter the password");
		testcase.log(Status.INFO, "click on login button");
		*/
		// Expected Result --> User should be able login/ navigate to home page
		if (!driver.getCurrentUrl().contains("dashboard")) {
			PassTest("User is unable to login with invalid credential");
		
		} else {
			FailTest("User is able to login with invalid credential");
			//testcase.fail("User is able to login with invalid credential", 
		      //  			MediaEntityBuilder.createScreenCaptureFromPath(Reporter.captureScreen()).build());
			
		
		}
			//report.flush();
	}
	
		//flush 
	@Test(description="verify that user should be able to login with valid credentail",groups= {"smoke","sanity","regression"},priority=2)
	public void TC0() throws IOException {
		startTest("Verify that user should not be able to login with invalid credential");
		//testcase=report.createTest("verify that user should be able to login with valid credentail").assignCategory("smoke").assignCategory("sanity").assignCategory("regression");
		LoginPage loginpage=new LoginPage();
		//loginpage.UserLogin(ReadExcel.getStringCellData(this.getClass().getEnclosingMethod().getName(),"UserName"),ReadExcel.getStringCellData(this.getClass().getEnclosingMethod().getName(),"Password"));
		loginpage.UserLogin("Admin","admin123");
		/*testcase.log(Status.INFO, "Enter the username");
		testcase.log(Status.INFO, "enter the password");
		testcase.log(Status.INFO, "click on login button");*/
		InfoTest("Enter the username");
		InfoTest("Enter the password");
		InfoTest("click on the login button");
		if (driver.getCurrentUrl().contains("dashboard")) {
			PassTest("User is successfully login to home page");
			//testcase.log(Status.PASS, "User is successfully login to home page");
			//System.out.println("Test Case Pass -User is successfully login to home page");
		} else {
			//testcase.log(Status.FAIL, "User is unable login to home page");
			FailTest("User is unable login to home page");
			System.out.println("Test Case Fail -User is unable to login to home page");
		}
		//report.flush();
	}



}
