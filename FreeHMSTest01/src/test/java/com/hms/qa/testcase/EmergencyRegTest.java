package com.hms.qa.testcase;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.qa.base.BasePage;
import com.hms.qa.pages.EmergencyReg;
import com.hms.qa.pages.HomePage;
import com.hms.qa.pages.LoginPage;
import com.hms.qa.util.Constants;
import com.hms.qa.util.ExcelUtil;


public class EmergencyRegTest {
	WebDriver driver;
  	BasePage basePage;
  	Properties prop;
  	LoginPage loginPage;
  	HomePage homePage;
  	EmergencyReg emergencyReg;
	
 	@BeforeMethod
  	public void setUp() {
  		basePage = new BasePage();
  		prop = basePage.init_properties();
  		driver = basePage.init_driver(prop);
  		loginPage = new LoginPage(driver);
  		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
  		emergencyReg = homePage.goToEmergencyReg();
  	}
	
	
	@DataProvider
  	public Object[][] getContactsTestData() {
  		Object data[][] = ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME.trim());
  		return data;
  	}

  	@Test(dataProvider = "getContactsTestData")
  	public void createNewEmergencyRegTest(String PatCategory, String T, String FN, String PatIdentifier,
			String Pan, String LN, String dob, String age, String gender, String BG,
			String address, String ph, String pin) {
  	EmergencyReg.createNewEmergency(PatCategory, T, FN, PatIdentifier, Pan, LN, dob, age, gender, BG, address, ph, pin);
		/*
		 * EmergencyReg.createNewEmergency(PatCategory, T, FN, PatIdentifier, Pan, LN,
		 * dob, age, gender, BG, address, ph, pin);
		 */

  	}

  	@AfterMethod
  	public void quitBrowser() {
  		driver.quit();
  	}
}
