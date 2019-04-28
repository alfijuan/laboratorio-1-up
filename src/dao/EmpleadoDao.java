package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import basico.jdbc.DBManager;
import empresa.Empleado;

public class EmpleadoDao {
	
	public void crearEmpleado(Empleado empleado) {
		
		Connection con = DBManager.connect();
		
		String sql = "\"INSERT INTO empleados (nombre, apellido, dni, legajo, direccion, honorarios, nombreUsuario, password) "
				+ "VALUES ('" + 
				empleado.getNombre() + "',' " +
				empleado.getApellido() + "', " +
				empleado.getDni() + ", " +
				empleado.getLegajo() + ", '" +
				empleado.getDireccion() + "', " +
				empleado.getHonorarios() + ", '" +
				empleado.getNombreUsuario() + "', '" +
				empleado.getPassword() + "')";
		
		try {
			Statement s = con.createStatement();
			s.executeUpdate(sql);
			con.commit();
		}catch (SQLException e) {
			try {
				con.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
public void eliminarEmpleado(int legajo) {
		
		Connection con = DBManager.connect();
		
		String sql = "\"DELETE FROM empleados where legajo = '" + legajo + "'";
		
		try {
			Statement s = con.createStatement();
			s.executeUpdate(sql);
			con.commit();
		}catch (SQLException e) {
			try {
				con.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

public void mostrarEmpleado(int legajo) {
	
	Connection con = DBManager.connect();
	
	String sql = "\"SELECT * FROM empleados where legajo = '" + legajo + "'";
	
	try {
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);		
		
		if(rs.next()) { 
			System.out.println("Empleado:");
			System.out.print("\t" + rs.getString("nombre"));
			System.out.print("\t" + rs.getString("apellido"));
			System.out.print("\t" + rs.getInt("dni"));
			System.out.print("\t" + rs.getInt("legajo"));
			System.out.print("\t" + rs.getString("direccion"));
			System.out.print("\t" + rs.getFloat("honorarios"));
			System.out.print("\t" + rs.getString("nombreUsuario"));
			System.out.println();
		}
	}catch (SQLException e) {
		try {
			con.rollback();
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	} finally {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
	
	
}
