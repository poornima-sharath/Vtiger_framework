package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	@FindBy(xpath ="//a[text()='Products']")
	private WebElement lnkProducts;
	
	@FindBy(xpath ="//a[text()='More']")
	private WebElement lnkMore;
	
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement lnkOrg;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement lnkContacts;
	
	@FindBy(xpath = "//a[@name='Campaigns']")
	private WebElement lnkCampaings;
	
	@FindBy(xpath = "(//td[@valign='bottom'])[2]")
	private WebElement lnkAdministration;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement lnkSignOut;

	public void ClickLnkProducts() {
		this.lnkProducts.click();
	}

	public void ClickLnkMore() {
		this.lnkMore.click();
	}

	public void ClickLnkOrg() {
		this.lnkOrg.click();
	}

	public void ClickLnkContacts() {
		this.lnkContacts.click();;
	}

	public void ClickLnkCampaings() {
		this.lnkCampaings.click();;
	}
	
	public void ClickAdministartion() {
		this.lnkAdministration.click();
	}
	
	public void clickSignOut() {
		this.lnkSignOut.click();
	}
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

}
