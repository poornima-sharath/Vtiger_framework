package DDT;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ipl {
	
	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.iplt20.com/matches/points-table");
		driver.findElement(By.xpath("//button[text()='Accept cookies']")).click();
		WebElement team1 = driver.findElement(By.xpath("//h2[text()='MI']"));
		WebElement team2 = driver.findElement(By.xpath("(//h2[text()='GT'])"));
		
		WebElement t1TotalMatch = driver.findElement(By.xpath("(//h2[text()='MI']/ancestor::tr/descendant::td)[4]"));
		WebElement t1wonMatch = driver.findElement(By.xpath("(//h2[text()='MI']/ancestor::tr/descendant::td)[5]"));
		WebElement t1lostMatch = driver.findElement(By.xpath("(//h2[text()='MI']/ancestor::tr/descendant::td)[6]"));
		WebElement t1Points = driver.findElement(By.xpath("(//h2[text()='MI']/ancestor::tr/descendant::td)[11]"));
		System.out.println(t1TotalMatch.getText());
		System.out.println(t1wonMatch.getText());
		System.out.println(t1lostMatch.getText());
		System.out.println(t1Points.getText());
		WebElement t2TotalMatch = driver.findElement(By.xpath("(//h2[text()='GT']/ancestor::tr/descendant::td)[4]"));
		WebElement t2wonMatch = driver.findElement(By.xpath("(//h2[text()='GT']/ancestor::tr/descendant::td)[5]"));
		WebElement t2lostMatch = driver.findElement(By.xpath("(//h2[text()='GT']/ancestor::tr/descendant::td)[6]"));
		WebElement t2Points = driver.findElement(By.xpath("(//h2[text()='GT']/ancestor::tr/descendant::td)[11]"));
		System.out.println(t2TotalMatch.getText());
		System.out.println(t2wonMatch.getText());
		System.out.println(t2lostMatch.getText());
		System.out.println(t2Points.getText());
	
	}
	

}
