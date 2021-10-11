package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BusHirePage extends base {
	static WebElement busHireOptions;
	@FindBy(id = "OSLeadGen_DoJStart")
	WebElement StartDate;
	
	public BusHirePage() {
		PageFactory.initElements(driver, this); 
	}

	public void dateAndTime(String date, String time) throws InterruptedException, ParseException {

		// for date
		String[] timeArr = time.split(":");
		String hour = timeArr[0];
		String minute = timeArr[1];
		System.out.println(hour);
		System.out.println(minute);
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] dateArr = date.split("-", 2);
		String day = dateArr[0];
		String[] year = date.split("-");
		String month = year[1];
		Date now = new Date();
		String formatDate = "";
		for (int num = 0; num < months.length; num++) {
			if (months[num].equals(month)) {
				int monthInNum = num + 1;
				formatDate = day + "/" + monthInNum + "/" + year[2];
			}
		}

		Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(formatDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		now = calendar.getTime();

		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);
		cal.set(Calendar.SECOND, 40);
		inputDate = cal.getTime();
		if (inputDate.before(now)) {
			// Do nothing
			System.out.println("Pre date can't be entered");
		} else {
			String MonthYear = dateArr[1].replace("-", " ");
			Thread.sleep(3000);
			while (!driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/div/p"))
					.getText().equalsIgnoreCase(MonthYear)) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/button[2]"))
						.click();
			}

			List<WebElement> size = driver
					.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div[2]/div/div[1]"))
					.findElements(By.tagName("div"));

			for (int i = 1; i < size.size(); i++) {
				for (int j = 1; j <= size.size(); j++) {
					WebElement findDate = driver.findElement(By.xpath(
							"/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div[2]/div/div[" + i + "]/div[" + j + "]"));
					if (MonthYear == "February 2021") {
						while (j != 1) {
							if (findDate.getText().equals(day)) {
								findDate.click();
								break;
							}
						}
					} else if (findDate.getText().equals(day)) {
						// System.out.println(findDate.getText());
						findDate.click();
						i = 0;
						break;
					}
				}
				if (i == 0) {
					break;
				}

			}
			// For time
			List<WebElement> hourHand = driver
					.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div/div"))
					.findElements(By.tagName("span"));
			System.out.println(hourHand.size());
			Thread.sleep(2000);
			for (int hrs = 0; hrs < hourHand.size(); hrs++) {
				if (hourHand.get(hrs).getText().equals(hour)) {
					Thread.sleep(2000);
					WebElement cor1 = hourHand.get(hrs);
					Actions clickonhour = new Actions(driver);
					clickonhour.moveToElement(cor1).click().perform();
					cor1 = null;
					break;

				}
			}
			Thread.sleep(3000);
			List<WebElement> secondHand = driver
					.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div/div"))
					.findElements(By.tagName("span"));
			Thread.sleep(2000);
			for (int min = 0; min < secondHand.size(); min++) {
				if (secondHand.get(min).getText().equals(minute)) {
					Thread.sleep(2000);
					WebElement cor2 = secondHand.get(min);
					Actions clickonhour = new Actions(driver);
					clickonhour.moveToElement(cor2).click().perform();
					cor2 = null;
					break;

				}
			}
			driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]")).click();

		}

	}

	public void clickBusHire() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("redBus Bus Hire")).click();
	}

	public void clickOutStation() throws InterruptedException {
		busHireOptions = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/object"));
		driver.switchTo().frame(busHireOptions);

		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[1]")).click();
		Thread.sleep(2000);
	}

	public void enterPickLoc(String pick) throws InterruptedException {
		driver.findElement(By.id("locationTextFieldLocal")).sendKeys(pick);
		Thread.sleep(2000);

		List<WebElement> option1 = driver.findElement(By.xpath("/html/body/ul[2]")).findElements(By.tagName("li"));
		for (int i = 0; i < option1.size(); i++) {
			List<WebElement> spans = option1.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText().equals(pick)) {
				spans.get(1).click();
			}
		}
	}

	public void enterDest(String destiny) throws InterruptedException {
		driver.findElement(By.id("local_dest_name"))
				.sendKeys(destiny);
		Thread.sleep(2000);

		List<WebElement> option2 = driver.findElement(By.xpath("/html/body/ul[3]")).findElements(By.tagName("li"));
		for (int i = 0; i < option2.size(); i++) {
			List<WebElement> spans = option2.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText()
					.equals(destiny)) {
				spans.get(1).click();
			}
		}
	}

	public void enterDateandTime(String inDate, String intime) throws InterruptedException, ParseException {
		//Thread.sleep(1000);
		StartDate.click();
		Thread.sleep(1000);
		dateAndTime(inDate, intime);
	}

	public void returnDateandTime(String returnDate, String returnTime) throws InterruptedException, ParseException {
		//Thread.sleep(1000);  
		driver.findElement(By.id("OSLeadGen_DoJEnd")).click();

		Thread.sleep(1000);
		dateAndTime(returnDate, returnTime);
	}

	public void passCount(String count) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("numberOfPax")).sendKeys(count);
	}

	public void proceed() throws InterruptedException {
		
		driver.findElement(By.id("proceedButtonOutstation")).click();
		Thread.sleep(2000);
		closeDriver();
	}

}