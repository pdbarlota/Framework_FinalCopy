package com.abc.constants;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GlobalVariables {
	
	public static WebDriver driver; //local 
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static ExtentReports report;
	public static ExtentSparkReporter sparkreporter;
	public static String filepath;
	public static ExtentTest test;
	public static String destinationpath;
	public static Properties prop;
	

}
