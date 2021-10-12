package com.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.common.base;

public class BusHireAirportPage extends base {
	public void dateAndTimeAirport(String date, String time) throws InterruptedException, ParseException {

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
		Date currentDate = new Date();
		String formatDate = "";
		for (int num = 0; num < months.length; num++) {
			if (months[num].equals(month)) {
				int monthInNum = num + 1;
				formatDate = day + "/" + monthInNum + "/" + year[2];
			}
		}

		Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(formatDate);
		if (inputDate.before(currentDate)) {
			// Do nothing
			System.out.println("Pre date can't be entered");
		} else {
			String MonthYear = dateArr[1].replace("-", " ");
			System.out.println(MonthYear);
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
			System.out.println(size.size());

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
			Thread.sleep(3000);
			for (int hrs = 0; hrs < hourHand.size(); hrs++) {
				if (hourHand.get(hrs).getText().equals(hour)) {
					Thread.sleep(3000);
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
			System.out.println(secondHand.size());
			Thread.sleep(3000);
			for (int min = 0; min < secondHand.size(); min++) {
				if (secondHand.get(min).getText().equals(minute)) {
					Thread.sleep(3000);
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

	public void selectAirport() throws InterruptedException {
		Thread.sleep(3000);
		WebElement frame = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/object"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[3]")).click();
		Thread.sleep(3000);

	}

	public void enterPassengerCountAirport(String count) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("numberOfPax")).sendKeys(count);
	}

	public void selectCityAirport(String city) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.className("select-selected")).click();
		List<WebElement> select = driver.findElement(By.className("select-items"))
				.findElements(By.className("select-item"));

		for (int item = 0; item < select.size(); item++) {
			if (select.get(item).getText().equals(city)) {
				select.get(item).click();
			}
		}
	}

	public void enterDateTimeAirport(String date, String time) throws InterruptedException, ParseException {
		driver.findElement(By.id("from_datepicker")).click();
		Thread.sleep(3000);
		dateAndTimeAirport(date, time);
	}

	public void clickProceedAirport() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("proceedButtonAirport")).click();
	}

	public void dropToAirport() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("to_airport")).click();
	}

	public void enterPicLocationAirport(String loc) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("locationTextFieldLocal")).sendKeys(loc);
		Thread.sleep(3000);

		List<WebElement> option1 = driver.findElement(By.xpath("/html/body/ul")).findElements(By.tagName("li"));
		for (int i = 0; i < option1.size(); i++) {
			List<WebElement> spans = option1.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText().equals(loc)) {
				spans.get(1).click();
			}
		}

	}

	public void enterLocationAirport() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("locationTextFieldLocal")).sendKeys(
				"Mumbai Xpress, Jyoti Nivas College Road, Koramangala Industrial Layout, Koramangala, Bengaluru, Karnataka, India");
		Thread.sleep(3000);
		List<WebElement> option1 = driver.findElement(By.xpath("/html/body/ul")).findElements(By.tagName("li"));
		for (int i = 0; i < option1.size(); i++) {
			List<WebElement> spans = option1.get(i).findElements(By.tagName("span"));
			if (spans.get(1).getText().equals(
					"Mumbai Xpress, Jyoti Nivas College Road, Koramangala Industrial Layout, Koramangala, Bengaluru, Karnataka, India")) {
				spans.get(1).click();
			}
		}

	}

}
