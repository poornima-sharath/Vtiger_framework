package Test_NG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.generic.Base_Class;
import com.vtiger.generic.Excel_Utility;
import com.vtiger.generic.Java_Utility;
import com.vtiger.generic.WebDriver_Utility;
import com.vtiger.pages.Add_Campaign;
import com.vtiger.pages.Add_Product;
import com.vtiger.pages.Camp_Validation;
import com.vtiger.pages.Create_Product_page;
import com.vtiger.pages.Create_camp_page;
import com.vtiger.pages.Home_Page;
import com.vtiger.pages.SwitchingWindowPage;

@Listeners(com.vtiger.generic.ExtentReportImp.class)
public class CreateCampaignTest extends Base_Class{
	
	@Test(retryAnalyzer = com.vtiger.generic.RetryImp.class )
	public static void creatCampaignTest() throws Throwable {
	/*File_Utility f = new File_Utility();
	String Url = f.getKeyValuePair("url");
	String UserName = f.getKeyValuePair("username");
	String Password = f.getKeyValuePair("password");
	*/
	
	Java_Utility j = new Java_Utility();
	int ranNum = j.getRandomNum();
	
	Excel_Utility excel  = new Excel_Utility();
	String prodName = excel.getDataFromExcel("Sheet1", 1, 0)+ranNum;
	String camName = excel.getDataFromExcel("Sheet1", 1, 1);
	
	WebDriver_Utility wlib =  new WebDriver_Utility();
	
	/*wlib.maximize(driver);
	wlib.wait(driver);
	driver.get(Url);
	Login_Page loginPage =  new Login_Page(driver);
	loginPage.loginIntoPage(UserName, Password);*/
	
	Home_Page HomePage = new Home_Page(driver);
	HomePage.ClickLnkProducts();
	
	Create_Product_page ProdLookup = new Create_Product_page(driver);
	ProdLookup.ClickAddProduct();
	
	Add_Product addProdLookup = new Add_Product(driver);
	addProdLookup.SetProductName(prodName);
	
	addProdLookup.ClickSaveButton();
	
	HomePage.ClickLnkMore();
	
	HomePage.ClickLnkCampaings();
	Create_camp_page campLookup = new Create_camp_page(driver);
	
	campLookup.ClickAddCamp();
	
	
	Add_Campaign addCampLookup = new Add_Campaign(driver);
	addCampLookup.SetCampaignName(camName);
	addCampLookup.ClickSelectProd();
	String mainwindow = driver.getWindowHandle();
	
	wlib.windowSwitching(driver, "Products&action");
	
	SwitchingWindowPage SwitchWin = new SwitchingWindowPage(driver);
	SwitchWin.SetProductName(prodName);
	SwitchWin.clickSearch();
	SwitchWin.dynamicPath(driver, prodName);
	driver.switchTo().window(mainwindow);
	
	addCampLookup.clickSaveButton();
	Camp_Validation validation = new Camp_Validation(driver);
	String actValidate = validation.Camp_Prod_Validation(driver, camName, prodName);
	
	Assert.assertEquals(actValidate, camName);
	System.out.println("Camp name is added");
	
	/*HomePage.ClickAdministartion();
	HomePage.clickSignOut();*/
	
}

}
