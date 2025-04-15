package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintLinks {
	public static void main(String[] args) throws Throwable {
		
	WebDriver	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://www.flipkart.com/");
	List<WebElement> totalLinks = driver.findElements(By.xpath("//a"));
	int size = totalLinks.size();
	System.out.println(size);
	
	FileInputStream f1 = new FileInputStream(".\\data\\flipkartdata.xlsx");
	Workbook book = WorkbookFactory.create(f1);
    Sheet sheet = book.getSheet("Sheet1");
   int rowNum = sheet.getLastRowNum();
    for(int i=0; i<rowNum; i++) {
    	Row row = sheet.getRow(i);
    	Cell cell = row.getCell(0);
    	 String links = cell.getStringCellValue();
    	 System.out.println(links);
    }
	
	}

}
