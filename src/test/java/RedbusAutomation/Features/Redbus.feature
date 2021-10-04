Feature: Automation of Redbus 


	
@TC_SEARCH_006
Scenario Outline: Test for bus searching functionality
	Given User is on Home page
	When User enters <from> and <to>
	And user clicks on Search Buses Button 
	Then User should be able to find successfully and buses should be displayed 
	Examples: 
		|from|to|
		|Guwahati (All Locations)|North Lakhimpur|
		|Guwahati (All Locations)|Jorhat|

		

