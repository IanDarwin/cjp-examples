import groovy.sql.Sql
import spock.lang.*

// Will only work if database is set up, see README

class DatabaseSpec extends Specification {
	@Shared def db = 
		[url:'jdbc:postgresql:javatest', user:'javatest', password:'xecret', driver:"org.postgresql.Driver"]
	@Shared def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

	def "As Administrator, I want to be sure there's an entry for Spock in the Database"() {
		given:
			def found = false
		when: "We look to see if spock has been added to the database"
			sql.eachRow("select name from javatest order by lower(name)") { r->
				// println r.name
				if (r.name.equalsIgnoreCase('spock')) {
					found = true;
				}
			}
		then: "We should have found it in the database"
			found
	}
}
