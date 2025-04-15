package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.generic.Excel_Utility;
import com.vtiger.generic.File_Utility;
import com.vtiger.generic.WebDriver_Utility;
import com.vtiger.pages.Add_Product;
import com.vtiger.pages.Create_Product_page;
import com.vtiger.pages.Home_Page;
import com.vtiger.pages.Login_Page;
import com.vtiger.pages.Product_Validation;

public class Create_Product {
	public static void main(String[] args) throws Throwable {
		
		File_Utility f = new File_Utility();
		String Browser = f.getKeyValuePair("browser");
		String Url = f.getKeyValuePair("url");
		String UserName = f.getKeyValuePair("username");
		String Password = f.getKeyValuePair("password");
		
		//FileInputStream f2 = new FileInputStream("./data/Testdata.xlsx");
		//Workbook book = WorkbookFactory.create(f2);
		//String data = book.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		
		Excel_Utility excel  = new Excel_Utility();
		String prodName = excel.getDataFromExcel("Sheet1", 1, 0);
		
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
		
		Create_Product_page productLookup = new Create_Product_page(driver);
		productLookup.ClickAddProduct();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		//driver.findElement(By.name("productname")).sendKeys(prodName);
		Add_Product addProdutLookup = new Add_Product(driver);
		addProdutLookup.SetProductName(prodName);
		//driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();
		addProdutLookup.ClickSaveButton();
		/*String actData = driver.findElement(By.xpath("//td[@id='mouseArea_Product Name']")).getText();
		if(prodName.equalsIgnoreCase(actData)) {
			System.out.println("Product name is created");
		}*/
		
		Product_Validation prodValidation = new Product_Validation(driver);
		prodValidation.Product_Validation(driver, prodName);
		//driver.findElement(By.xpath("(//td[@valign='bottom'])[2]")).click();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		HomePage.ClickAdministartion();
		HomePage.clickSignOut();
	}

}
