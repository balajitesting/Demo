package Qualiframe.Qualiframe;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

public class ExperiTestRemote {

	private static final String ACCESS_KEY = "eyJ4cC51IjoyMjk3OTksInhwLnAiOjE4OTg2MiwieHAubSI6Ik1UVTNOVEkzT0RFeE9UTTJOUSIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE4OTA2MzgxMTksImlzcyI6ImNvbS5leHBlcml0ZXN0In0.q4FWYk-uMueHMiTa4iaNLBQLAqyhGETYd_3RY3GymL0";
	private RemoteWebDriver driver;
	private URL url;
	private DesiredCapabilities dc = new DesiredCapabilities();

	@BeforeMethod
	public void setUp() throws Exception {

		url = new URL("https://demo.experitest.com/wd/hub");
		dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		dc.setCapability(CapabilityType.PLATFORM, Platform.ANY);
		dc.setCapability("accessKey", ACCESS_KEY);
		dc.setCapability("testName", "Quick Start Chrome Browser Demo");
		driver = new RemoteWebDriver(url, dc);
	}

	@Test
	public void browserTestGoogleSearch() {
		driver.get("https://www.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.click();
		searchBar.sendKeys("Experitest");
		searchBar.sendKeys(Keys.ENTER);
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
		driver.quit();
	}

}