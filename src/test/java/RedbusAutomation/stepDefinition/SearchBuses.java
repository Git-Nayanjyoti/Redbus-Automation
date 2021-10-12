package RedbusAutomation.stepDefinition;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.base;
import com.pages.SearchBusesMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchBuses extends base{

	
	@Given("User is on Home Page")
	public void user_is_on_home_page() throws InterruptedException {
		
		initialization();

	}
	
	@When("User enters current location")
	public void user_enters_current_location() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		SearchBusesMethods dp = new SearchBusesMethods();
		dp.busTicketDropdown("Guwahati (All Locations)","current");
	}

	@When("User enters destination location")
	public void user_enters_destination_location() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		SearchBusesMethods dp = new SearchBusesMethods();
		dp.busTicketDropdown("North Lakhimpur","destination");
	}

	@When("User enters journey date")
	public void user_enters_journey_date() throws InterruptedException, ParseException {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		SearchBusesMethods dp = new SearchBusesMethods();
		String date = prop.getProperty("Date");
		datepicker(date);
		
	}

	@When("User clicks Search Buses button")
	public void user_clicks_search_buses_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		driver.findElement(By.id("search_btn")).click();
		
		
	}

	@Then("Available Buses listed")
	public void available_buses_listed() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		SearchBusesMethods dp = new SearchBusesMethods();
		dp.searchPopUps();
		WebElement results =  driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[2]"));
		Assert.assertTrue(results.isDisplayed());
		closeDriver();
		
	}
	
	@Then("All the user entered values should be displayed")
	public void all_the_user_entered_values_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		boolean src = driver.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[1]")).getCssValue("border-color").contains("rgb(210, 210, 210)");
		Assert.assertTrue(src);
		boolean dest = driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[2]")).getCssValue("border-color").contains("rgb(210, 210, 210)");
		Assert.assertTrue(dest);
		String date = prop.getProperty("date");
		
		boolean dateValue = driver.findElement(By.xpath("//*[@id=\"onward_cal\"]")).getAttribute("data-caleng").contains(date);
		
		Assert.assertTrue(dateValue);
		closeDriver();
	}
	
	 @Then("^User select (.+) and (.+)$")
	    public void user_select_and(String filter, String value) throws Throwable {
//	        throw new PendingException();
		 
		 SearchBusesMethods dp = new SearchBusesMethods();
		 dp.searchPopUps();
		 dp.filterForBusSearch(filter,value);
		 boolean filterName = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/ul/li")).getText().contains(value);
		 Assert.assertTrue(filterName);
		
		 
	    }

	
}
