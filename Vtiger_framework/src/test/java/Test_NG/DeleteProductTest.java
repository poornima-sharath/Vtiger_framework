package Test_NG;

import org.openqa.selenium.By;
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
import com.vtiger.pages.Add_Product;
import com.vtiger.pages.Create_Product_page;
import com.vtiger.pages.Delete_Prod_Validation;
import com.vtiger.pages.Home_Page;
import com.vtiger.pages.Login_Page;

public class DeleteProductTest extends Base_Class{
	
	@Test
	
	public static void DeleteProductTest() throws Throwable {
		
		/*File_Utility f = new File_Utility();
		String Browser = f.getKeyValuePair("browser");
		String Url = f.getKeyValuePair("url");
		String UserName = f.getKeyValuePair("username");
		String Password = f.getKeyValuePair("password");*/
		
		Java_Utility j = new Java_Utility();
		int ranNum = j.getRandomNum();
		
		Excel_Utility excel  = new Excel_Utility();
		String prodName = excel.getDataFromExcel("Sheet1", 1, 0)+ranNum;
		
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
		HomePage.ClickLnkProducts();
		
		Create_Product_page prodLookup = new Create_Product_page(driver);
		prodLookup.ClickAddProduct();
		
		
		Add_Product addProdLookup = new Add_Product(driver);
		addProdLookup.SetProductName(prodName);
		
		addProdLookup.ClickSaveButton();
		
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		
		HomePage.ClickLnkProducts();
		
		prodLookup.DynamicProdPath(driver, prodName);
		
		prodLookup.ClickDeleteButton();
		
		
		WebDriver_Utility JsPopup =  new WebDriver_Utility();
		JsPopup.JavaScriptPopup(driver);
		
		boolean flag = prodLookup.FindProd(driver, prodName);
		System.out.println(flag);
	    
	
		Delete_Prod_Validation deleteprodValidation = new Delete_Prod_Validation();
	    deleteprodValidation.Delete_Prod_Validation(driver,flag);
		
		/*HomePage.ClickAdministartion();
		HomePage.clickSignOut();*/
	}

}
