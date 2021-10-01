Feature: Automation of Redbus 

@TC_SIGN_004 
Scenario: Test Login functionality with Google credential 
	Given user is on login page 
	When user clicks on login with Google 
	And user enters gmail id 
	And user enters gmail password 
	And user clicks on the login button 
	Then user should be able to login successfully 
	
@TC_SIGN_005 
Scenario: Test Login functionality with Google credential 
	Given user is on login page 
	When user clicks on login with Google 
	And user enters gmail id 
	And user enters gmail password 
	And user clicks on the login button 
	Then user should not be able to login successfully
	
@TC_SEARCH_006
Scenario Outline: Test for bus searching functionality
	Given User is on Home page
	When User enters <from> and <to>
	And user clicks on Search Buses Button 
	Then User should be able to find successfully and buses should be displayed 
	Examples: 
		|from|to|
		|Guwahati (All Locations)|North Lakhimpur|
		#|Guwahati (All Locations)|Dibrugarh|
		
@TC_SEARCH_007
Scenario Outline: Test for bus searching functionality
	Given User is on Home page
	When User enters <from> and <to> and
	And user clicks on Search Buses Button 
	Then User should be able to find successfully and buses should be displayed 
	Examples: 
		|from|to|
		|Guwahati (All Locations)|North Lakhimpur|
		|Guwahati (All Locations)|Dibrugarh|

