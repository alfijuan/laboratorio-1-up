package dao;

import java.util.List;

import empresa.Proyecto;
import exceptions.SystemException;

public interface ProyectoDAO {
	
	List<Proyecto> obtenerProyectos() throws SystemException;
	Proyecto obtenerProyectoById(Integer id) throws SystemException;
	Proyecto obtenerCostosById(Integer id) throws SystemException;
}
