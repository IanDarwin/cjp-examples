import groovy.sql.Sql
import spock.lang.*

class DatabaseSpec extends Specification {
	@Shared def db = 
		// For H2
		[url:'jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE', 
			user:'sa', password:'xecret', driver:"org.h2.Driver"]
		// For PostgreSQL
		// [url:'jdbc:postgresql:javatest', 
		//	user:'javatest', password:'xecret', driver:"org.postgresql.Driver"]

	@Shared def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

	def setupData() {
		sql.execute("create table if not exists javatest(id integer primary key, name varchar)");
		sql.execute("delete from javatest");
		sql.execute("insert into javatest(id, name) values(42, 'spock')");
	}

	def "As Administrator, I want to be sure there's an entry for Spock in the Database"() {
		setupData();	// fakin' it: set up for this test.
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
