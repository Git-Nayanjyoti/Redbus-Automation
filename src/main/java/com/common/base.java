package com.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;

	public base() {
		prop = new Properties();
		try {
			FileInputStream data = new FileInputStream("./src/main/java/com/config/data.properties");
			//System.out.println(data);
			prop.load(data);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!!!");
		} catch (IOException e) {
			System.out.println("Unable to read the file!!!");
		}
	}
	public void datepicker(String date) throws InterruptedException, ParseException {
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		String[] dateArr = date.split("-", 2);
		String day = dateArr[0];
		String[] year = date.split("-");
		String month = year[1];
		Date currentDate = new Date();
		String formateDate = "";
		for (int num = 0; num < months.length; num++) {
			if (months[num].equals(month)) {
				int monthInNum = num + 1;
				formateDate = day + "/" + monthInNum + "/" + year[2];
			}
		}

		Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(formateDate);
		if (inputDate.before(currentDate)) {
			// Do nothing
			System.out.println("Pre date can't be entered");
		} else {
			String MonthYear = dateArr[1].replace("-", " ");
			Thread.sleep(3000);
			while (!driver.findElement(By.className("monthTitle")).getText().equalsIgnoreCase(MonthYear)) {
				driver.findElement(By.className("next")).click();
			}

			List<WebElement> size = driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[3]"))
					.findElements(By.tagName("td"));
			for (int i = 3; i <= size.size(); i++) {
				for (int j = 1; j <= size.size(); j++) {
					WebElement findDate = driver
							.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[" + i + "]/td[" + j + "]"));

					if (MonthYear == "Feb 2021") {
						while (j != 1) {
							if (findDate.getText().equals(day)) {
								findDate.click();
								break;
							}
						}
					} else if (findDate.getText().equals(day)) {
						System.out.println(findDate.getText());
						findDate.click();
						i = 0;
						break;
					}

				}
				if (i == 0) {
					break;
				}
			}
		}

	}

 
	public void initialization() {

		String browser = prop.getProperty("browser"); 
		if (browser.equals("chrome")) { 			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("safari")) {
			
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else if (browser.equals("ie")) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
 
	public void closeDriver() {
		driver.close();
	}

}
