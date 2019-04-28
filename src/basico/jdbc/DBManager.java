package basico.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	private static final String DB_DRIVER = "org.hsqldb.jdbcDriver";
	private static final String DB_URL = "jdbc:postgresql://ec2-174-129-10-235.compute-1.amazonaws.com:5432/d4kaca42s0k4ie?user=kjsnodphpydoph&password=61e8e88f01d2d12f691ee80d15af59c574e60c49ed8ddd1fae330b795ac38eaa";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";

	public static Connection connect() {
		Connection c = null;
			//Class.forName(DB_DRIVER);
		try {
			c = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			c.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		return c;
	}

	public static void shutdown() throws Exception {
		Connection c = connect();
		Statement s = c.createStatement();
		s.execute("SHUTDOWN");
		c.close();
	}

}
