package com.vtiger.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Product_page {
	

	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement lnkproduct;
	
	@FindBy(xpath = "//input[@class='crmbutton small delete']")
	private WebElement btndelete;
	
	@FindBy (xpath = "//input[@name='search_text']")
	private WebElement tbSearchbox;
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement btnSearch;
	
	public void ClickAddProduct() {
		this.lnkproduct.click();
	}

	public void ClickDeleteButton() {
		this.btndelete.click();
	}
	
	public void getprodName(String prodName) {
		this.tbSearchbox.sendKeys(prodName);
	}
	
	public void ClickSearchbox(WebDriver driver) {
		this.btnSearch.click();
		
	}
	
	public void DynamicProdPath(WebDriver driver, String prodName) {
		
		while(true) {
		try {
	        driver.findElement(By.xpath("(//a[text()='"+prodName+"'])[2]/ancestor::tr[1]/descendant::td[1]/input[@type='checkbox']")).click();
	        break;
	    }catch (Throwable e) {
		    driver.findElement(By.xpath("//a[@title='Next']")).click();
	        }
		}
	}
	
	public boolean FindProd(WebDriver driver, String prodName) throws Throwable {
		Thread.sleep(30);
		driver.findElement(By.xpath("//a[@title='First']")).click();
		String totalPages = driver.findElement(By.xpath("//span[@name='Products_listViewCountContainerName']")).getText();
		int pages = Integer.parseInt(totalPages.substring(3));
		WebElement disableNext = driver.findElement(By.xpath("//img[@src='themes/images/next_disabled.gif']"));
		
		 boolean flag=false;
		WebElement nextPage = driver.findElement(By.xpath("//a[@title='Next']"));
		List<WebElement> allProdNames = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
			for(WebElement lv : allProdNames) {
				System.out.println(lv.getText());
				 if(lv.equals(prodName)) {
					 flag=true;
					break;
				 }
			 }
			if(disableNext!=null) {
			 nextPage.click();
			 Thread.sleep(30);
			 List<WebElement> allProdNames1 = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
				for(WebElement lv : allProdNames1) {
					System.out.println(lv.getText());
					 if(lv.equals(prodName)) {
						 flag=true;
						break;
					 }
				 }
			
			
			}
			 return flag;
		}
			
	
	public Create_Product_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
