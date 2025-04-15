package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.vtiger.generic.Excel_Utility;
import com.vtiger.generic.File_Utility;
import com.vtiger.generic.Java_Utility;
import com.vtiger.generic.WebDriver_Utility;
import com.vtiger.pages.Add_Campaign;
import com.vtiger.pages.Add_Product;
import com.vtiger.pages.Camp_Validation;
import com.vtiger.pages.Create_Product_page;
import com.vtiger.pages.Create_camp_page;
import com.vtiger.pages.Home_Page;
import com.vtiger.pages.Login_Page;
import com.vtiger.pages.SwitchingWindowPage;


public class Create_Campaign {
	
	public static void main(String[] args) throws Throwable {
		
		File_Utility f = new File_Utility();
		String Browser = f.getKeyValuePair("browser");
		String Url = f.getKeyValuePair("url");
		String UserName = f.getKeyValuePair("username");
		String Password = f.getKeyValuePair("password");
		
		
		Java_Utility j = new Java_Utility();
		int ranNum = j.getRandomNum();
		
		Excel_Utility excel  = new Excel_Utility();
		String prodName = excel.getDataFromExcel("Sheet1", 1, 0)+ranNum;
		String camName = excel.getDataFromExcel("Sheet1", 1, 1);
		
		
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
		HomePage.ClickLnkProducts();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		Create_Product_page ProdLookup = new Create_Product_page(driver);
		ProdLookup.ClickAddProduct();
		//driver.findElement(By.name("productname")).sendKeys(prodName);
		Add_Product addProdLookup = new Add_Product(driver);
		addProdLookup.SetProductName(prodName);
		//driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();
		addProdLookup.ClickSaveButton();
		//WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		HomePage.ClickLnkMore();
		//driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		HomePage.ClickLnkCampaings();
		Create_camp_page campLookup = new Create_camp_page(driver);
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		campLookup.ClickAddCamp();
		
		//driver.findElement(By.name("campaignname")).sendKeys(camName);
		//driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		Add_Campaign addCampLookup = new Add_Campaign(driver);
		addCampLookup.SetCampaignName(camName);
		addCampLookup.ClickSelectProd();
		String mainwindow = driver.getWindowHandle();
		
		wlib.windowSwitching(driver, "Products&action");
		
		//driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(prodName);
		//driver.findElement(By.xpath("//input[@name='search']")).click();
		//driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
		
		SwitchingWindowPage SwitchWin = new SwitchingWindowPage(driver);
		SwitchWin.SetProductName(prodName);
		SwitchWin.clickSearch();
		SwitchWin.dynamicPath(driver, prodName);
		driver.switchTo().window(mainwindow);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		addCampLookup.clickSaveButton();
		Camp_Validation validation = new Camp_Validation(driver);
		validation.Camp_Prod_Validation(driver, camName, prodName);
		/*String actProd = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
		if(data.equalsIgnoreCase(actProd)) {
			System.out.println("Product is added="+data);
		}
		String actcamp = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		if(camName.equalsIgnoreCase(actcamp)) {
			System.out.println("Campaign is added="+camName);
		}*/
		
		//driver.findElement(By.xpath("(//td[@valign='bottom'])[2]")).click();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	   HomePage.ClickAdministartion();
	   HomePage.clickSignOut();
	}
}

