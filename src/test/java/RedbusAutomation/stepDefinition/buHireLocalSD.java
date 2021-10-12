package RedbusAutomation.stepDefinition;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.common.base;
import com.pages.BusHireAirportPage;
import com.pages.BusHireLocalPage;
import com.pages.BusHireOutstationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class buHireLocalSD extends base {
	BusHireLocalPage BhL = new BusHireLocalPage();
	BusHireOutstationPage BhO = new BusHireOutstationPage();
	BusHireAirportPage BhA = new BusHireAirportPage();

	@Given("User is on Home page for local")
	public void user_is_on_home_page_for_local() {
		initialization();
	}

	@When("User clicks on Bus hire for local")
	public void user_clicks_on_bus_hire_for_local() throws InterruptedException {
		BhO.clickBusHire();
	}

	@When("User clicks on Local")
	public void user_clicks_on_local() throws InterruptedException {
		BhL.selectLocal();
	}

	@When("User enters pickup location for local")
	public void user_enters_pickup_location_for_local() throws InterruptedException {
		BhL.enterLocationforLocal(prop.getProperty("pickup"));
	}

	@When("User selects package")
	public void user_selects_package() throws InterruptedException {
		BhL.Package(prop.getProperty("package")); 
	}

	@When("User enters start date and time for loacal")
	public void user_enters_start_date_and_time_for_loacal() throws InterruptedException, ParseException {
		BhA.dateAndTimeAirport(prop.getProperty("inputDate"), prop.getProperty("intime"));
	}

	@When("User enters passenger count for local")
	public void user_enters_passenger_count_for_local() throws InterruptedException {
		BhL.passengerCountforLocal(prop.getProperty("count"));
	}

	@Then("User should be able to click on local proceed successfully")
	public void user_should_be_able_to_click_on_local_proceed_successfully() throws InterruptedException {
		BhL.clickProceedLoacal();
		
	}

}
