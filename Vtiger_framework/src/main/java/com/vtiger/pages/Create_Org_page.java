package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Org_page {
	
	@FindBy(xpath ="//img[@title='Create Organization...']")
	private WebElement lnkOrg;
	
	public void ClickAddOrg() {
		this.lnkOrg.click();
	}
	
	public Create_Org_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
