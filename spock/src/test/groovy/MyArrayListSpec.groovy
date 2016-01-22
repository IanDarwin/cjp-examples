import spock.lang.*;

class MyArrayListSpec extends Specification {
    @Shared myArrayList = new ArrayList();
    def "ArrayList clear works"() {
        myArrayList.add("some value")
        when:
            myArrayList.clear()
        then:
            myArrayList.size() == 0
            !myArrayList    // Shorter form based on meaning of 'truth' in Groovy.
    }
}

