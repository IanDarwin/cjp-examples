package arqdemo;

import javax.inject.Inject;


/**
 * A POJO that uses a Helloifier injected by CDI.
 */
public class Hello {

	@Inject
	Helloifier hello;

	public String demo() {
		return hello.hello();
	}

	public String demo(String s) {
		return hello.hello(s);
	}
}
