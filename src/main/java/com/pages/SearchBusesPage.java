package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.base;


public class SearchBusesPage extends base {
	@FindBy(id = "src")
	WebElement location;

	@FindBy(id = "dest")
	WebElement destination;

	@FindBy(id = "onward_cal")
	WebElement dateField;

	@FindBy(id = "search_btn")
	WebElement searchbtn;

	@FindBy(xpath = "/html/body/section/div[2]/div[1]/div/div[3]/div[1]/i")
	WebElement closePopUp;

	public SearchBusesPage() {
		PageFactory.initElements(driver, this);
	}

	public void sendkeyFrom(String from) throws InterruptedException {
		location.sendKeys(from);
		Thread.sleep(2000);
		List<WebElement> searchOptionsFrom = driver
				.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[1]/div/ul"))
				.findElements(By.tagName("li"));

		for (int i = 0; i < searchOptionsFrom.size(); i++) {
			if (searchOptionsFrom.get(i).getText().equals(from)) {
				searchOptionsFrom.get(i).click();
			}
		}
	}
 
	public void sendkeyTo(String to) throws InterruptedException {


		destination.sendKeys(to);
		Thread.sleep(2000);
		List<WebElement> searchOptionsTo = driver
				.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[2]/div/ul"))
				.findElements(By.tagName("li"));

		for (int i = 0; i < searchOptionsTo.size(); i++) {
			if (searchOptionsTo.get(i).getText().equals(to)) {
				searchOptionsTo.get(i).click();
			}
		}

	}

	
	public void clickdateField() throws InterruptedException {
		Thread.sleep(2000);
		dateField.click();
	}

	public void SearchButton() throws InterruptedException {
		Thread.sleep(1000);
		searchbtn.click();
	}

	public void closePopUp() throws InterruptedException {
		Thread.sleep(5000);
		closePopUp.click();

		Thread.sleep(4000);
		closePopUp.click();

	}

}
