package arqdemo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class WelcomeEjbTest {
	
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClasses(WelcomeEjbTest.class, WelcomeEjb.class, Helloifier.class);
    }

	@EJB
	WelcomeEjb hello;

	@Test
	@Ignore // So Arquillian tests will pass "by default" with the weld profile, minimal dependency.
	public void test() throws IOException {
		    String greeting = hello.greet("Jo");
		    // Check out the response
		    assertEquals("Hello, Jo", greeting);
	}
}
