package com.hms.qa.testcase;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.hms.qa.base.BasePage;
import com.hms.qa.listeners.ExtentReportListener;
import com.hms.qa.listeners.TestAllureListener;
import com.hms.qa.pages.HomePage;
import com.hms.qa.pages.LoginPage;
import com.hms.qa.util.Constants;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	SoftAssert softAssert;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		softAssert = new SoftAssert();
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
}
