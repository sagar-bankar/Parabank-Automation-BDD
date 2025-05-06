package com.parabank.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ExtentHooks {
	private static ExtentReports extent = ExtentReportManager.getInstance();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Before
	public void beforeScenario(Scenario scenario) {
		ExtentTest extentTest = extent.createTest(scenario.getName());
		test.set(extentTest);
	}

	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			test.get().fail("Scenario Failed");
			// optionally attach screenshots
		} else {
			test.get().pass("Scenario Passed");
		}

		extent.flush();
	}
}
