package Test_NG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.generic.Base_Class;
import com.vtiger.generic.Excel_Utility;
import com.vtiger.generic.File_Utility;
import com.vtiger.generic.WebDriver_Utility;
import com.vtiger.pages.Add_Product;
import com.vtiger.pages.Create_Product_page;
import com.vtiger.pages.Home_Page;
import com.vtiger.pages.Login_Page;
import com.vtiger.pages.Product_Validation;

public class CreateProductTest extends Base_Class{
	
	@Test
	public static void CreateProductTest() throws Throwable {
	
		/*File_Utility f = new File_Utility();
		String Browser = f.getKeyValuePair("browser");
		String Url = f.getKeyValuePair("url");
		String UserName = f.getKeyValuePair("username");
		String Password = f.getKeyValuePair("password");*/
		
		
		Excel_Utility excel  = new Excel_Utility();
		String prodName = excel.getDataFromExcel("Sheet1", 1, 0);
		
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
		
		
		Create_Product_page productLookup = new Create_Product_page(driver);
		productLookup.ClickAddProduct();
		
		
		Add_Product addProdutLookup = new Add_Product(driver);
		addProdutLookup.SetProductName(prodName);
		
		addProdutLookup.ClickSaveButton();
		
		
		Product_Validation prodValidation = new Product_Validation(driver);
		prodValidation.Product_Validation(driver, prodName);
		
		
		/*HomePage.ClickAdministartion();
		HomePage.clickSignOut();*/
		
	}

}
