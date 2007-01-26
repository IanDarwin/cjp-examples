package extensions.test;

import java.sql.SQLException;

/**
 * This class exists for no reason other than to show the DontThrowSQLException rule.
 */
public class DontThrowSQLExceptionDemo { // NOPMD

	public String getCustomerName() throws SQLException {
		return null;
	}
	public String getCustomerStreetAddr() throws SQLException {
		return null;
	}
}

