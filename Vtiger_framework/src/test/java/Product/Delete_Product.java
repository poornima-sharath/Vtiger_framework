package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.generic.Excel_Utility;
import com.vtiger.generic.File_Utility;
import com.vtiger.generic.Java_Utility;
import com.vtiger.generic.WebDriver_Utility;
import com.vtiger.pages.Add_Product;
import com.vtiger.pages.Create_Product_page;
import com.vtiger.pages.Delete_Prod_Validation;
import com.vtiger.pages.Home_Page;
import com.vtiger.pages.Login_Page;

public class Delete_Product {
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
		Create_Product_page prodLookup = new Create_Product_page(driver);
		prodLookup.ClickAddProduct();
		//driver.findElement(By.name("productname")).sendKeys(prodName);
		
		Add_Product addProdLookup = new Add_Product(driver);
		addProdLookup.SetProductName(prodName);
		
		//driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();
		addProdLookup.ClickSaveButton();
		
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		HomePage.ClickLnkProducts();
		//driver.findElement(By.xpath("(//a[text()='"+prodName+"'])[2]/ancestor::tr[1]/descendant::td[1]/input[@type='checkbox']")).click();
		prodLookup.DynamicProdPath(driver, prodName);
		//driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		
		prodLookup.ClickDeleteButton();
		
		//Alert a = driver.switchTo().alert();
		//a.accept();
	    
		WebDriver_Utility JsPopup =  new WebDriver_Utility();
		JsPopup.JavaScriptPopup(driver);
		
		//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(prodName);
		//driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		/*Search box logic */
		//prodLookup.getprodName(prodName);
		//prodLookup.ClickSearchbox();
		
		boolean flag = prodLookup.FindProd(driver, prodName);
		System.out.println(flag);
	    
		
		
		/*if(driver.findElement(By.xpath("//span[contains(text(), 'No Product Found')]")) != null) {
			System.out.println("Product is deleted");
		}*/
		
		Delete_Prod_Validation deleteprodValidation = new Delete_Prod_Validation();
	    deleteprodValidation.Delete_Prod_Validation(driver,flag);
		//driver.findElement(By.xpath("(//td[@valign='bottom'])[2]")).click();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		HomePage.ClickAdministartion();
		HomePage.clickSignOut();
	}
}
