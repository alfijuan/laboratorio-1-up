package basico.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

	public void createUserTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE empleado ( legajo INTEGER IDENTITY, nombre VARCHAR(100), apellido VARCHAR(100), dni INTEGER, "
					+ "direccion VARCHAR(100), honorarios DECIMAL(7,2), nombreUsuario VARVHAR(20), password VARCHAR(20))";		
		
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	
	public void dropUserTable() {

		Connection c = DBManager.connect();
		
		String sql = "DROP TABLE empleado";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
