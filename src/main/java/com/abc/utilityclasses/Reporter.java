package com.abc.utilityclasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter extends ReadExcel{

	
	@BeforeTest(alwaysRun=true)
	public static void Report() {
		Date now = new Date(); //this will give current time in date and time format
		String Timestamp = now.toString().replace(":", "-"); //it is replaceing : with -
		File file = new File("Result/"+Timestamp); //This will be folder path
		file.mkdir(); //It will create new folder
		filepath=file.getPath();
		report = new ExtentReports();
		sparkreporter=new ExtentSparkReporter(file.getPath()+"/Result.html");
		report.attachReporter(sparkreporter);
		 
	
	}

	public static void startTest(String Testcase) {
		
		test = report.createTest(Testcase);
	}
	//extentreport
	//passtest
	public static void PassTest(String teststep) {
		test.log(Status.PASS, teststep);
	}
	
	public static void InfoTest(String teststep) {
		test.log(Status.INFO, teststep);
	}
	
	
	
	@AfterMethod(alwaysRun=true)
	public static void endTest()
	{
		System.out.println(" after test");
			report.flush();
	}
	
	public static String captureScreen()  {
		//Convert web driver object to TakeScreenshot
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
         File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
          destinationpath=filepath+"/"+dateName+".png";
           File DestFile=new File(destinationpath);
          try {
        	  FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          return DestFile.getAbsolutePath();

	}
	
	public static void FailTest(String teststep) {
		try {
			test.fail(teststep, 
					MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


