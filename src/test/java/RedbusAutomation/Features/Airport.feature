Feature: BusHire Airport


@pickupfromAirport	
Scenario: Test for bus hire Airport pickup from Airport 
	Given User is on Home page for airport
	When User clicks on Bus hire for airport
	And User clicks on Airport
	And User selects city
	And User enter destination for airport
	And User enters date and time when he wants the vehicle
	And User enters passenger count for airport
	Then User clicks on Airport proceed and successfully hires bus 
	
@droptoairport
Scenario: Test for bus hire Airport Drop to Airport
	Given User is on Home page for airport
	When User clicks on Bus hire for airport 
	And User clicks on Airport
	And User clicks on Drop to Airport
	And User selects city
	And User enters pickup location for aiport
	And User enters date and time when he wants the vehicle
	And User enters passenger count for airport 
	Then User clicks on Airport proceed and successfully hires bus 