package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import basico.jdbc.DBManager;
import empresa.Empleado;
import exceptions.HorasException;

public class EmpleadoDaoImpl implements EmpleadoDAO{
	
	public void crearEmpleado(Empleado empleado) throws HorasException{
		
		Connection con = DBManager.getInstance().connect();
		
		String sql = "INSERT INTO empleado (legajo, nombre, apellido, dni, direccion, honorarios, nombreUsuario, password) "
				+ "VALUES (" + 
				empleado.getLegajo() + ", '" +
				empleado.getNombre() + "', '" +
				empleado.getApellido() + "', " +
				empleado.getDni() + ", '" +
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
	
	
public void eliminarEmpleado(int legajo) throws HorasException{
		
		Connection con = DBManager.getInstance().connect();
		
		String sql = "DELETE FROM empleado where legajo = '" + legajo + "'";
		
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

public void mostrarEmpleado(int legajo) throws HorasException{
	
	Connection con = DBManager.getInstance().connect();
	
	String sql = "\"SELECT * FROM empleado where legajo = '" + legajo + "'";
	
	try {
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);		
		
		if(rs.next()) { 
			System.out.println("Empleado:");
			System.out.println(rs);
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
