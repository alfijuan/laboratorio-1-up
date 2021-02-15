package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basico.jdbc.DBManager;
import empresa.Empleado;
import exceptions.SystemException;
import exceptions.empleado.EmpleadoNotFoundException;

public class EmpleadoDaoImpl implements EmpleadoDAO{
	
	public void crearEmpleado(Empleado empleado) throws SystemException{
		
		Connection con = DBManager.getInstance().connect();
		
		try {
			PreparedStatement sql = con.prepareStatement("INSERT INTO empleado (nombre, apellido, dni, direccion, honorarios)" +
					"VALUES(?,?,?,?,?)");
			sql.setString(1, empleado.getNombre());
			sql.setString(2, empleado.getApellido());
			sql.setInt(3, empleado.getDni());
			sql.setString(4, empleado.getDireccion());
			sql.setFloat(5, empleado.getHonorarios());
			
			sql.executeUpdate();
			con.commit();
			
		}catch (SQLException e) {
			try {
				con.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SystemException("Error en la base de datos insertar el empleado");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void editarEmpleado(Empleado empleado) throws SystemException, EmpleadoNotFoundException{
		
		Connection con = DBManager.getInstance().connect();
		
		try {
			PreparedStatement sql = con.prepareStatement("UPDATE empleado SET nombre=?, apellido=?, direccion=?, honorarios=? WHERE legajo=?");
			
			sql.setString(1, empleado.getNombre());
			sql.setString(2, empleado.getApellido());
			sql.setString(3, empleado.getDireccion());
			sql.setFloat(4, empleado.getHonorarios());
			sql.setInt(5, empleado.getLegajo());
			
			sql.executeUpdate();
			con.commit();
			
		}catch (SQLException e) {
			try {
				con.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SystemException("Error en la base de datos al modificar el usuario.");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void eliminarEmpleado(int legajo) throws SystemException, EmpleadoNotFoundException{
		
		Connection con = DBManager.getInstance().connect();
		
		try {
			PreparedStatement sql = con.prepareStatement("DELETE FROM empleado where legajo =?");
			sql.setInt(1, legajo);
			
			sql.executeUpdate();
			con.commit();
		}catch (SQLException e) {
			try {
				con.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SystemException("Error en la base de datos al borrar el usuario");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public Empleado obtenerEmpleado(int legajo) throws SystemException{
	
		Connection con = DBManager.getInstance().connect();
		Empleado empleado = null;
		
		try {
			PreparedStatement sql = con.prepareStatement("SELECT * FROM empleado where dni =?");
			sql.setInt(1, legajo);
			
			ResultSet rs = sql.executeQuery();
			
			if(rs.next()) { 
				empleado = new Empleado(
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getInt("dni"),
						rs.getInt("legajo"),
						rs.getString("direccion"),
						rs.getFloat("honorarios")
				);
			}
		}catch (SQLException e) {
			try {
				con.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SystemException("Error en la base de datos al intentar obtener los empleados.");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return empleado;
	}
	
	public List<Empleado> obtenerEmpleados() throws SystemException {
		List<Empleado> lista = new ArrayList<Empleado>();
		Connection con = DBManager.getInstance().connect();
		try {
			PreparedStatement sql = con.prepareStatement("SELECT * FROM empleado ORDER BY legajo");
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				lista.add(new Empleado(
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getInt("dni"),
						rs.getInt("legajo"),
						rs.getString("direccion"),
						rs.getFloat("honorarios")
				));
			}
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
			throw new SystemException("Error en la base de datos al intentar obtener los empleados.");
		} finally {
			try {
				con.close();
			} catch (SQLException e1) {
			}
		}
		return lista;
	}
	
	public Boolean verificarEliminacionEmpleado(int legajo) throws SystemException {
		Boolean resultado= false;
		Connection con = DBManager.getInstance().connect();
		try {
			PreparedStatement sql = con.prepareStatement("SELECT count(*) FROM horas WHERE empleado_legajo =?");
			sql.setInt(1, legajo);
			
			ResultSet rs = sql.executeQuery();
			rs.next();
			resultado = rs.getInt("count") == 0;
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
			throw new SystemException("Error en la base de datos al verificar la eliminacion del empleado.");
		} finally {
			try {
				con.close();
			} catch (SQLException e1) {
			}
		}
		return resultado;
	}
}
