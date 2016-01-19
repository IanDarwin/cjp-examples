package arqdemo;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named @RequestScoped
public class Helloifier implements Serializable {

	private static final long serialVersionUID = 1L;

	public String hello() {
		return "Hello, world";
	}

	public String hello(String s) {
		return "Hello, " + s;
	}
}
