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
	public void cargarHoras(Hora hora) throws SystemException {
		Connection con = DBManager.getInstance().connect();
		
		try {
			PreparedStatement sql = con.prepareStatement("INSERT INTO horas (empleado_legajo, tarea_id, cantidad, fecha)" +
					"VALUES(?,?,?,?)");
			sql.setInt(1, hora.getLegajoEmpleado());
			sql.setInt(2, hora.getIdTarea());
			sql.setInt(3, hora.getCantidad());
			sql.setDate(4, convertUtilToSql(hora.getFecha()));
			
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
	public void eliminarHoras(Integer idHora) throws SystemException {
		Connection con = DBManager.getInstance().connect();
		
		try {
			PreparedStatement sql = con.prepareStatement("DELETE FROM horas where id_hora =?");
			sql.setInt(1, idHora);
			
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
	public void editarHoras(Hora hora) throws SystemException, HoraNotFoundException {
		Connection con = DBManager.getInstance().connect();
		
		try {
			PreparedStatement sql = con.prepareStatement("UPDATE horas SET cantidad=?, fecha=? WHERE id_hora=?");
			
			sql.setInt(1, hora.getCantidad());
			sql.setDate(2, convertUtilToSql(hora.getFecha()));
			sql.setInt(3, hora.getIdHora());
			
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
			PreparedStatement sql = con.prepareStatement("SELECT * FROM horas ORDER BY empleado_legajo");
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				Hora hora = new Hora();
				hora.setIdHora(rs.getInt("id_hora"));
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
		Connection con = DBManager.getInstance().connect();
		Hora hora = null;
		try {
			PreparedStatement sql = con.prepareStatement("SELECT * FROM horas WHERE empleado_legajo=? AND tarea_id=?");
			sql.setInt(1, idEmpleado);
			sql.setInt(2, idTarea);
			
			ResultSet rs = sql.executeQuery();
			
			hora = new Hora();
			System.out.println(rs);
			hora.setCantidad(rs.getInt("cantidad"));
			hora.setLegajoEmpleado(rs.getInt("empleado_legajo"));
			hora.setIdTarea(rs.getInt("tarea_id"));
			
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
		return hora;
	}
	
	private static Date convertUtilToSql(java.util.Date jDate) {
        Date result = new Date(jDate.getTime());
        return result;
    }
	
}
