package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Contact_Validation {
	
	public void Contact_Validation(WebDriver driver, String FirstName, String LastName) {
		String actFirstName = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();
		 if(FirstName.equals(actFirstName)) {
			 System.out.println("Firstname is added");
		 }
		 String actLastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		 if(LastName.equals(actLastName)) {
			 System.out.println("Lastname is added");
		 }
	}
	
	public Contact_Validation(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

}
