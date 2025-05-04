Feature: Verify account balance after login
@Regression
  Scenario: User logs in and checks account balance
    Given the user is on the ParaBank login page
    When the user logs in with username "john" and password "demo"
    Then the user should be redirected to the account overview page
    And the account balance should be displayed
    And close the browser