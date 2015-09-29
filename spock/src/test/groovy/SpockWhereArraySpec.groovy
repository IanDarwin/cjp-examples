import spock.lang.*;

class SpockWhereArraySpec extends spock.lang.Specification {
    def "Test"() {
        expect: x < y
        where:
        x << [1,2,3]
        y << [2,3,4]
    }   
}
