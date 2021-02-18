package dao;

import java.util.List;

import empresa.Proyecto;
import exceptions.SystemException;

public interface ProyectoDAO {
	
	List<Proyecto> obtenerProyectos() throws SystemException;
	Proyecto obtenerProyectoById(int id) throws SystemException;
	Proyecto obtenerCostosById(int id) throws SystemException;
	Proyecto obtenerCostosDetalladoById(int id, int mes, int anio) throws SystemException;
}
