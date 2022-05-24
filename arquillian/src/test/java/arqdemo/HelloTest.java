package arqdemo;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@Ignore
@RunWith(Arquillian.class)
public class HelloTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClasses(Hello.class, Helloifier.class)
            // Needed on older Java EE (5 and 6) to trigger CDI startup
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    Hello hello;

    @Test
    public void should_create_greeting() {
		assertEquals("Hello, world", hello.demo());
        assertEquals("Hello, Java Developer", hello.demo("Java Developer"));
    }
}
