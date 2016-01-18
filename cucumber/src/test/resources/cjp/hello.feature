Feature: As a user, I want my computer to say hello to me.

	Scenario: Saying Hello in general
		When I start up my computer 
		Then It should say "Hello, World"
		
	Scenario: Saying Hello to me
		When I login as "BilliBezel" to my computer 
		Then It should say "Hello, BilliBezel"
