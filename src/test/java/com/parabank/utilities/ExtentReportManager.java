package com.parabank.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			// Add timestamp
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String reportPath = System.getProperty("user.dir") + "/Reports/ExtentReport_" + timestamp + ".html";

			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
			spark.config().setTheme(Theme.DARK);
			extent = new ExtentReports();
			extent.attachReporter(spark);

			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Tester", "SAGAR BANKAR");
		}
		return extent;
	}
}
