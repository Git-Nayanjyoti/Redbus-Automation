package RedbusAutomation.stepDefinition;

import java.text.ParseException;

import com.common.base;
import com.pages.SearchBusesMethods;
import com.pages.ViewSeatsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class viewSeatsSD extends base{
	ViewSeatsPage Vs = new ViewSeatsPage();

	@Given("User is on Home page for viewing seats")
	public void user_is_on_home_page_for_viewing_seats() {
	   initialization();
	}

	@When("User enters location for viewing seats")
	public void user_enters_location_for_viewing_seats() throws InterruptedException {
		Vs.enterLocation(prop.getProperty("Location"));
	}

	@When("User enters destination for viewing seats")
	public void user_enters_destination_for_viewing_seats() throws InterruptedException {
		SearchBusesMethods dp = new SearchBusesMethods();
		dp.busTicketDropdown(prop.getProperty("Destination"),"destination");
	}

	@When("User enters date for viewing seats")
	public void user_enters_date_for_viewing_seats() throws InterruptedException, ParseException {
		Vs.enterDate(prop.getProperty("Date"));
	}

	@When("User clicks on search button for viewing seats")
	public void user_clicks_on_search_button_for_viewing_seats() throws InterruptedException {
		Vs.clickSearchBus();
	}

	@Then("User should be able to click on view seats successfully")
	public void user_should_be_able_to_click_on_view_seats_successfully() throws InterruptedException {
		Vs.viewBus();
	}
}
