package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import basico.jdbc.DBManager;
import empresa.Hora;
import exceptions.SystemException;
import exceptions.horas.HoraNotFoundException;

public class HorasDaoImpl implements HorasDAO{
	
	@Override
	public void cargarHoras(int idEmpleado, int idTarea, Hora hora) throws SystemException {
		Connection con = DBManager.getInstance().connect();
		
		try {
			PreparedStatement sql = con.prepareStatement("INSERT INTO horas (empleado_legajo, tarea_id, cantidad, fecha)" +
					"VALUES(?,?,?,?)");
			sql.setInt(1, idEmpleado);
			sql.setInt(2, idTarea);
			sql.setInt(3, hora.getCantidad());
			sql.setDate(4, (Date) hora.getFecha());
			
			sql.executeUpdate();
			con.commit();
			
		}catch (SQLException e) {
			try {
				con.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SystemException("Error en la base de datos");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void eliminarHoras(int idEmpleado, int idTarea) throws SystemException {
		Connection con = DBManager.getInstance().connect();
		
		try {
			PreparedStatement sql = con.prepareStatement("DELETE FROM horas where empleado_legajo =? AND tarea_id=?");
			sql.setInt(1, idEmpleado);
			sql.setInt(2, idTarea);
			
			sql.executeUpdate();
			con.commit();
		}catch (SQLException e) {
			try {
				con.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SystemException("Error en la base de datos");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void editarHoras(int idEmpleado, int idTarea, Hora hora) throws SystemException, HoraNotFoundException {
		Connection con = DBManager.getInstance().connect();
		
		try {
			PreparedStatement sql = con.prepareStatement("UPDATE horas SET cantidad=?, fecha=? WHERE empleado_legajo=? AND tarea_id=?");
			
			sql.setInt(1, hora.getCantidad());
			sql.setDate(2, (Date) hora.getFecha());
			sql.setInt(3, idEmpleado);
			sql.setFloat(4, idTarea);
			
			sql.executeUpdate();
			con.commit();
			
		}catch (SQLException e) {
			try {
				con.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SystemException("Error en la base de datos");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public List<Hora> obtenerHoras() throws SystemException {
		List<Hora> listaHoras = new ArrayList<Hora>();
		Connection con = DBManager.getInstance().connect();
		try {
			PreparedStatement sql = con.prepareStatement("SELECT * FROM horas");
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				Hora hora = new Hora();
				hora.setLegajoEmpleado(rs.getInt("empleado_legajo"));
				hora.setIdTarea(rs.getInt("tarea_id"));
				hora.setCantidad(rs.getInt("cantidad"));
				hora.setFecha(rs.getDate("fecha"));
				listaHoras.add(hora);
			}
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				//no hago nada
			}
			throw new SystemException("Error en la base de datos");
		} finally {
			try {
				con.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
		return listaHoras;
	}
	
	@Override
	public List<Integer> obtenerHoras(int legajo) throws SystemException {
		List<Integer> lista = new ArrayList<>();
		Connection con = DBManager.getInstance().connect();
		try {
			PreparedStatement sql = con.prepareStatement("select sum(cantidad) as horas_total, count(tarea_id) as tareas from horas where empleado_legajo=?");
			sql.setInt(1, legajo);
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
			}
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				//no hago nada
			}
			throw new SystemException("Error en la base de datos");
		} finally {
			try {
				con.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
		return lista;
	}

	
	@Override
	public List<Hora> obtenerHorasMes(int idEmpleado, int idTarea, int mes) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hora obtenerHoraRegistrada(int idEmpleado, int idTarea) throws SystemException{
		Hora registro = new Hora();
		Connection con = DBManager.getInstance().connect();
		try {
			PreparedStatement sql = con.prepareStatement("SELECT * FROM horas WHERE empleado_legajo=? AND tarea_id=?");
			sql.setInt(1, idEmpleado);
			sql.setFloat(2, idTarea);
			
			ResultSet rs = sql.executeQuery();
			
			Hora hora = new Hora();
			hora.setLegajoEmpleado(rs.getInt("empleado_legajo"));
			hora.setIdTarea(rs.getInt("tarea_id"));
			hora.setCantidad(rs.getInt("cantidad"));
			hora.setFecha(rs.getDate("fecha"));
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				//no hago nada
			}
			throw new SystemException("Error en la base de datos");
		} finally {
			try {
				con.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
		return registro;
	}
	
	
}
