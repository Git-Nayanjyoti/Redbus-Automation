package RedbusAutomation.stepDefinition;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.common.base;
import com.pages.BusHireOutstationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class busHireOutstationSD extends base {
	BusHireOutstationPage bh = new BusHireOutstationPage();

	//common among Airport, Outstation, local
	@Given("User is on Home page")
	public void user_is_on_home_page() throws Throwable {
		initialization();
	}

	@When("User clicks on Bus hire")
	public void user_clicks_on_bus_hire() throws Throwable {
		bh.clickBusHire();
	}

	@When("User clicks on OutStation")
	public void user_clicks_on_out_station() throws InterruptedException {

		bh.clickOutStation();
	}

	@When("User enters pickup location")
	public void user_enters_pickup_location() throws InterruptedException {

		bh.enterPickLoc(prop.getProperty("pickup"));
	}

	@When("User enter destination")
	public void user_enter_destination() throws InterruptedException {

		bh.enterDest(prop.getProperty("destiny")); 
	}

	@When("User enters current date")
	public void user_enters_current_date() throws InterruptedException, ParseException {
		bh.enterDateandTime(prop.getProperty("inputDate"),prop.getProperty("intime"));
	}

	@When("User enters return date")
	public void user_enters_return_date() throws ParseException, InterruptedException {

		bh.returnDateandTime(prop.getProperty("returnDate"),prop.getProperty("returnTime"));
	}

	@When("User enters passenger count")
	public void user_enters_passenger_count() throws InterruptedException {

		bh.passCount(prop.getProperty("count")); 
	}

	@Then("User clicks on proceed and successfully hires bus")
	public void user_clicks_on_proceed_and_successfully_hires_bus() throws InterruptedException {
		bh.proceed();

	}
	
	@When("User clicks on oneWayTrip")
	public void user_clicks_on_oneWayTrip() throws InterruptedException {
		bh.clicksOnewayTrip();
		
	}
	
	

	
}
