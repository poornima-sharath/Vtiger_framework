package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Contact_page {
	
	@FindBy (xpath = "//img[@title='Create Contact...']")
	private WebElement lnkContacts;
	
	
	public void ClickAddContact() {
		this.lnkContacts.click();
	}
	
	
	
	public Create_Contact_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
