Feature: Login to the Parabank website
  I want to use this template to validate the credentials of an existing user
  
  Background: User logs In with valid credentials
  	Given User navigates to Parabank website
    And User enters valid username
    And User enters valid password
    When User clicks Log In button
    Then User is taken to Accounts Overview successfully

  Scenario: User creates new bank account
  	Given User navigates to Open New Account Page
		Then User is taken to Open New Account Page
		When User selects checking
		And User selects second account
		And User clicks on Open New Account button
		Then User is taken to confirmation page
		
	Scenario: User transfers money from one account to another
  	Given User navigates to Transfer Funds Page
		Then User is taken to Transfer Funds Page
		When User enters amount
		And User selects to withdraw from second acount
		And User selects to deposit to third account
		And User clicks transfer button1
		Then User is taken to transfer confirmation page