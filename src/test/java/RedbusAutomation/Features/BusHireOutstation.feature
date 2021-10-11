Feature: BusHire Outstation 

@round	
Scenario: Test for bus hire OutStation roundTrip 
	Given User is on Home page 
	When User clicks on Bus hire 
	And User clicks on OutStation
	And User enters pickup location
	And User enter destination
	And User enters current date
	And User enters return date
	And User enters passenger count  
	Then User clicks on proceed and successfully hires bus 
	
#Scenario: Test for bus hire OutStation oneWayTrip
#	Given User is on Home page 
#	When User clicks on Bus hire 
#	And User clicks on OutStation
#	And User clicks on oneWayTrip
#	And User enters pickup location
#	And User enter destination
#	And User enters current date
#	And User enters return date
#	And User enters passenger count  
#	Then User clicks on proceed and successfully hires bus 