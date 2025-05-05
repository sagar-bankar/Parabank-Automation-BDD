package com.parabank.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.parabank.pages.HomePage;
//import com.parabank.pages.LoginAccountPage;
//import com.parabank.pages.RegisterPage;

import net.bytebuddy.utility.RandomString;

public class Webdriver_Utils {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String randomString;
	public static Properties p;
	public static Logger log;

	// Initialize WebDriver
	public static WebDriver getDriver() throws IOException {
		if (driver == null) {
			try (FileReader file = new FileReader(
					"C:\\WorkSpaces 2 BDD\\Parabank_Automation.BDD\\src\\test\\resources\\config.properties")) {
				p = new Properties();
				p.load(file);
			} catch (IOException e) {
				throw new IOException("Failed to load properties file: " + e.getMessage());
			}

			log = Logger.getLogger(Webdriver_Utils.class);

			// Set up the WebDriver (ChromeDriver in this case)
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		}
		return driver;
	}

	// Initialize WebDriverWait
	public static WebDriverWait getWaits() throws IOException {
		if (wait == null) {
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		}

		return wait;
	}

	public static void waituntilVisibilityofWebElemnt(WebElement Element) throws IOException {

		getWaits().until(ExpectedConditions.visibilityOf(Element));
	}

	// Generate Random String (for some unique identifiers)
	static {
		randomString = RandomString.make(3);
	}

	public static String getRandomString() {
		return randomString;
	}

	public static void takeScreenshot(String fileName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshots/" + fileName + ".png");
		// Files.copy(src, dest);
		src.renameTo(dest);

		log.info("Screenshot taken: " + dest.getAbsolutePath());
	}

	// Quit Driver
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
