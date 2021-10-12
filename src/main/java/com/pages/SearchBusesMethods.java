package com.pages;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.base;
import com.sun.tools.javac.main.Option;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchBusesMethods extends base{
	
	
	@FindBy(xpath = "/html/body/section/div[2]/main/section/div/div[2]/section/div/div[1]/div/ul")
	public
	WebElement from;
	
	@FindBy(xpath = "/html/body/section/div[2]/main/section/div/div[2]/section/div/div[2]/div/ul")
	public
	WebElement to;
	
	@FindBy(id = "src")
	public
	WebElement fromInput;
	
	@FindBy(id = "dest")
	public
	WebElement toInput;
	
	@FindBy(className = "close")
	public
	WebElement firstPopup;
	
	@FindBy(xpath = "/html/body/section/div[2]/div[1]/div/div[3]/div[2]")
	public
	WebElement primoPopup;
	
	
	public SearchBusesMethods() {
		PageFactory.initElements(driver,this );
	}
	
	
	public void busTicketDropdown(String value,String location) throws InterruptedException {
//		String path
		if(location == "current") {
			fromInput.sendKeys(value);
			Thread.sleep(2000);

//			List<WebElement> option =driver.findElement(By.xpath(path)).findElements(By.tagName("li"));
			List<WebElement> option =from.findElements(By.tagName("li"));
			for (int i = 0; i < option.size(); i++) {               
				if (option.get(i).getText().equals(value)) {
					option.get(i).click();
					break;
				}
			}
		}
		
		if(location == "destination") {
			toInput.sendKeys(value);
			Thread.sleep(2000);

//			List<WebElement> option =driver.findElement(By.xpath(path)).findElements(By.tagName("li"));
			List<WebElement> option =to.findElements(By.tagName("li"));
			for (int i = 0; i < option.size(); i++) {               
				if (option.get(i).getText().equals(value)) {
					option.get(i).click();
					break;
				}
			}
		}
	}
	
	public void searchPopUps() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		firstPopup.click();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		primoPopup.click();
		
		
	}

	
	public void filterForBusSearch(String filterType,String value) throws InterruptedException {
		
		if(filterType.equals("DEPARTURE TIME")) {
			
			WebElement dt = driver.findElement(By.xpath("//ul[@class='dept-time dt-time-filter']"));
			List<WebElement> options = dt.findElements(By.tagName("li"));
			for (int i = 0; i < options.size(); i++) 
			{		
				int k =i+1;
				String text = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[2]/li["+k+"]/label[2]")).getText();
				
				if (text.contains(value))
				{
					driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[2]/li["+k+"]/label[1]")).click();
					Thread.sleep(5000);
					break;
				}
				text="";
			}
			
		}
	
		if(filterType.equals("BUS TYPES")) {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[3]")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/ul[2]")));
			WebElement dt = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[3]"));
			List<WebElement> options = dt.findElements(By.tagName("li"));
			for (int i = 0; i < options.size(); i++) 
			{		
				int k =i+1;
				String text = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[3]/li["+k+"]/label[2]")).getText();
				System.out.println(text);
				
				if (text.contains(value))
				{
					driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/ul[3]/li["+k+"]/label[1]")).click();
					Thread.sleep(5000);
					System.out.println(driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[3]/li["+k+"]/label[1]")).isSelected());	
					break;
				}
				text="";
			}
		}
		
		
		if(filterType.equals("ARRIVAL TIME")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/ul[3]")));
			WebElement dt = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[4]"));
			List<WebElement> options = dt.findElements(By.tagName("li"));
			for (int i = 0; i < options.size(); i++) 
			{		
				int k =i+1;
				String text = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[4]/li["+k+"]/label[2]")).getText();
				System.out.println(text);
				
				if (text.contains(value))
				{
					driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[4]/li["+k+"]/label[1]")).click();
					Thread.sleep(5000);
					System.out.println(driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[4]/li["+k+"]/label[1]")).isSelected());	
					break;
				}
				text="";
			}
		}
		
		if(filterType.equals("DROPPING POINT")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/ul[5]")));
			WebElement dt = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[5]"));
			List<WebElement> options = dt.findElements(By.tagName("li"));
			for (int i = 0; i < options.size(); i++) 
			{		
				int k =i+1;
				String text = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[5]/li["+k+"]/label[2]/span[1]")).getText();
				System.out.println(text);
				
				if (text.contains(value))
				{
					driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[5]/li["+k+"]/label[1]")).click();
					Thread.sleep(5000);
					System.out.println(driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[5]/li["+k+"]/label[1]")).isSelected());	
					break;
				}
				text="";
			}
		}
		if (filterType.equals("BOARDING POINT")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div[5]")));
			driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[5]/input")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[6]/div[2]/div/div/div/div/div[3]/input")).sendKeys(value);
			Thread.sleep(1000);
			List<WebElement> list = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[6]/div[2]/div/div/div/div/div[4]/ul"))
					.findElements(By.tagName("li"));
			for (int i = 1; i < list.size(); i++) {
				int k=i+1;
				String text = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[6]/div[2]/div/div/div/div/div[4]/ul/li["+k+"]/label[2]")).getText();
				if (text.contains(value)) {
					driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[6]/div[2]/div/div/div/div/div[4]/ul/li["+k+"]/label[1]")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[6]/div[2]/div/div/div/div/div[5]/div[2]")).click();
					Thread.sleep(1000);
					break;
				}
			}
		}
		
		
		if (filterType.equals("OPERATOR")) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div[8]")));
			driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[8]/input")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[9]/div[2]/div/div/div/div/div[3]/input")).sendKeys(value);
			Thread.sleep(1000);
			List<WebElement> list = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[9]/div[2]/div/div/div/div/div[4]/ul"))
					.findElements(By.tagName("li"));
			for (int i = 1; i < list.size(); i++) {
				int k=i+1;
				String text = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[9]/div[2]/div/div/div/div/div[4]/ul/li["+k+"]/label[2]")).getText();
				if (text.contains(value)) {
					driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[9]/div[2]/div/div/div/div/div[4]/ul/li["+k+"]/label[1]")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/div[9]/div[2]/div/div/div/div/div[5]/div[2]")).click();
					Thread.sleep(1000);
					break;
				}
			}
		}
		
	} 
	
	public void calendar(String value,WebDriver driver) throws InterruptedException {
		
		String date = value;
		String[] dateArr = date.split("-",2);
		String day = dateArr[0];
		String monthYear = dateArr[1].replace("-", " ");
		driver.findElement(By.id("onward_cal")).click();
		Thread.sleep(3000);
		
		while (!driver.findElement(By.className("monthTitle")).getText().equals(monthYear) ) {
			
			driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[1]/td[3]/button")).click();
			
		}	
		
		List<WebElement> dateList = driver.findElement(By.xpath("/html/body/div[5]/table/tbody")).findElements(By.tagName("tr"));
		for (int i = 3; i < dateList.size(); i++) {
			List<WebElement> options = dateList.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < options.size(); j++) {
				if (options.get(j).getText().equals(day)) {
					options.get(j).click();
				}
			}
		}
		
		
	}
}
