Feature: Verify logo on ParaBank login page

  Scenario: Logo is displayed on the login page
    Given the user is on the ParaBank login page
    Then the ParaBank logo should be visible
    And close the browser
