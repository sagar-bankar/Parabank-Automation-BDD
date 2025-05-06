Feature: Account Overview
@AccountOverview @Regression @UI
  Scenario: Display account overview details
    Given User is logged in
    When User navigates to the "Accounts Overview" page
    Then All account details should be displayed
    And close the browser
    
 @AccountOverview @Regression @UI
  Scenario: User logs in and checks account balance
    Given User is logged in
    When User navigates to the "Accounts Overview" page
    And the account balance should be displayed
    And close the browser