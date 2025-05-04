package com.parabank.stepDefinitions;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.parabank.utilities.Hooks;

import io.cucumber.java.en.*;

import static com.parabank.utilities.Webdriver_Utils.p;
import static com.parabank.utilities.Webdriver_Utils.randomString;
import static com.parabank.utilities.Webdriver_Utils.*;

import java.io.IOException;

public class TC_001_Successful_login_with_valid_credentials {

	static Logger log = Logger.getLogger(TC_001_Successful_login_with_valid_credentials.class);

	@Given("Launch application on browser")
	public void Launch_application_on_browser() throws Exception {
		log.info("Launching the application on the browser.");
		Hooks.setUp(); // Initializes WebDriver and launches the browser
		log.info("Browser launched and application opened successfully.");
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
		log.info("Entering valid username and password.");
		Hooks.home.sendusername(p.getProperty("Username") + randomString);
		Hooks.home.sendpassword(p.getProperty("Password"));
		log.info("Credentials entered.");
	}

	@When("Clicks on the login button")
	public void clicks_on_the_login_button() throws IOException {
		log.info("Clicking on the login button.");
		Hooks.home.clickOnlogIn();
		log.info("Login button clicked.");
		takeScreenshot(this.getClass().getSimpleName());
	}

	@Then("User should be redirected to the account overview page")
	public void user_should_be_redirected_to_the_account_overview_page() throws IOException {
		log.info("Verifying that user is on the account overview page.");
		waituntilVisibilityofWebElemnt(Hooks.myAccountPage.getlogOut());
		
		System.out.println("Test case is passed...");
		log.info("Test case passed: User successfully logged in and redirected to account overview.");
	Assert.assertTrue("is diplaying log out button: "+Hooks.myAccountPage.isDisablelogOut(), Hooks.myAccountPage.isDisablelogOut());
	}

	@And("close the browser")
	public void close_the_browser() {
		log.info("Test completed. Closing the browser.");
		// Hooks.tearDown(); // Uncomment if tearDown method is implemented
	}
}
