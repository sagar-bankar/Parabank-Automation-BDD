package com.parabank.stepDefinitions;

import org.apache.log4j.Logger;

import com.parabank.utilities.Hooks;
import com.parabank.utilities.Webdriver_Utils;
import static com.parabank.utilities.Webdriver_Utils.p;
import static com.parabank.utilities.Webdriver_Utils.randomString;

import io.cucumber.java.en.*;

public class TC_003_View_account_overview_after_login {
	public static Logger log = Logger.getLogger(TC_003_View_account_overview_after_login.class);

	@Given("User is logged in")
	public void user_is_logged_in() throws Exception {

		Hooks.setUp();
		log.info("log in to ...");
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

}
