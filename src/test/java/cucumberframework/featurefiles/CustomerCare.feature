Feature: Customer Care
  I want to use this template for test the customer care option

  Scenario: Customer creates a customer care report
    Given User navigates to Parabank website
    When User clicks on Contact button
    Then User is navigated to Customer Care page
    When User enters name
    And User enters email
    And User enters phone nummber
    And User enters message
    And User clicks Send To button
    Then User is navigated to Customer Care confirmation page
