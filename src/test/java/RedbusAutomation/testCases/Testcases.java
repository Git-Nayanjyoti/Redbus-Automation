package RedbusAutomation.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcases {
	WebDriver driver;
	@Given("^User is on Home page$")
	public void user_is_on_home_page() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		//throw new PendingException();
	}

	@When("^User enters (.+) and (.+)$")
	public void user_enters_and_and(String from, String to) throws Throwable {
		driver.findElement(By.id("src")).sendKeys(from);
		//driver.findElement(By.xpath("//section[@id=\"search\"]/div/div[1]/div/ul")).click();
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("dest")).sendKeys(to);
		//driver.findElement(By.xpath("//section[@id=\"search\"]/div/div[2]/div/ul")).click();
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("onward_cal")).click();
		driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).click();
		//throw new PendingException();
	}
	
	@And("^user clicks on Search Buses Button $")
	public void user_clicks_on_search_buses_button() throws Throwable {
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(2000);
		//throw new PendingException();
	}


	@Then("^User should be able to find successfully and buses should be displayed $")
	public void user_should_be_able_to_find_successfully_and_buses_should_be_displayed() throws Throwable {
		//throw new PendingException();
		driver.findElement(By.id("page_main_header"));
		driver.quit();
	}

	
}
