package Test_NG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.generic.Base_Class;
import com.vtiger.generic.Excel_Utility;
import com.vtiger.generic.File_Utility;
import com.vtiger.generic.Java_Utility;
import com.vtiger.generic.WebDriver_Utility;
import com.vtiger.pages.Add_org;
import com.vtiger.pages.Create_Org_page;
import com.vtiger.pages.Home_Page;
import com.vtiger.pages.Login_Page;
import com.vtiger.pages.Org_Validation;

public class CreateOrgTest extends Base_Class{
	
	@Test
	public static void CreateOrg() throws Throwable {
		/*File_Utility f = new File_Utility();
		String Browser = f.getKeyValuePair("browser");
		String Url = f.getKeyValuePair("url");
		String UserName = f.getKeyValuePair("username");
		String Password = f.getKeyValuePair("password");*/
		
		/* To avoid duplicate value */
		Java_Utility j = new Java_Utility();
		int ranNum = j.getRandomNum();
		
		
		Excel_Utility excel  = new Excel_Utility();
		String ProductName = excel.getDataFromExcel("Sheet1", 1, 0)+ranNum;
		String OrgName = excel.getDataFromExcel("Sheet1", 1, 2)+ranNum;
		String PhoneNum = excel.getDataFromExcel("Sheet1", 1, 3);
		String Email = excel.getDataFromExcel("Sheet1", 1, 4);
		
		
		
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
		HomePage.ClickLnkOrg();
		
		Create_Org_page orglookup = new Create_Org_page(driver);
		orglookup.ClickAddOrg();
		
		Add_org addOrgLookup = new Add_org(driver);
		addOrgLookup.setOrgName(OrgName);
		addOrgLookup.setPhoneNo(PhoneNum);
		addOrgLookup.setEmail(Email);
		
		
	    addOrgLookup.ClickSaveButton();
		
		Org_Validation orgvalidation = new Org_Validation(driver);
		orgvalidation.Org_Validation(driver, OrgName);
		
		
		orgvalidation.phone_email_Validation(driver, PhoneNum, Email);
		
		/*HomePage.ClickAdministartion();
		HomePage.clickSignOut();*/
	}

}
