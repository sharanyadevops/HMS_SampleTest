package com.hms.qa.testcase;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hms.qa.base.BasePage;
import com.hms.qa.listeners.ExtentReportListener;
import com.hms.qa.listeners.TestAllureListener;
import com.hms.qa.pages.HomePage;
import com.hms.qa.pages.LoginPage;
import com.hms.qa.util.Constants;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


//import com.sun.org.glassfish.gmbal.Description;

//@Listeners(ExtentReportListener.class)
@Epic("EPIC - 101 : design a login page feature....")
@Feature("US 1005: create a login page with title, header, sign up and login method")
@Listeners(TestAllureListener.class)

public class LoginPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

	}

	@Description("verify login feature test...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 1)
	public void verifyLoginTest() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		//Assert.assertTrue(homePage.verifyLoggedAccountName());
		//Assert.assertEquals(homePage.getLoggedAccountName(), prop.getProperty("accountname"));
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

	
	
}
