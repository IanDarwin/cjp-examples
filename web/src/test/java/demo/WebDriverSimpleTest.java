package demo;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverSimpleTest {

	final static String CHROMEDRIVER_PATH_KEY = "webdriver.chrome.driver";
	final static String CHROMEDRIVER_DEFAULT_PATH = 
		"/usr/local/bin/chromedriver";

	public final String SCREENSHOT_SAVE_NAME = "/tmp/screenshot.png";

	enum DriverType { CHROME, FIREFOX, HTMLUNIT };
	private static WebDriver driver;

	@BeforeClass
	public static void setupDriver() {
		String driverProperty = System.getProperty("DRIVER");
		DriverType driverType;
		if (driverProperty == null)
			driverType = DriverType.CHROME;
		else
			driverType = DriverType.valueOf(driverProperty.toUpperCase());
		switch(driverType) {
		case CHROME:
			if (System.getProperty(CHROMEDRIVER_PATH_KEY) == null) {
				System.setProperty("webdriver.chrome.driver", 
					CHROMEDRIVER_DEFAULT_PATH);
			}
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case HTMLUNIT:
			driver = new HtmlUnitDriver();
			break;
		default:
			throw new IllegalArgumentException(driverProperty);
		}
		System.out.println("Using WebDriver: " + driver);
	}

	@Test
	public void testSearchBox() {

        // Let's go look at O'Reilly books
        driver.get("http://www.oreilly.com/");

        // Find search box textfield (e.g., see line 436 in this page's View Source as of early 2016)
        WebElement element = driver.findElement(By.name("q"));

        // Enter an ISBN to search for
        element.clear(); // In case search box has a Prototype
        element.sendKeys("0636920026518");

        // When we ask to submit the element, WebDriver will find the 
        // nearest enclosing <form...> element and submit that instead.
        element.submit();

		// Now the browser (and hence the web driver) should be on the search results page

        // Verify the title of the page
        assertTrue("Page title", driver.getTitle().contains("O'Reilly Search"));

        // Verify the search results
		assertTrue("found", driver.getPageSource().contains("Java Cookbook"));
		
		if (driver instanceof TakesScreenshot) {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			boolean renamed = screenshot.renameTo(new File(SCREENSHOT_SAVE_NAME));
			assertTrue("Moved screenshot to " + SCREENSHOT_SAVE_NAME, renamed);
			System.out.println("Screenshot saved as " + SCREENSHOT_SAVE_NAME);
		} else {
			System.out.println("Driver does not implement " + TakesScreenshot.class.getName());
		}
	}
	
	// Other test methods here would share the Driver instance...
	
	@AfterClass
	public static void closeDriver() {
		// All done
        driver.quit();
	}
}
