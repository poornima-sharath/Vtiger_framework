package com.vtiger.generic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
	
	/* Method to maximize the window */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/* Method to define implicitly wait */
	public void wait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	/* Method to Switch window */
	public void windowSwitching(WebDriver driver, String Partial_Title) {
		
		Set<String> allWindows = driver.getWindowHandles();
	       
	       Iterator<String> itr = allWindows.iterator();
	       
	      while(itr.hasNext()) {
	    	  String Window = itr.next();
	    	  driver.switchTo().window(Window);
			String title = driver.getTitle();
			if(title.contains(Partial_Title)) {
				break;
			}
	      }
	}
	/* Method to select data from drop down */
	public void select(WebElement element, String value) {
		
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void JavaScriptPopup(WebDriver driver) {
		
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	
	public static String TakeScreenShotEx(WebDriver driver, String screenShotName) throws Throwable {
		
		TakesScreenshot takescreenShot = (TakesScreenshot)driver;
		File src = takescreenShot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenShotName+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}

}
