import spock.lang.*
import org.junit.Ignore;

class FailureSpec extends Specification {

	def "Failsome StringBuilder append"() {
		expect:
			// Un-comment the following line line out to see the nice failure message
			// new StringBuilder().append("Hello").append("World").equals("Hello World");
			true
	}
}
