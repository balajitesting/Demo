package Qualiframe.Qualiframe;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass2 {

	public WebDriver driver;	
	public String url;
	public DesiredCapabilities desCap = DesiredCapabilities.chrome();
	

	@BeforeMethod
	public void launchDriver() throws MalformedURLException {
		url = "http://192.168.1.8:4444/wd/hub";
		desCap.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL(url), desCap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/*
	 * @Test public void Test1() {
	 * driver.navigate().to("https://automationtalks.com/");
	 * System.out.println(driver.getTitle()); System.out.println("Test 1 Title is "
	 * + driver.getTitle()); }
	 */

	@Test
	public void Test2() {
		driver.get("https://www.google.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.click();
		searchBar.sendKeys("Selenium GRID");
		searchBar.sendKeys(Keys.ENTER);
	}

	/*
	 * @Test public void Test3() {
	 * driver.navigate().to("https://automationtalks.com/");
	 * System.out.println("Test 3 Title is " + driver.getTitle()); }
	 */
	
	@AfterMethod
	public void quit() {
		driver.quit();
		//if the test case fails log an issue in JIRA
	}
}