package com.vtiger.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vtiger.generic.WebDriver_Utility;

public class Delete_Prod_Validation {
	
	public void Delete_Prod_Validation(WebDriver driver, boolean flag) {
		
        if(flag==true) {
			System.out.println("Product is not deleted");
		}if(flag==false){
			System.out.println("Product is deleted");
		}

	}
	
	public void Delete_Prod(WebDriver driver) {
		
		if(driver.findElement(By.xpath("//span[contains(text(), 'No Product Found')]")) != null) {
	    	  System.out.println("Product is deleted");
	      }
	}

}
