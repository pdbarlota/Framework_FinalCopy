package com.abc.utilityclasses;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.abc.constants.GlobalVariables;

public class Waitutility {

 public void waitforElementToDisplay(WebElement element) {
	 //WebDriverWait wait=new WebDriverWait(GlobalVariables.driver, Duration.ofSeconds(GlobalVariables.prop.getProperty("waittime"))));
	 //wait.until(ExpectedConditions.visibilityOf(element));
 }

}
