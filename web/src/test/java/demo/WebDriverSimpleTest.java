package demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverSimpleTest {

	@Test
	public void testSearchBox() {
        WebDriver driver;
        driver = new HtmlUnitDriver();
        //driver = new FirefoxDriver();

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

		// All done
        driver.quit();
	}
}
