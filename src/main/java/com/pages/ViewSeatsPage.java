package com.pages;

import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.common.base;

public class ViewSeatsPage extends base{
	public void enterLocation(String loc) throws InterruptedException {
		driver.findElement(By.id("src")).sendKeys(loc);
		Thread.sleep(2000);
		List<WebElement> searchOptionsFrom = driver
				.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[1]/div/ul"))
				.findElements(By.tagName("li"));

		for (int i = 0; i < searchOptionsFrom.size(); i++) {
			if (searchOptionsFrom.get(i).getText().equals(loc)) {
				searchOptionsFrom.get(i).click();
			}
		}

	}
	public void enterDestination(String dest) throws InterruptedException {
		driver.findElement(By.id("dest")).sendKeys(dest);
		Thread.sleep(2000);
		List<WebElement> searchOptionsTo = driver
				.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[2]/div/ul"))
				.findElements(By.tagName("li"));

		Thread.sleep(3000);
		for (int i = 0; i < searchOptionsTo.size(); i++) {
			if (searchOptionsTo.get(i).getText().equals(dest)) {
				searchOptionsTo.get(i).click();
			} 
		}
	}
	
	public void clickdatefield() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("onward_cal")).click();
	}
	public void enterDate(String date) throws InterruptedException, ParseException {
		Thread.sleep(2000);
		datepicker(date);
		
	}

	public void clickSearchBus() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("search_btn")).click();
	}
	
	public void viewBus() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[3]/div[1]/i")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[3]/div[2]/i")).click();

		Thread.sleep(6000);
		for (int i = 0; i < 5; i++) {
			try {
				driver.findElement(By.xpath(
						"/html/body/section/div[2]/div[1]/div/div[2]/div[2]/div[3]/div/ul/div[2]/li/div/div[2]/div[1]"))
						.click();
			} catch (NoSuchElementException e) {
				// TODO: handle exception
			}
		}
		Thread.sleep(4000);
		try {
			Thread.sleep(3000);

			driver.findElement(By.xpath("//i[@class='icon-close closepopupbtn']")).click();
			Thread.sleep(3000);

		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		driver.switchTo().defaultContent();
		closeDriver();
	}
}
