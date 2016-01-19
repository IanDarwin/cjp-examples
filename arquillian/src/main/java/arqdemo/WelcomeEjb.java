package arqdemo;

import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 * A SFSB that uses a Helloifier injected by CDI.
 */
@Singleton
public class WelcomeEjb {

	@Inject
	Helloifier hello;
	
	public String greet(String name) {
		return hello.hello(name);
	}

	public String greet() {
		return hello.hello();
	}
}
