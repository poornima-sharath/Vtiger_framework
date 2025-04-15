package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_Org_popup_page {
	
	@FindBy (xpath = "//input[@name='search_text']")
	private WebElement tbSelectOrgName;
	
	@FindBy (xpath = "//input[@name='search']")
	private WebElement btnSearchBox;
	
	public void DynamicOrgPath(WebDriver driver, String orgName) {
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	}
	
	public void GetOrgName(String orgName) {
		this.tbSelectOrgName.sendKeys(orgName);
	}
	
	public void ClickSearchBox() {
		this.btnSearchBox.click();
	}
	
	public Contact_Org_popup_page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
}
