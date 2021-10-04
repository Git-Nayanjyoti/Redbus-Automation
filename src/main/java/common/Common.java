package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Common {
	public static WebDriver driver;
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");	
	}
	public void CreateList(WebElement obj) {
		List<WebElement> listItem= obj.findElements(By.tagName("li"));
		for (int i=0;i<listItem.size();i++) {
			if(listItem.get(i).getText().equals("Guwahati (All Locations)")) {
				listItem.get(i).click();
			}
		}
	}

}
