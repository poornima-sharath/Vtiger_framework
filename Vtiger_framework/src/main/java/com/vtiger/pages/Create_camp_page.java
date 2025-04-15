package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_camp_page {
	
	@FindBy (xpath="//img[@title='Create Campaign...']")
	private WebElement lnkCreateCamp;

	public void ClickAddCamp() {
		this.lnkCreateCamp.click();
	}
	
	public Create_camp_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
