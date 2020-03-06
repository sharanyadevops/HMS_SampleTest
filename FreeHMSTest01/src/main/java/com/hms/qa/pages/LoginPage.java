package com.hms.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hms.qa.base.BasePage;
import com.hms.qa.util.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	// 1. Page Objects / By Locators
 
	By Username = By.name("username");
	By Password = By.name("password");
	By Login = By.name("submit");

	
	// 2. page class constructor:
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			elementUtil = new ElementUtil(driver);
		}
		
		@Step("login with {0} and {1}")
		public HomePage doLogin(String username, String pwd) {
			elementUtil.doSendKeys(Username, username);
			elementUtil.doSendKeys(Password, pwd);
			elementUtil.doClick(Login);
			
			return new HomePage(driver);

		}	
	
	

}
