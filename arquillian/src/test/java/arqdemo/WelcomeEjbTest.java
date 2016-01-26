package arqdemo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class WelcomeEjbTest {
	
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "helloejb.jar")
            .addClasses(WelcomeEjbTest.class, WelcomeEjb.class, Helloifier.class);
    }

	@EJB
	WelcomeEjb hello;

	@Test
	public void test() throws IOException {
		    String greeting = hello.greet("Jo");
		    // Check out the response
		    assertEquals("Hello, Jo", greeting);
	}
}
