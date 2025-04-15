package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Product_Validation {
	
	public 	void Product_Validation(WebDriver driver, String prodName) {
		
		String actProd = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		/*if(prodName.equalsIgnoreCase(actData)) {
			System.out.println("Product name is created");
		}*/
		Assert.assertEquals(actProd, prodName);
		System.out.println("Prod is created");
	}
	
	public Product_Validation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
