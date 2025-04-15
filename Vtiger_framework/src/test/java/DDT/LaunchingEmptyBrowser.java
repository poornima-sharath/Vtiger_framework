package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Program for properties file */

public class LaunchingEmptyBrowser {
	
	public static void main(String[] args) throws Throwable {
	//	System.setProperty("webdriver.chrome.driver", "./drivers/chromedrivers.exe");
		/* Hard coding */
		//WebDriver driver = new ChromeDriver();
		/* Object of fileinputstream is created */
		FileInputStream f = new FileInputStream("D:\\Selenium-Workspace\\Vtiger_framework\\data\\Commons.properties.txt");
		/* Object of property file is created */
		Properties p = new Properties();
		p.load(f);
		
		String Browser = p.getProperty("browser");
		
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
	}
}
