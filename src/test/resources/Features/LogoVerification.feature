Feature: Verify logo on ParaBank login page
@UI @Sanity @Regression
  Scenario: Logo is displayed on the login page
    Given Launch application on browser
    Then the ParaBank logo should be visible
    And close the browser
