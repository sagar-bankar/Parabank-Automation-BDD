Feature: User Registration

@Registration @Regression @UI @Critical
  Scenario: Registering a new user with valid data
    Given User is on the registration page
    When User fills in all required registration details
    And Clicks on the Register button
    Then A confirmation message should be displayed
    And close the browser
