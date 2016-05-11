import geb.spock.GebSpec
import geb.Browser;

class WebPageSpec extends GebSpec {

	static final String HOMEPAGE = 'https://darwinsys.com/'

	def "Test the Home Page"() {
		when: "I try to load the home page"
			Browser.drive {
				go HOMEPAGE
			}

		then: "First page should load"
			title.startsWith("Ian Darwin")
	}
}
