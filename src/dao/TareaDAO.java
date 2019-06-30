package dao;

import java.util.List;

import empresa.Tarea;
import exceptions.SystemException;

public interface TareaDAO {
	
	void crearTarea(Tarea tarea) throws SystemException;
	void borrarTarea(int id) throws SystemException;
	void editarTarea(Tarea tarea) throws SystemException;
	Tarea obtenerTarea(int id) throws SystemException;
	List<Tarea> obtenerTareas() throws SystemException;
}
