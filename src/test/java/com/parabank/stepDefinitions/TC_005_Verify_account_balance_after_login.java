package com.parabank.stepDefinitions;

import static com.parabank.utilities.Webdriver_Utils.*;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.parabank.utilities.Hooks;
import com.parabank.utilities.Webdriver_Utils;

import io.cucumber.java.en.*;

public class TC_005_Verify_account_balance_after_login {
	public static Logger log = Logger.getLogger(TC_005_Verify_account_balance_after_login.class);

	@Given("the user is on the ParaBank login page")
	public void the_user_is_on_the_para_bank_login_page() throws Exception {
		Hooks.setUp();
		log.info("login page is opened");
	}

	@When("the user logs in with username {string} and password {string}")
	public void the_user_logs_in_with_username_and_password(String string, String string2) {
		Hooks.home.sendusername(p.getProperty("Username") + randomString);
		Hooks.home.sendpassword(p.getProperty("Password"));

		Hooks.home.clickOnlogIn();
		log.info("log in successfully....");
	}

	@Then("the user should be redirected to the account overview page")
	public void the_user_should_be_redirected_to_the_account_overview_page() {
		
		log.info("Account overview page title: "+driver.getTitle());
	}

	@Then("the account balance should be displayed")
	public void the_account_balance_should_be_displayed() throws IOException {
		waituntilVisibilityofWebElemnt(Hooks.myAccountPage.getaccountBalance());
		
		Assert.assertTrue("Status of the account balance should be displayed: "+Hooks.myAccountPage.isaccountBalanceDisplay(), Hooks.myAccountPage.isaccountBalanceDisplay());
	}

}
