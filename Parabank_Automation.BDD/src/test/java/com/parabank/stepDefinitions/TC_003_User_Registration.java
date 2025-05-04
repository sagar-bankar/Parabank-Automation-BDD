package com.parabank.stepDefinitions;

import static com.parabank.utilities.Webdriver_Utils.p;
import static com.parabank.utilities.Webdriver_Utils.randomString;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.parabank.utilities.Hooks;

import io.cucumber.java.en.*;

public class TC_003_User_Registration {

	static Logger log = Logger.getLogger(TC_003_User_Registration.class);

	@Given("User is on the registration page")
	public void user_is_on_the_registration_page() {
		log.info("Navigating to the registration page.");
		Hooks.home.clickOnRegister();
	}

	@When("User fills in all required registration details")
	public void user_fills_in_all_required_registration_details() {
		log.info("Filling in registration form with data from config.properties.");

		Hooks.register.sendFirstName(p.getProperty("First_Name") + randomString);
		Hooks.register.sendLasttName(p.getProperty("Last_Name"));
		Hooks.register.sendAddressstreet(p.getProperty("Address"));
		Hooks.register.sendaddresscity(p.getProperty("city"));
		Hooks.register.sendaddressstate(p.getProperty("state"));
		Hooks.register.sendAddresszipCode(p.getProperty("zipcode"));
		Hooks.register.sendphoneNumber(p.getProperty("phone"));
		Hooks.register.sendcustomerssn(p.getProperty("SSN"));
		Hooks.register.sendUserName(p.getProperty("Username") + randomString);
		Hooks.register.sendPasswordName(p.getProperty("Password"));
		Hooks.register.sendRepeatPasswordName(p.getProperty("Password"));

		log.info("Registration form filled successfully.");
	}

	@And("Clicks on the Register button")
	public void clicks_on_the_register_button() {
		log.info("Clicking on the Register button.");
		Hooks.register.clickOnNewUserRegister();
	}

	@Then("A confirmation message should be displayed")
	public void a_confirmation_message_should_be_displayed() {
		log.info("Verifying confirmation message after registration.");
		String expectedMessage = "Your account was created successfully";
		String actualMessage = Hooks.loginaccount.getSuccessMessage(); // Consider renaming this method if misleading

		Assert.assertTrue("TC_003_User_Registration failed - expected message not found",
				actualMessage.contains(expectedMessage));
		log.info("User registration test passed with confirmation message: " + actualMessage);
	}
}
