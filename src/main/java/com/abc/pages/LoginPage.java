package com.abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abc.utilityclasses.BrowserLaunch;

public class LoginPage extends BrowserLaunch{
	
	@FindBy(xpath="//form[@class='oxd-form']//div[@class='oxd-form-row']//input[@name='username']")
	@CacheLookup
	private WebElement username;
	
	@FindBy(xpath="//form[@class='oxd-form']//div[@class='oxd-form-row']//input[@name='password']")
	private WebElement password;
	
	public WebElement getusername() { //instance method /object
		username=driver.findElement(By.xpath(""));
		return username;
	}

	
	
	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return driver.findElement(By.xpath("//form[@class='oxd-form']//div[@class='oxd-form-actions orangehrm-login-action']//button"));
	}
	
	public void UserLogin(String username,String password) {
		this.getusername().sendKeys(username);
		getPassword().sendKeys(password);
		getLogin().click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
}
