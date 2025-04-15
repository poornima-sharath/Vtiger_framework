package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Camp_Validation {
	
	public String Camp_Prod_Validation(WebDriver driver, String camName, String prodName) {
		/*String actProd = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
		if(prodName.equalsIgnoreCase(actProd)) {
			System.out.println("Product is added="+prodName);
		}*/
		return driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		/*if(camName.equalsIgnoreCase(actcamp)) {
			System.out.println("Campaign is added="+camName);
		}*/
	}
	
	public void Camp_Validation(WebDriver driver, String camName) {
		String actCamName = driver.findElement(By.id("mouseArea_Campaign Name")).getText();
		if(camName.equalsIgnoreCase(actCamName)) {
			System.out.println("Campaign is added");
		}
	}
	
	public Camp_Validation(WebDriver driver) { 
		PageFactory.initElements(driver, this);
	}

}
