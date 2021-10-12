Feature: View Seats

Scenario: Test for viewing seats
	Given User is on Home page for viewing seats
	When User enters location for viewing seats
	And User enters destination for viewing seats
	And User enters date for viewing seats
	And User clicks on search button for viewing seats
	Then User should be able to click on view seats successfully 
	