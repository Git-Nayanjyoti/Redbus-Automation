Feature: BusHire Airport

Scenario: Test for bus hire OutStation oneWayTrip
	Given User is on Home page 
	When User clicks on Bus hire 
	And User clicks on Airport oneWayTrip 
	Then User should be able to hire a bus successfully 
	
Scenario: Test for bus hire OutStation roundTrip 
	Given User is on Home page 
	When User clicks on Bus hire 
	And User clicks on Airport roundTrip 
	Then User should be able to hire a bus successfully 
	 