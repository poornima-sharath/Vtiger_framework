package DDT;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class bigBasket {
	
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Apples");
		List<WebElement> list = driver.findElements(By.xpath("//span[contains(text(),'Apple')]"));
		Thread.sleep(30);
		Iterator<WebElement> itr = list.iterator();
		/*while(itr.hasNext()) {
			 WebElement listofApples = itr.next();
			 String a = listofApples.getText();
			 if(a.equalsIgnoreCase("Apple - Pink Lady")) {
				 listofApples.click();
				 break;
				 }
			 }*/
		for(WebElement lv : list) {
			Thread.sleep(30);
			String a = lv.getText();
			if(a.equalsIgnoreCase("Apple - Pink Lady")) {
			lv.click();
			break;
		   }
		}
		String price = driver.findElement(By.xpath("//div[contains(@class,'flex justify-start w-full h-full')]")).getText();
		System.out.println(price);
		}

}
