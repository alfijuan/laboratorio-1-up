package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import basico.jdbc.DBManager;
import empresa.Proyecto;
import exceptions.SystemException;

public class ProyectoDaoImpl implements ProyectoDAO{
	
	
	@Override
	public List<Proyecto> obtenerProyectos() throws SystemException {
		List<Proyecto> lista = new ArrayList<Proyecto>();
		Connection con = DBManager.getInstance().connect();
		try {
			PreparedStatement sql = con.prepareStatement("SELECT * FROM proyecto");
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				lista.add(new Proyecto(
						rs.getInt("id_proyecto"),
						rs.getString("nombre")
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

	@Override
	public Proyecto obtenerProyectoById(Integer id) throws SystemException {
		Connection con = DBManager.getInstance().connect();
		Proyecto proyecto = null;
		
		try {
			PreparedStatement sql = con.prepareStatement("SELECT * FROM proyecto where id_proyecto=?");
			sql.setInt(1, id);
			
			ResultSet rs = sql.executeQuery();
			
			if(rs.next()) { 
				proyecto = new Proyecto(
						rs.getInt("id_proyecto"),
						rs.getString("nombre")
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
		
		return proyecto;
	}

	@Override
	public Proyecto obtenerCostosById(Integer id) throws SystemException {
		Connection con = DBManager.getInstance().connect();
		Proyecto proyecto = null;
		
		try {
			PreparedStatement sql = con.prepareStatement("select sum(horas.cantidad * empleado.honorarios) as costo, empleado.legajo, empleado.honorarios \n" + 
															"from tarea \n" + 
															"inner join horas on tarea.id = horas.tarea_id \n" + 
															"inner join empleado on empleado.legajo = horas.empleado_legajo \n" + 
															"where tarea.id_proyecto = ? group by empleado.legajo;");
			sql.setInt(1, id);
			
			ResultSet rs = sql.executeQuery();
			
			if(rs.next()) { 
				Double costo = 0.0;
						
				
				while(rs.next()) {
					costo += rs.getDouble("costo");
				}
				
				System.out.println("COSTO: " + costo);
				proyecto = new Proyecto();
				proyecto.setIdProyecto(id);
				proyecto.setCosto(costo);
				
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
		
		return proyecto;
	}
	
}