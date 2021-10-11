package RedbusAutomation.stepDefinition;



import java.text.ParseException;

import com.common.base;
import com.pages.SearchBusesPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


class searchBusSD extends base{
	SearchBusesPage sb = new SearchBusesPage(); 

	 
	@Given("User is on homepage")
	public void user_is_on_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		initialization();
	   
	}

	@When("User enters from loaction")
	public void user_enters_from_loaction() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		String loc = prop.getProperty("Location");
		sb.sendkeyFrom(loc);
	   
	}

	@When("User enters destination")
	public void user_enters_destination() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	 
		String dest = prop.getProperty("Destination");
		sb.sendkeyTo(dest);
	}

	@When("User enters Date")
	public void user_enters_date() throws InterruptedException, ParseException {
		String date = prop.getProperty("Date");
		datepicker(date);
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("User clicks on the search button")
	public void user_clicks_on_the_search_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    sb.SearchButton();
	}

	@Then("User should be able to view buses")
	public void user_should_be_able_to_view_buses() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    sb.closePopUp();
	    closeDriver();
	}

	
}