package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.generic.Excel_Utility;
import com.vtiger.generic.File_Utility;
import com.vtiger.generic.Java_Utility;
import com.vtiger.generic.WebDriver_Utility;
import com.vtiger.pages.Add_org;
import com.vtiger.pages.Create_Org_page;
import com.vtiger.pages.Home_Page;
import com.vtiger.pages.Login_Page;
import com.vtiger.pages.Org_Validation;

public class Create_Org {
	public static void main(String[] args) throws Throwable {
		
		File_Utility f = new File_Utility();
		String Browser = f.getKeyValuePair("browser");
		String Url = f.getKeyValuePair("url");
		String UserName = f.getKeyValuePair("username");
		String Password = f.getKeyValuePair("password");
		
		/* To avoid duplicate value */
		Java_Utility j = new Java_Utility();
		int ranNum = j.getRandomNum();
		
		
		Excel_Utility excel  = new Excel_Utility();
		String ProductName = excel.getDataFromExcel("Sheet1", 1, 0)+ranNum;
		String OrgName = excel.getDataFromExcel("Sheet1", 1, 2)+ranNum;
		String PhoneNum = excel.getDataFromExcel("Sheet1", 1, 3);
		String Email = excel.getDataFromExcel("Sheet1", 1, 4);
		
		
		
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
		HomePage.ClickLnkOrg();
		//driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		Create_Org_page orglookup = new Create_Org_page(driver);
		orglookup.ClickAddOrg();
		
		//driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName);
		//driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(PhoneNum);
		//driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(Email);
		
		Add_org addOrgLookup = new Add_org(driver);
		addOrgLookup.setOrgName(OrgName);
		addOrgLookup.setPhoneNo(PhoneNum);
		addOrgLookup.setEmail(Email);
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    addOrgLookup.ClickSaveButton();
		/*String actOrgname = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(OrgName.equals(actOrgname)) {
			System.out.println("Organization is added="+OrgName);
		}*/
		
		Org_Validation orgvalidation = new Org_Validation(driver);
		orgvalidation.Org_Validation(driver, OrgName);
		
		/*String actPhoneNum = driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
		if(PhoneNum.equals(actPhoneNum)) {
			System.out.println("Phone Number is added="+PhoneNum);
		}
		String actEmail = driver.findElement(By.xpath("//span[@id='dtlview_Email']")).getText();
		if(Email.equals(actEmail)) {
			System.out.println("Email is added="+Email);
		}*/
		
		orgvalidation.phone_email_Validation(driver, PhoneNum, Email);
		
		//driver.findElement(By.xpath("(//td[@valign='bottom'])[2]")).click();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		HomePage.ClickAdministartion();
		HomePage.clickSignOut();
	}

}
