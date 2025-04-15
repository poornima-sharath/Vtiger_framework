package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.vtiger.generic.WebDriver_Utility;
import com.vtiger.pages.Add_Campaign;
import com.vtiger.pages.Camp_Validation;
import com.vtiger.pages.Create_camp_page;
import com.vtiger.pages.Home_Page;
import com.vtiger.pages.Login_Page;

public class MoreLink {
	
	public static void main(String[] args) throws Throwable {
		
		FileInputStream f = new FileInputStream("./data/commons.properties.txt");
		Properties p = new Properties();
		p.load(f);
		String Browser = p.getProperty("browser");
		String Url = p.getProperty("url");
		String UserName = p.getProperty("username");
		String Password = p.getProperty("password");
		
		FileInputStream f2 = new FileInputStream("./data/Testdata.xlsx");
		Workbook book = WorkbookFactory.create(f2);
		String camName = book.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		

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
		
		Home_Page homepage = new Home_Page(driver);
		homepage.ClickLnkMore();
		//WebElement more = driver.findElement(By.xpath("//a[text()='More']"));

		//driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		homepage.ClickLnkCampaings();
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		Create_camp_page campLookup = new Create_camp_page(driver);
		campLookup.ClickAddCamp();
		
		//driver.findElement(By.name("campaignname")).sendKeys(camName);
		Add_Campaign addCampLookup = new Add_Campaign(driver);
		addCampLookup.SetCampaignName(camName);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		addCampLookup.clickSaveButton();
		/*String actCamName = driver.findElement(By.id("mouseArea_Campaign Name")).getText();
		if(camName.equalsIgnoreCase(actCamName)) {
			System.out.println("Campaign is added");
		}*/
		
		Camp_Validation campvalidation = new Camp_Validation(driver);
		campvalidation.Camp_Validation(driver, camName);
		//driver.findElement(By.xpath("(//td[@valign='bottom'])[2]")).click();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		homepage.ClickAdministartion();
		homepage.clickSignOut();
	}

}
