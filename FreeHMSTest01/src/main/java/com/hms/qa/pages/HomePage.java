package com.hms.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hms.qa.base.BasePage;
import com.hms.qa.util.ElementUtil;

public class HomePage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	// 1. Page Objects / By Locators

	By RegisterButton = By.linkText("Registration");
	By EmergencyRegButton = By.linkText("Emergency Registration");

    //2. homepage constructor
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		//elementUtil.waitForElementPresent(header);

	}
	
	public EmergencyReg goToEmergencyReg() {
		elementUtil.waitForElementPresent(RegisterButton);
		elementUtil.doClick(RegisterButton);
		elementUtil.waitForElementPresent(EmergencyRegButton);
		elementUtil.doClick(EmergencyRegButton);

		return new EmergencyReg(driver);
	}
	
}
