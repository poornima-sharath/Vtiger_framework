package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchingDatafromJson {
	
	public static void main(String[] args) throws Throwable {
		
		FileInputStream f = new FileInputStream("data\\jsondata.json");
		ObjectMapper obj = new ObjectMapper();
		JsonNode data = obj.readTree(f);
		
		String Browser = data.get("browser").asText();
		String Url = data.get("url").asText();
		String UserName = data.get("username").asText();
		String Password = data.get("password").asText();
		
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
