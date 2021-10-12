Feature: BusHire Local

@local
Scenario: Test for bus hire Local
	Given User is on Home page for local
	When User clicks on Bus hire for local
	And User clicks on Local
	And User enters pickup location for local
	And User selects package
	And User enters start date and time for loacal
	And User enters passenger count for local
	Then User should be able to click on local proceed successfully 
	