import spock.lang.*

class HelloSpockSpec extends Specification {
    def "Hello World"() {
        expect:
            "hello world".length() == 11
  }
}
