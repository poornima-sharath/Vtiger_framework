package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchingWindowPage {
	
	@FindBy (xpath = "//input[@id='search_txt']")
	private WebElement tbsearchBox;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement btnSearch;
	
	public void dynamicPath(WebDriver driver, String prodName) {
		driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
	}
	
	public void SetProductName(String prodName) {
		this.tbsearchBox.sendKeys(prodName);
	}
	
	public void clickSearch() {
		this.btnSearch.click();
	}
	
	public SwitchingWindowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
 