package com.parabank.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/Reports/ExtentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(spark);
        

            extent.setSystemInfo("OS", "Windows");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "SAGAR BANKAR");
        }
        return extent;
    }
}
