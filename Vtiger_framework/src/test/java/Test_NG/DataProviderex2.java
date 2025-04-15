package Test_NG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderex2 {

	@Test(dataProvider = "SetContact")
	public void CreateContact(String Fn, String Ln) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(Fn);
		driver.findElement(By.name("lastname")).sendKeys(Ln);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
		
	}
	@DataProvider
	public Object[][] SetContact() {
		
		Object[][] obj = new Object[3][2];
		
		obj[0][0] = "Poornima";
		obj[0][1] = "S";
		
		obj[1][0] = "Sharath";
		obj[1][1] = "M";
		
		obj[2][0] = "Tarushi";
		obj[2][1] = "S";
		
		return obj;
		
	}
}
