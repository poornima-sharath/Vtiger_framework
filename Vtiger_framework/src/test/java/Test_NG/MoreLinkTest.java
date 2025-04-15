package Test_NG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.generic.Base_Class;
import com.vtiger.generic.WebDriver_Utility;
import com.vtiger.pages.Add_Campaign;
import com.vtiger.pages.Camp_Validation;
import com.vtiger.pages.Create_camp_page;
import com.vtiger.pages.Home_Page;
import com.vtiger.pages.Login_Page;

public class MoreLinkTest extends Base_Class{
	
	@Test
	
	public void MoreLinkTest() throws Throwable {
		/*FileInputStream f = new FileInputStream("./data/commons.properties.txt");
		Properties p = new Properties();
		p.load(f);
		String Url = p.getProperty("url");
		String UserName = p.getProperty("username");
		String Password = p.getProperty("password");*/
		
		FileInputStream f2 = new FileInputStream("./data/Testdata.xlsx");
		Workbook book = WorkbookFactory.create(f2);
		String camName = book.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		
		WebDriver_Utility wlib =  new WebDriver_Utility();
		/*wlib.maximize(driver);
		wlib.wait(driver);
		
		driver.get(Url);
		Login_Page loginPage =  new Login_Page(driver);
		loginPage.loginIntoPage(UserName, Password);
		*/
		
		Home_Page homepage = new Home_Page(driver);
		homepage.ClickLnkMore();
		

		
		homepage.ClickLnkCampaings();
		
		Create_camp_page campLookup = new Create_camp_page(driver);
		campLookup.ClickAddCamp();
		
		
		Add_Campaign addCampLookup = new Add_Campaign(driver);
		addCampLookup.SetCampaignName(camName);
		
		
		addCampLookup.clickSaveButton();
		
		Camp_Validation campvalidation = new Camp_Validation(driver);
		campvalidation.Camp_Validation(driver, camName);
		
		/*homepage.ClickAdministartion();
		homepage.clickSignOut();*/
	}

}
