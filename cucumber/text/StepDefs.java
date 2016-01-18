package cjp;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {
	
	Helloifier helloifier = new Helloifier();
	
	String whatItSaid = null;

	@When("^I start up my computer$")
	public void i_start_up_my_computer() throws Throwable {
	    whatItSaid = helloifier.hello();
	}

	@Then("^It should say \"(.*?)\"$")
	public void it_should_say(String expected) throws Throwable {
	    assertEquals(expected, whatItSaid);
	}

	@When("^I login as \"(.*?)\" to my computer$")
	public void i_login_as_to_my_computer(String username) throws Throwable {
	    whatItSaid = helloifier.hello(username);
	}
}
