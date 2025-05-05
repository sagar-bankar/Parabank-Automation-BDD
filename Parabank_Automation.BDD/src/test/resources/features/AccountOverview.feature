Feature: Account Overview

@LoginOnly
  Scenario: View account overview after login
    Given User is logged in
    When User navigates to the "Accounts Overview" page
    Then All account details should be displayed
    And close the browser
    
    
@LoginOnly
  Scenario: User logs in and checks account balance
    Given User is logged in
    Then the user should be redirected to the account overview page
    And the account balance should be displayed
    And close the browser