Feature: User Login
@Login @Smoke @Regression @UI @Critical
  Scenario: Successful login with valid credentials
    Given Launch application on browser
    When User enters valid username and password
    And Clicks on the login button
    Then User should be redirected to the account overview page
    And close the browser
  
 @Login @Regression @UI @NegativeTest   
  Scenario: Login with invalid credentials
	  Given Launch application on browser
	  When User enters invalid username or password
	  And Clicks on the login button
	  Then An error message should be displayed
	  And close the browser