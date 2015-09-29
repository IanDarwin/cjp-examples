import groovy.sql.Sql

import spock.lang.*

class DatabaseSpec extends Specification {
	@Shared def db = 
		[url:'jdbc:postgresql:javatest', user:'javatest', password:'xecret', driver:"org.postgresql.Driver"]
	@Shared def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

	def "DatabaseTest"() {
			def found = false
			def r = sql.rows("select name from javatest order by lower(name)");
			r.each() {
				// row -> println "${row.name}"
				if (row.name == 'spock') {
					println("Their database is logical, captain");
					found = true;
				}
			}
		expect:
			r.size() > 0
			found
	}
}

