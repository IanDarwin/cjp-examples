import spock.lang.*;

class MyArrayListSpec extends Specification {
    @Shared myArrayList = new ArrayList();
    def "ArrayList clear works"() {
		given: "The user adds something to a List"
			myArrayList.add("some value")
        when: "We clear the list"
            myArrayList.clear()
        then: "There should be nothing left in the list"
            myArrayList.size() == 0
            !myArrayList    // Shorter form based on meaning of 'truth' in Groovy.
    }
}

