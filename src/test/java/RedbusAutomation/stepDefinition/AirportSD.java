package RedbusAutomation.stepDefinition;

import java.text.ParseException;

import com.common.base;
import com.pages.BusHireAirportPage;
import com.pages.BusHireOutstationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AirportSD extends base{
	BusHireAirportPage BhA = new BusHireAirportPage();
	BusHireOutstationPage BhO = new BusHireOutstationPage();

		@Given("User is on Home page for airport")
		public void user_is_on_home_page_for_aiport() {
		   initialization();
		}

		@When("User clicks on Bus hire for airport")
		public void user_clicks_on_bus_hire_for_airport() throws InterruptedException {
		  BhO.clickBusHire();
		}

		@When("User clicks on Airport")
		public void user_clicks_on_airport() throws InterruptedException {
		   BhA.selectAirport();
		}

		@When("User selects city")
		public void user_selects_city() throws InterruptedException {
		   BhA.selectCityAirport(prop.getProperty("city"));
		}

		@When("User enter destination for airport")
		public void user_enter_destination_for_airport() throws InterruptedException {
		   BhA.enterLocationAirport();
		}
 
		@When("User enters date and time when he wants the vehicle")
		public void user_enters_date_and_time_when_he_wants_the_vehicle() throws InterruptedException, ParseException {
		  BhA.enterDateTimeAirport(prop.getProperty("inputDate"), prop.getProperty("intime"));
		}

		@When("User enters passenger count for airport")
		public void user_enters_passenger_count_for_airport() throws InterruptedException {
		   BhA.enterPassengerCountAirport(prop.getProperty("count"));
		}

		@Then("User clicks on Airport proceed and successfully hires bus")
		public void user_clicks_on_airport_proceed_and_successfully_hires_bus() throws InterruptedException {
		   BhA.clickProceedAirport();
		}

		
		@When("User clicks on Drop to Airport")
		public void user_clicks_on_drop_to_airport() throws InterruptedException {
		    BhA.dropToAirport();
		}

		@When("User enters pickup location for aiport")
		public void user_enters_pickup_location_for_aiport() throws InterruptedException { 
		   BhA.enterPicLocationAirport(prop.getProperty("picAirport"));
		  
		}
}
