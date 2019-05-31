package dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import basico.jdbc.DBManager;
import empresa.Empleado;
import exceptions.HorasException;

public class EmpleadoDaoImpl implements EmpleadoDAO{
	
	public boolean crearEmpleado(Empleado empleado) throws HorasException{
		
		Connection con = DBManager.getInstance().connect();
		boolean returner = false;
		
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
			returner = true;
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
		return returner;
	}
	
	
	public boolean eliminarEmpleado(int legajo) throws HorasException{
		
		Connection con = DBManager.getInstance().connect();
		boolean returner = false;
		String sql = "DELETE FROM empleado where legajo = " + legajo ;
		
		try {
			Statement s = con.createStatement();
			s.executeUpdate(sql);
			con.commit();
			returner = true;
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
		return returner;
		
	}

	public Empleado obtenerEmpleado(int legajo) throws HorasException{
	
		Connection con = DBManager.getInstance().connect();
		
		Empleado empleado = null;
		
		String sql = "SELECT * FROM empleado where legajo = " + legajo;
		
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);		
			
			if(rs.next()) { 
				empleado = new Empleado(
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getInt("dni"),
						rs.getInt("legajo"),
						rs.getString("direccion"),
						rs.getFloat("honorarios"),
						rs.getString("nombreUsuario"),
						rs.getString("password")
				);
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
		
		return empleado;
	}
	
	public ArrayList<Empleado> obtenerEmpleados() {
		String sql = "SELECT * FROM empleado";
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				lista.add(new Empleado(
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getInt("dni"),
						rs.getInt("legajo"),
						rs.getString("direccion"),
						rs.getFloat("honorarios"),
						rs.getString("nombreUsuario"),
						rs.getString("password")
				));
			}
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
		return lista;
	}
	
	
}
