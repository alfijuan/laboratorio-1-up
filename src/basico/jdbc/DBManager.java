package basico.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.net.URI;
import java.net.URISyntaxException;

public class DBManager {
	
	private static DBManager instance;
	private static Connection connection;
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://ec2-174-129-10-235.compute-1.amazonaws.com:5432/d4kaca42s0k4ie?user=kjsnodphpydoph&password=61e8e88f01d2d12f691ee80d15af59c574e60c49ed8ddd1fae330b795ac38eaa";
//	private static final String DB_URL = "jdbc:postgresql://ec2-174-129-10-235.compute-1.amazonaws.com:5432/d4kaca42s0k4ie";
	private static final String DB_USERNAME = "kjsnodphpydoph";
	private static final String DB_PASSWORD = "61e8e88f01d2d12f691ee80d15af59c574e60c49ed8ddd1fae330b795ac38eaa";
	
    public static Connection getConnection() {
        return connection;
    }
    
    private DBManager() throws SQLException, URISyntaxException {
        try {
            Class.forName(DB_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

//	public static Connection connect() {
//		Connection c = null;
//			
//		try {
//			Class.forName(DB_DRIVER);
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//			System.exit(0);
//		}
//		try {
//			c = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//			c.setAutoCommit(false);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.exit(0);
//		}
//
//		return c;
//	}
	
	public static DBManager getInstance() throws SQLException, URISyntaxException {
		System.out.println("here2");
        if (instance == null) {
        	System.out.println("here");
            instance = new DBManager();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBManager();
        }
        System.out.println("return");

        return instance;
    }

//	public static void shutdown() throws Exception {
//		Connection c = connect();
//		Statement s = c.createStatement();
//		s.execute("SHUTDOWN");
//		c.close();
//	}

}
