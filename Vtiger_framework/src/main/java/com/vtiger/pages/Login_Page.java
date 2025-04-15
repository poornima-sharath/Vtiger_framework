package com.vtiger.pages;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	@FindBy (name = "user_name")
	private WebElement tbUserName;
	
	
	@FindBy(name = "user_password")
	private WebElement tbPassword;
	
	@FindBy(id="submitButton")
	private WebElement btnLogin;
	
	public void setUserName(String un) {
		this.tbUserName.sendKeys(un);
	}
	
	public void SetPassword(String Pwd) {
		this.tbPassword.sendKeys(Pwd);
	}
	
	public void ClickLogin() {
		this.btnLogin.click();
	}
	
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginIntoPage(String un, String pwd) {
		tbUserName.sendKeys(un);
		tbPassword.sendKeys(pwd);
		btnLogin.click();
	}

}
