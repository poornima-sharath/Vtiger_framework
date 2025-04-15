package DDT;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchingdatafromPropertiesfile {
	public static void main(String[] args) throws Throwable {
		
			/* Object of fileinputstream is created */
			FileInputStream f = new FileInputStream("D:\\Selenium-Workspace\\Vtiger_framework\\data\\Commons.properties.txt");
			/* Object of property file is created */
			Properties p = new Properties();
			p.load(f);
			
			String Browser = p.getProperty("browser");
			String Url = p.getProperty("url");
			String UserName = p.getProperty("username");
			String Password = p.getProperty("password");
			
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
			driver.get(Url);
			driver.findElement(By.name("user_name")).sendKeys(UserName);
			driver.findElement(By.name("user_password")).sendKeys(Password);
			driver.findElement(By.id("submitButton")).click();
		}
}
