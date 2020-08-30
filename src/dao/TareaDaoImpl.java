package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basico.jdbc.DBManager;
import empresa.Tarea;
import exceptions.SystemException;


public class TareaDaoImpl implements TareaDAO{
	
	public void crearTarea(Tarea tarea) throws SystemException{
		
		Connection con = DBManager.getInstance().connect();
		
		try {
			PreparedStatement sql = con.prepareStatement("INSERT INTO tarea (id, nombre, descripcion, id_proyecto)" +
					"VALUES(?,?,?,?)");
			sql.setInt(1, tarea.getId());
			sql.setString(2, tarea.getNombre());
			sql.setString(3, tarea.getDescripcion());
			sql.setInt(4, tarea.getIdProyecto());
			
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
	
	public void editarTarea(Tarea tarea) throws SystemException{
		
		Connection con = DBManager.getInstance().connect();
		
		try {
			PreparedStatement sql = con.prepareStatement("UPDATE tarea SET nombre=?, descripcion=?, id_proyecto=? where id =?");
			
			sql.setString(1, tarea.getNombre());
			sql.setString(2, tarea.getDescripcion());
			sql.setInt(3, tarea.getIdProyecto());
			sql.setInt(4, tarea.getId());
			
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
	
	
	public void borrarTarea(int id) throws SystemException{
		
		Connection con = DBManager.getInstance().connect();
		
		try {
			PreparedStatement sql = con.prepareStatement("DELETE FROM tarea where id =?");
			sql.setInt(1, id);
			
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

	public Tarea obtenerTarea(int id) throws SystemException{
	
		Connection con = DBManager.getInstance().connect();
		Tarea tarea= null;
		
		try {
			PreparedStatement sql = con.prepareStatement("SELECT * FROM tarea where id=?");
			sql.setInt(1, id);
			
			ResultSet rs = sql.executeQuery();
			
			if(rs.next()) { 
				tarea = new Tarea(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("descripcion"),
						rs.getInt("id_proyecto")
				);
			}
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
		
		return tarea;
	}
	
	public List<Tarea> obtenerTareas() throws SystemException {
		List<Tarea> lista = new ArrayList<Tarea>();
		Connection con = DBManager.getInstance().connect();
		try {
			PreparedStatement sql = con.prepareStatement("SELECT * FROM tarea ORDER BY id");
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				lista.add(new Tarea(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("descripcion"),
						rs.getInt("id_proyecto")
				));
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

}
