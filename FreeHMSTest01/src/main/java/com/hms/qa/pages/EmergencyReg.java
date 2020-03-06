package com.hms.qa.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.hms.qa.base.BasePage;
import com.hms.qa.util.ElementUtil;

public class EmergencyReg extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	By Patient_Category = By.name("PATIENT_CAT");
	By Title = By.name("TITLE");
	By First_Name = By.name("PNT_NAME");
	By Patient_Identifier = By.name("PAT_IDENTITY");
	By PAN_ID = By.name("PAT_IDENTITY_PROOF");
	By Last_Name = By.name("LAST_NAME");
	By DOB = By.name("DOB");
	By Age = By.name("AGE");
	By Gender = By.name("SEX");
	By Blood_Group = By.name("BLOOD_GRP_CODE");
	By Address1 = By.name("ADDRESS1");
	By Phone = By.name("MOBILE_NO");
	By Pin = By.name("ZIP");
	
	By Save = By.name("submit");


	public EmergencyReg(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public void createNewEmergencyReg(String PatCategory, String T, String FN, String PatIdentifier,
			String Pan, String LN, String dob, String age, String gender, String BG,
			String address, String ph, String pin) {
		
		elementUtil.doActionsNewSelect(Patient_Category, PatCategory);
		elementUtil.doActionsNewSelect(Title, T);		
		elementUtil.doActionsSendKeys(First_Name, FN);
		elementUtil.doActionsNewSelect(Patient_Identifier, PatIdentifier);
		elementUtil.doActionsSendKeys(PAN_ID, Pan);
		elementUtil.doActionsSendKeys(Last_Name, LN);
		elementUtil.doActionsSendKeys(DOB, dob);
		elementUtil.doActionsSendKeys(Age, age);
		elementUtil.doActionsNewSelect(Gender, gender);
		elementUtil.doActionsNewSelect(Blood_Group, BG);
		elementUtil.doActionsSendKeys(Address1, address);
		elementUtil.doActionsSendKeys(Phone, ph);
		elementUtil.doActionsSendKeys(Pin, pin);
		elementUtil.doActionsClick(Save);

	}
	
}

