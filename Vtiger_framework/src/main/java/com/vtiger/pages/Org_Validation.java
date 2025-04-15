package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class Org_Validation {
	
	public void Org_Validation(WebDriver driver, String OrgName) {
		
		String actOrgname = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		/*if(OrgName.equals(actOrgname)) {
			System.out.println("Organization is added="+OrgName);
		}*/
		SoftAssert soft  = new SoftAssert();
		soft.assertEquals(actOrgname, OrgName);
		System.out.println("Org is added");
	}
	
	public void phone_email_Validation(WebDriver driver, String PhoneNum, String Email) {
		
		String actPhoneNum = driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
		if(PhoneNum.equals(actPhoneNum)) {
			System.out.println("Phone Number is added="+PhoneNum);
		}
		String actEmail = driver.findElement(By.xpath("//span[@id='dtlview_Email']")).getText();
		if(Email.equals(actEmail)) {
			System.out.println("Email is added="+Email);
		}
	}
	
	public Org_Validation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
