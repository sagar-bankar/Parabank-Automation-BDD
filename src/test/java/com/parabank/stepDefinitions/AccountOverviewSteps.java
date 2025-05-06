package com.parabank.stepDefinitions;

import static com.parabank.utilities.Webdriver_Utils.driver;
import static com.parabank.utilities.Webdriver_Utils.p;
import static com.parabank.utilities.Webdriver_Utils.randomString;
import static com.parabank.utilities.Webdriver_Utils.waituntilVisibilityofWebElemnt;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.parabank.utilities.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountOverviewSteps {
	public static Logger log = Logger.getLogger(AccountOverviewSteps.class);

	@Given("User is logged in")
	public void user_is_logged_in() throws Exception {

		Hooks.setUp();
		log.info("log in to ....");
		Hooks.home.sendusername(p.getProperty("Username") + randomString);
		Hooks.home.sendpassword(p.getProperty("Password"));

//		Hooks.home.sendusername("admin");
//		Hooks.home.sendpassword("admin123");
		Hooks.home.clickOnlogIn();
		log.info("log in successfully....");

	}

	@When("User navigates to the {string} page")
	public void user_navigates_to_the_page(String string) {
		log.info("navigate to .." + string);
	}

	@Then("All account details should be displayed")
	public void all_account_details_should_be_displayed() {
		log.info("account details showing...");
	}

	// Scenario: User logs in and checks account balance

	@Then("the user should be redirected to the account overview page")
	public void the_user_should_be_redirected_to_the_account_overview_page() {

		log.info("Account overview page title: " + driver.getTitle());
	}

	@Then("the account balance should be displayed")
	public void the_account_balance_should_be_displayed() throws IOException {
		waituntilVisibilityofWebElemnt(Hooks.myAccountPage.getaccountBalance());

		Assert.assertTrue(
				"Status of the account balance should be displayed: " + Hooks.myAccountPage.isaccountBalanceDisplay(),
				Hooks.myAccountPage.isaccountBalanceDisplay());
	}

}
