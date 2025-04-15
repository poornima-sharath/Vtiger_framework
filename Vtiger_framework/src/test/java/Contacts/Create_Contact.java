package Contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.generic.Excel_Utility;
import com.vtiger.generic.File_Utility;
import com.vtiger.generic.Java_Utility;
import com.vtiger.generic.WebDriver_Utility;
import com.vtiger.pages.Add_Contact;
import com.vtiger.pages.Contact_Org_popup_page;
import com.vtiger.pages.Contact_Validation;
import com.vtiger.pages.Create_Contact_page;
import com.vtiger.pages.Home_Page;
import com.vtiger.pages.Login_Page;

public class Create_Contact {

	public static void main(String[] args) throws Throwable {
		File_Utility f = new File_Utility();
		String Browser = f.getKeyValuePair("browser");
		String Url = f.getKeyValuePair("url");
		String UserName = f.getKeyValuePair("username");
		String Password = f.getKeyValuePair("password");
		
		Java_Utility j = new Java_Utility();
		int ranNum = j.getRandomNum();
		
		Excel_Utility excel  = new Excel_Utility();
		String FirstName = excel.getDataFromExcel("Contact", 1, 0);
		String LastName = excel.getDataFromExcel("Contact", 1, 1);
		String orgName = excel.getDataFromExcel("Sheet1", 1, 2);
		
		
		WebDriver driver;
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver =  new ChromeDriver();
		}
		WebDriver_Utility wlib =  new WebDriver_Utility();
		wlib.maximize(driver);
		wlib.wait(driver);
		
		driver.get(Url);
		
		Login_Page loginPage =  new Login_Page(driver);
		loginPage.loginIntoPage(UserName, Password);
		
		//driver.findElement(By.name("user_name")).sendKeys(UserName);
		//driver.findElement(By.name("user_password")).sendKeys(Password);
		//driver.findElement(By.id("submitButton")).click();
		
		Home_Page HomePage = new Home_Page(driver);
		HomePage.ClickLnkContacts();
       // driver.findElement(By.xpath("//a[text()='Contacts']")).click();
      //  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Create_Contact_page ContLookup = new Create_Contact_page(driver);
		ContLookup.ClickAddContact();
		
		
        //WebElement dropDown = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Add_Contact addContactLookup = new Add_Contact(driver);
		
		WebElement dropDown = addContactLookup.Selectsalutationtype();
        
        wlib.select(dropDown,"Mrs.");
        
        //driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FirstName);
        //driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
        //driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
        addContactLookup.SetFirstName(FirstName);
        addContactLookup.SetLastName(LastName);
        addContactLookup.SelectAddOrg();
        
        String mainWindow = driver.getWindowHandle();
      
		wlib.windowSwitching(driver, "Accounts&action");
		
      //driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgName);
	 // driver.findElement(By.xpath("//input[@name='search']")).click();
	 // driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		Contact_Org_popup_page orgPopup = new Contact_Org_popup_page(driver);
		orgPopup.GetOrgName(orgName);
		orgPopup.ClickSearchBox();
		orgPopup.DynamicOrgPath(driver, orgName);
	  driver.switchTo().window(mainWindow);
	 // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	  addContactLookup.ClickSaveButton();
	/* String actFirstName = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();
	 if(FirstName.equals(actFirstName)) {
		 System.out.println("Firstname is added");
	 }
	 String actLastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
	 if(LastName.equals(actLastName)) {
		 System.out.println("Lastname is added");
	 }*/
	  
	  Contact_Validation contvalidation = new Contact_Validation(driver);
	  contvalidation.Contact_Validation(driver, FirstName, LastName);
	 
	  //driver.findElement(By.xpath("(//td[@valign='bottom'])[2]")).click();
	 // driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	 
	 HomePage.ClickAdministartion();
	 HomePage.clickSignOut();
	}

}
