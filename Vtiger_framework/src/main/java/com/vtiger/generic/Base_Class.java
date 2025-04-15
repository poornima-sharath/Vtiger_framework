package com.vtiger.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.pages.Home_Page;
import com.vtiger.pages.Login_Page;

public class Base_Class {
	
	public static WebDriver driver;
	public static WebDriver sdriver;
	Home_Page HomePage = new Home_Page(driver);
	
	
	@BeforeSuite(groups = {"SmokeTest","RegressionTest", "SanityTest" })
	public void BeforeSuite() {
		System.out.println("Database Connection");
	}

	@BeforeTest(groups = {"SmokeTest","RegressionTest", "SanityTest" })
	public void BeforeTest() {
		System.out.println("Parallel Execution");
	}
	//pullone
	//@Parameters("Browser")
	@BeforeClass(groups = {"SmokeTest","RegressionTest", "SanityTest" })
	
	public void BeforeClass() throws Throwable {
		
		File_Utility f = new File_Utility();
		//String Browser = f.getKeyValuePair("browser");
		//cmd prompt
		String Browser = System.getProperty("browser");
		System.out.println("Launching Browser");
		
		
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver =  new ChromeDriver();
		}
		
		sdriver = driver;
	}
	//@Parameters({"url", "username", "password"})
	@BeforeMethod(groups = {"SmokeTest","RegressionTest", "SanityTest" })
	public void BeforeMethod() throws Throwable {
		File_Utility f = new File_Utility();
		String Url = f.getKeyValuePair("url");
		String UserName = f.getKeyValuePair("username");
		String Password = f.getKeyValuePair("password");
		

		WebDriver_Utility wlib =  new WebDriver_Utility();
		
		wlib.maximize(driver);
		wlib.wait(driver);
		driver.get(Url);
		
		Login_Page loginPage =  new Login_Page(driver);
		loginPage.loginIntoPage(UserName, Password);
	}
	
	@AfterMethod(groups = {"SmokeTest","RegressionTest", "SanityTest" })
	public void AfterMethod() {
		Home_Page homepage = new Home_Page(driver);
		homepage.ClickAdministartion();
		homepage.clickSignOut();
	}
	
	@AfterClass(groups = {"SmokeTest","RegressionTest", "SanityTest" })
	public void AfterClass() {
		driver.close();
	}
	
	@AfterTest(groups = {"SmokeTest","RegressionTest", "SanityTest" })
	public void AfterTest() {
		System.out.println("Closing Parallel Execution");
	}
	
	@AfterSuite(groups = {"SmokeTest","RegressionTest", "SanityTest" })
	public void AfterSuite() {
		System.out.println("Close the database Connection");
	}
}
