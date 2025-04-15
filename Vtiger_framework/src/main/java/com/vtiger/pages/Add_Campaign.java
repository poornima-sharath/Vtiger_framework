package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_Campaign {
	
	@FindBy (name="campaignname")
	private WebElement tbCampaignName;
	
	@FindBy (xpath = "//img[@alt='Select']")
	private WebElement btnSelectProd;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement btnSave;
	
	public void SetCampaignName(String CampName) {
		this.tbCampaignName.sendKeys(CampName);
	}
	
	public void ClickSelectProd() {
		this.btnSelectProd.click();
	}
	
	public void clickSaveButton() {
		this.btnSave.click();
	}
	
	public Add_Campaign(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
