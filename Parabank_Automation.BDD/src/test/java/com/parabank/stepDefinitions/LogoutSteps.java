package com.parabank.stepDefinitions;

import static com.parabank.utilities.Webdriver_Utils.driver;
import static com.parabank.utilities.Webdriver_Utils.takeScreenshot;
import static com.parabank.utilities.Webdriver_Utils.waituntilVisibilityofWebElemnt;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import com.parabank.utilities.Hooks;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {
	public static Logger log = Logger.getLogger(LogoutSteps.class);

	@When("User clicks on the {string} link")
	public void user_clicks_on_the_link(String linkText) throws InterruptedException, IOException {
		log.info("Attempting to click the Logout button.");

		Thread.sleep(25);
		Hooks.myAccountPage.clickOnlogOut();
		log.info("Logout button clicked successfully.");
		takeScreenshot(this.getClass().getSimpleName());
	}

	@Then("User should be redirected to the login page")
	public void user_should_be_redirected_to_the_login_page() throws InterruptedException, IOException {

		Thread.sleep(5000);

		boolean isDisplayed = false;

		for (int i = 0; i < 4; i++) {
			try {
				waituntilVisibilityofWebElemnt(Hooks.home.getlogIn());
				// isDisplayed = Hooks.home.getlogIn().isDisplayed();
				isDisplayed = Hooks.home.getcustomerLogin().isDisplayed();
				break; // Success
			} catch (StaleElementReferenceException e) {

				waituntilVisibilityofWebElemnt(driver.findElement(By.xpath("//input[@value='Log In']")));
				isDisplayed = driver.findElement(By.xpath("//input[@value='Log In']")).isDisplayed();
			}
		}

		log.info("Login button status: " + isDisplayed);
		Assert.assertTrue("Test failed: Login button is not displayed." + isDisplayed, isDisplayed);
	}
}
