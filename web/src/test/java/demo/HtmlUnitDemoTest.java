package demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Ignore;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@Ignore // Can't get working dependency versions
public class HtmlUnitDemoTest {

	@Test
	public void pageTest() throws Exception {
	    try (final WebClient webClient = new WebClient()) {
	    	final WebClientOptions options = webClient.getOptions();
			options.setThrowExceptionOnScriptError(false);
			options.setThrowExceptionOnFailingStatusCode(false);
			options.setJavaScriptEnabled(false); // bypass horrible slowdown
		    
	        final HtmlPage page = webClient.getPage("http://oreilly.com");
	        assertTrue(page.getTitleText().contains("O'Reilly Media"));

	        // Fill in form and click "Search" button/link
	        HtmlInput searchBox = page.getElementByName("q");
	        // System.out.println(searchBox);
	        searchBox.setValueAttribute("9781492072583");
	        // The image-button we want to click has no ID or Name but is inside a div with this id:
	        HtmlInput searchButton = 
	        (HtmlInput) page.getElementById("search-button").getChildNodes().get(0);
	        // Clicking the button should move to a new page
	        // System.out.println(searchButton);
		    HtmlPage page2 = searchButton.click();

		    // Check for results
	        final String pageAsText = page2.toString();
	        // System.out.println(pageAsText);
	        assertTrue(pageAsText.contains("Java Cookbook"));
	    }
	}
}
