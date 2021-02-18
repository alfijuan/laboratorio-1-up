package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import basico.jdbc.DBManager;
import empresa.Empleado;
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
			}
			throw new SystemException("Error en la base de datos al obtener los proyectos");
		} finally {
			try {
				con.close();
			} catch (SQLException e1) {
			}
		}
		return lista;
	}

	@Override
	public Proyecto obtenerProyectoById(int id) throws SystemException {
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
			throw new SystemException("Error en la base de datos al obtener el proyecto");
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
	public Proyecto obtenerCostosById(int id) throws SystemException {
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
			
			Double costo = 0.0;
					
			while(rs.next()) {
				costo += rs.getDouble("costo");
			}
			
			proyecto = new Proyecto();
			proyecto.setIdProyecto(id);
			proyecto.setCosto(costo);
				
		}catch (SQLException e) {
			try {
				con.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SystemException("Error en la base de datos al intentar calcular el costo del proyecto");
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
	public Proyecto obtenerCostosDetalladoById(int idProyecto, int mes, int anio) throws SystemException {
		Proyecto proyecto = new Proyecto();
		Connection con = DBManager.getInstance().connect();
		String dateFrom = String.valueOf(anio) + "-" + String.valueOf(mes) + "-01";
		String dateTo = String.valueOf(anio) + "-" + String.valueOf(mes) + "-31";

		try {
			PreparedStatement sql = con.prepareStatement("select sum(horas.cantidad * empleado.honorarios) as costo, empleado.legajo, empleado.honorarios, tarea.id_proyecto, proyecto.nombre from tarea inner join horas on tarea.id = horas.tarea_id inner join empleado on empleado.legajo = horas.empleado_legajo inner join proyecto on proyecto.id_proyecto = tarea.id_proyecto where proyecto.id_proyecto = ? and (horas.fecha >= '2020-08-01' and horas.fecha <= '2020-08-31') group by empleado.legajo, tarea.id_proyecto, proyecto.nombre order by tarea.id_proyecto;");
			sql.setInt(1, idProyecto);
			sql.setString(2, dateFrom);
			sql.setString(3, dateTo);
			
			ResultSet rs = sql.executeQuery();
			if(rs.isBeforeFirst()) {
				List<Empleado> empleados = null;
				int proyectoActual = 0;
				rs.next();
				while(!rs.isAfterLast()) {
					proyecto = new Proyecto();
					proyectoActual = rs.getInt("id_proyecto");
					proyecto.setIdProyecto(rs.getInt("id_proyecto"));
					proyecto.setNombre(rs.getString("nombre"));
					empleados = new ArrayList<Empleado>();
					Double costoTotal = 0.0;
					
					while(!rs.isAfterLast() && proyectoActual == rs.getInt("id_proyecto")) {
						Empleado empleado = new Empleado();
						empleado.setLegajo(rs.getInt("legajo"));
						empleado.setHonorarios(rs.getInt("costo"));
						costoTotal += rs.getInt("costo");
						empleados.add(empleado);
						rs.next();
					}
					proyecto.setCosto(costoTotal);
					proyecto.setEmpleados(empleados);
					
				}
			} else {
				throw new SystemException("No existe información para los parámetros seleccionados.");
			}
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
			throw new SystemException("Error en la base de datos al intentar calcular el costo de los proyectos.");
		} finally {
			try {
				con.close();
			} catch (SQLException e1) {
			}
		}
		return proyecto;
	}
	
	
	
}
