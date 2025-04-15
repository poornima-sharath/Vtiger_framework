package DDT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadi {
	
	public static void main(String[] args) {
		
		WebDriver	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.prokabaddi.com/standings");
		driver.findElement(By.className("close-btn")).click();
		driver.findElement(By.xpath("(//button[@aria-label='Close'])[1]")).click();
		handleprokabbadi(driver, "UP Yoddhas");
		
	}
	
	public static void handleprokabbadi(WebDriver driver, String ExpectedteamName) {
		
		WebElement TeamName = driver.findElement(By.xpath("//p[text()='"+ExpectedteamName+"']"));
		System.out.println(ExpectedteamName);
		WebElement TotalMatch = driver.findElement(By.xpath("//p[text()='"+ExpectedteamName+"']/ancestor::div/div[@class='table-data matches-play']"));
		WebElement won = driver.findElement(By.xpath("//p[text()='"+ExpectedteamName+"']/ancestor::div/div[@class='table-data matches-won']"));
		WebElement loss = driver.findElement(By.xpath("//p[text()='"+ExpectedteamName+"']/ancestor::div/div[@class='table-data matches-lost']"));
		WebElement points = driver.findElement(By.xpath("//p[text()='"+ExpectedteamName+"']/ancestor::div/div[@class='table-data points']"));
		System.out.println(TotalMatch.getText());
		System.out.println(won.getText());
		System.out.println(loss.getText());
		System.out.println(points.getText());
	}

}
