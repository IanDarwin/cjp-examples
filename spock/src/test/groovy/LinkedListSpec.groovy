import spock.lang.*
import java.util.*

class LinkedListSpec extends Specification {
  @Shared def target = null
  def setup() {
	target = new LinkedList();
  }
  def "Linked List add"() {
    expect:
		target.add("one"); // expect keyword expects boolean-like value
		target.get(0) == "one"
  }
}
