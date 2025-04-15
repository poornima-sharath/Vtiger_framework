package Test_NG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.generic.Base_Class;
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

public class CreateContactTest extends Base_Class{
	
	@Test(groups = "RegressionTest")
	public static void CreatContactTest() throws Throwable {
		/*File_Utility f = new File_Utility();
		String Browser = f.getKeyValuePair("browser");
		String Url = f.getKeyValuePair("url");
		String UserName = f.getKeyValuePair("username");
		String Password = f.getKeyValuePair("password");*/
		
		Java_Utility j = new Java_Utility();
		int ranNum = j.getRandomNum();
		
		Excel_Utility excel  = new Excel_Utility();
		String FirstName = excel.getDataFromExcel("Contact", 1, 0);
		String LastName = excel.getDataFromExcel("Contact", 1, 1);
		String orgName = excel.getDataFromExcel("Sheet1", 1, 2);
		
		
		/*WebDriver driver;
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver =  new ChromeDriver();
		}*/
		WebDriver_Utility wlib =  new WebDriver_Utility();
		/*wlib.maximize(driver);
		wlib.wait(driver);
		
		driver.get(Url);
		
		Login_Page loginPage =  new Login_Page(driver);
		loginPage.loginIntoPage(UserName, Password);*/
		
		Home_Page HomePage = new Home_Page(driver);
		HomePage.ClickLnkContacts();
		
		Create_Contact_page ContLookup = new Create_Contact_page(driver);
		ContLookup.ClickAddContact();
		
		Add_Contact addContactLookup = new Add_Contact(driver);
		
		WebElement dropDown = addContactLookup.Selectsalutationtype();
        
        wlib.select(dropDown,"Mrs.");
        
        addContactLookup.SetFirstName(FirstName);
        addContactLookup.SetLastName(LastName);
        addContactLookup.SelectAddOrg();
        
        String mainWindow = driver.getWindowHandle();
      
		wlib.windowSwitching(driver, "Accounts&action");
		
		Contact_Org_popup_page orgPopup = new Contact_Org_popup_page(driver);
		orgPopup.GetOrgName(orgName);
		orgPopup.ClickSearchBox();
		orgPopup.DynamicOrgPath(driver, orgName);
	    driver.switchTo().window(mainWindow);
	 
	  addContactLookup.ClickSaveButton();
	
	  
	  Contact_Validation contvalidation = new Contact_Validation(driver);
	  contvalidation.Contact_Validation(driver, FirstName, LastName);
	 
	 /*HomePage.ClickAdministartion();
	 HomePage.clickSignOut();*/
	}

}
