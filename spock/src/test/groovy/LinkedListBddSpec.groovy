import spock.lang.*
import java.util.*

// The LinkedList example written in BDD style

class LinkedListBDDSpec extends Specification {
	def "add element to LinkedList"() {
		given:
			def list = new LinkedList()

		when:
			list.add("one")

		then:
			list.size() == 1
			list.get(0) == "one"
	}
}
