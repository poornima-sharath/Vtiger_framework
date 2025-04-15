package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_org {
	
	@FindBy (name="accountname")
	private WebElement tbOrgName;

	@FindBy(id="phone")
	private WebElement tbPhoneNumber;
	
	@FindBy(id="email1")
	private WebElement tbEmail;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement btnSave;
	
	public void setOrgName(String orgName) {
		this.tbOrgName.sendKeys(orgName);
	}
	
	public void setPhoneNo(String phoneNum) {
		this.tbPhoneNumber.sendKeys(phoneNum);
	}
	
	public void setEmail(String email) {
		this.tbEmail.sendKeys(email);
	}
	
	public void ClickSaveButton() {
		this.btnSave.click();
	}
	
	public Add_org(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
