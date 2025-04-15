package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_Product {
	
	@FindBy(name = "productname")
	private WebElement tbProductName;
	
	@FindBy(xpath = "(//input[@value='  Save  '])[2]")
	private WebElement btnSave;
	
	public void SetProductName(String productName) {
		this.tbProductName.sendKeys(productName);
	}
	
	public void ClickSaveButton() {
		this.btnSave.click();
	}

	
	public Add_Product(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
