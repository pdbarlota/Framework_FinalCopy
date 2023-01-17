package com.abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends LoginPage {
	
	
	public HomePage(String username,String Password) {
	
		if (!getDashboard().isDisplayed()) { //
			UserLogin(username, Password);
		}
	}
	
	public WebElement getPIMLink() {
		return driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
	}

	
	public WebElement getWelcome() {
		return driver.findElement(By.tagName("h6"));
	}
	
	public WebElement getDashboard() {
		return driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
	}
	
	public WebElement getAbout() {
		return driver.findElement(By.id("aboutDisplayLink"));
		
	}
	
	public WebElement getDisplayAbout() {
		return driver.findElement(By.id("displayAbout"));
	}

	public void GetTheDisplayInformation() {
		//getWelcome().click();
		//getAbout().click();
		
	}
}
