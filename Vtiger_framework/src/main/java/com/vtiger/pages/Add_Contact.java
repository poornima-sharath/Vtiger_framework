package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_Contact {
	
	@FindBy (xpath = "//select[@name='salutationtype']")
	private WebElement salutationtype;
	
	@FindBy(name="firstname")
	private WebElement tbFirstName;
	
	@FindBy (name="lastname")
	private WebElement tbLastName;
	
	@FindBy (xpath = "(//img[@title='Select'])[1]")
	private WebElement btnAddOrg;
	
	@FindBy (xpath = "//input[@title='Save [Alt+S]']")
	private WebElement btnSave;
	
	public WebElement Selectsalutationtype() {
		return salutationtype;
	}
	
	public void SetFirstName(String fn) {
		this.tbFirstName.sendKeys(fn);
	}
	
	public void SetLastName(String ln) {
		this.tbLastName.sendKeys(ln);
	}
	
	public void SelectAddOrg() {
		this.btnAddOrg.click();
	}
	
	public void ClickSaveButton() {
		this.btnSave.click();
	}
	
	public Add_Contact(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

}
