package com.parabank.utilities;

import static com.parabank.utilities.Webdriver_Utils.driver;
import static com.parabank.utilities.Webdriver_Utils.getDriver;
import static com.parabank.utilities.Webdriver_Utils.quitDriver;

import com.parabank.pages.HomePage;
import com.parabank.pages.LoginAccountPage;
import com.parabank.pages.MyAccountPage;
import com.parabank.pages.RegisterPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	public static HomePage home;
	public static RegisterPage register;
	public static LoginAccountPage loginaccount;
	public static MyAccountPage myAccountPage;

	@Before
	public static void setUp() throws Exception {
		getDriver(); // Initializes driver if not already done

		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		home = new HomePage(driver);
		register = new RegisterPage(driver);
		loginaccount = new LoginAccountPage(driver);
		myAccountPage = new MyAccountPage(driver);
	}

	@After
	public void tearDown() {
		quitDriver(); // Closes and nullifies the driver
	}
}
