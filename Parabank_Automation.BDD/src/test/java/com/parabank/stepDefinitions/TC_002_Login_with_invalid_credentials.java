package com.parabank.stepDefinitions;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.parabank.utilities.Hooks;

import io.cucumber.java.en.*;

public class TC_002_Login_with_invalid_credentials {

	// Initialize logger for this class
	static Logger log = Logger.getLogger(TC_002_Login_with_invalid_credentials.class);

	@When("User enters invalid username or password")
	public void user_enters_invalid_username_or_password() {
		log.info("Entering invalid credentials");
		Hooks.home.sendusername("wrong");
		Hooks.home.sendpassword("pass");
		log.info("Invalid credentials entered");
	}

	@Then("An error message should be displayed")
	public void an_error_message_should_be_displayed() {
		log.info("Validating error message");
		String expectedMessage = "The username and password could not be verified.";
		String actualMessage = Hooks.home.pleaseEnterAUsernameAndPa(); // consider renaming this method for clarity

		Assert.assertEquals("Error message mismatch!", expectedMessage, actualMessage);
		log.info("Error message validation passed");
	
	}
}
