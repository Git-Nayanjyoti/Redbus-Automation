package RedbusAutomation.testCases;

//import java.util.List;
import common.Common;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcases extends Common {
	@Given("^User is on Home page$")
	public void user_is_on_home_page() {
		initialization();
	}

	@When("^User enters (.+) and (.+)$")
	public void user_enters_and_and(String from, String to) throws InterruptedException {
		// Finding from which city the user want to travel and entering it.
		driver.findElement(By.id("src")).sendKeys(from);
		Thread.sleep(3000);
		WebElement fromCity = driver
				.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[1]/div/ul"));
		CreateList(fromCity);

		// Finding location to which the user want to go and entering it.
		driver.findElement(By.id("dest")).sendKeys(to);
		Thread.sleep(3000);
		WebElement toCity = driver
				.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[2]/div/ul"));
		CreateList(toCity);

		// selecting the date.
		driver.findElement(By.id("onward_cal")).click();
		WebElement selectDate = driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[4]/td[4]"));
		selectDate.click();

	}

	@And("user clicks on Search Buses Button")
	public void user_clicks_on_search_buses_button() {
		WebElement searchButton = driver.findElement(By.id("search_btn"));
		searchButton.click();

	}

	@Then("User should be able to find successfully and buses should be displayed")
	public void user_should_be_able_to_find_successfully_and_buses_should_be_displayed() throws Throwable {
		driver.findElement(By.id("page_main_header"));
		driver.quit();
	}

}
