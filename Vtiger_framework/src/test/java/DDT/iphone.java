package DDT;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iphone {
	
	public static void main(String[] args) {
		WebDriver	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.className("Pke_EE")).sendKeys("iphone");
		driver.findElement(By.className("_2iLD__")).click();
		List<WebElement> iphoneNames = driver.findElements(By.className("KzDlHZ"));
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='KzDlHZ']/ancestor::div/descendant::div[@class='Nx9bqj _4b5DiR']"));
	    
		Iterator<WebElement> itr1 = iphoneNames.iterator();
	
		Iterator<WebElement> itr2 = prices.iterator();
		
		
		while(itr1.hasNext()&&itr2.hasNext()) {
			 String name = itr1.next().getText();
			 String price = itr2.next().getText();
			 
			 int p1 = Integer.parseInt(price.substring(1).replace(",", ""));
			 if(p1>60000) {
				 System.out.println(name+"="+price);
			 }
			}
		driver.close();
	}

}
