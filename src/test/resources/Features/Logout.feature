Feature: Logout

@Logout @Smoke @Regression @UI
 Scenario: Logout from the application
    Given User is logged in
    When  User clicks on the "Log Out" link
    Then  User should be redirected to the login page
     And  close the browser
