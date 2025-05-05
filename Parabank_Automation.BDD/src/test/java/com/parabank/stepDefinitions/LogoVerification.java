package com.parabank.stepDefinitions;

import org.junit.Assert;

import com.parabank.utilities.Hooks;

import io.cucumber.java.en.Then;

public class LogoVerification {

	@Then("the ParaBank logo should be visible")
	public void the_para_bank_logo_should_be_visible() {
		Hooks.home.isDisplayed_Parabank();
		Assert.assertTrue("Logo display status:" + Hooks.home.isDisplayed_Parabank(),
				Hooks.home.isDisplayed_Parabank());
				
	}

}
