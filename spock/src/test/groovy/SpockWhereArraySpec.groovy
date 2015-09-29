import spock.lang.*;

class SpockWhereArraySpec extends spock.lang.Specification {
    def "Test"() {
        expect: value * value == square
        where:
        value << [1,2,3]
        square << [1,4,9]
    }   
}
