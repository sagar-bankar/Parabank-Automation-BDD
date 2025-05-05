Feature: Account Overview

  Scenario: View account overview after login
    Given User is logged in
    When User navigates to the "Accounts Overview" page
    Then All account details should be displayed
    And close the browser