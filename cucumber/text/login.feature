Feature: As a user, I need to be able to log in to the system

	This application will work like most other applications that
	require a login mechanism.

	Scenario: Ready to log in
		Given I start the application
		And I am not logged in
		Then I should see the login page

	Scenario: Logging in
		Given I enter 'fred' in the 'Username' field
		And I enter 'freds-password123' in the 'Password' field
		And I choose the 'Login' control
		Then I should see the Home page

	Scenario: Logging out
		Given I am logged in
		Then I should see the "Logout" control
		And I choose the 'Logout button'
		Then I should see the 'login' page
		And I should not see the 'Home' Page
