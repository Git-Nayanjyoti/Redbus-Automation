Feature: Search Bus Functionality 

@search
Scenario: Search Bus from home page 
	Given User is on homepage 
	When User enters from loaction 
	And User enters destination 
	And User enters Date 
	And User clicks on the search button 
	Then User should be able to view buses