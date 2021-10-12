Feature: Search Buses
Scenario:
	Given User is on Home Page
	When User enters current location
	And User enters destination location
	And User enters journey date
	And User clicks Search Buses button
	Then Available Buses listed  
	
Scenario:
	Given User is on Home Page
	When User enters current location
	And User enters destination location
	And User enters journey date
	Then All the user entered values should be displayed

@run
Scenario Outline:
	Given User is on Home Page
	When User enters current location
	And User enters destination location
	And User enters journey date
	And User clicks Search Buses button
	Then User select <Filter> and <value>
	Examples:
	|Filter|value|
	|DEPARTURE TIME|After 6 pm|
	|BUS TYPES|SEATER|
	|ARRIVAL TIME|Before 6 am|
	|BOARDING POINT|Game Village|
	|DROPPING POINT|North Lakhimpur|
	|OPERATOR|Blue Hill Travels|