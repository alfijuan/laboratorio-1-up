package dao;

import java.util.List;

import empresa.Tarea;
import exceptions.SystemException;
import exceptions.tarea.TareaAlreadyExists;
import exceptions.tarea.TareaNotFoundException;

public interface TareaDAO {
	
	void crearTarea(Tarea tarea) throws SystemException, TareaAlreadyExists;
	void borrarTarea(int id) throws SystemException, TareaNotFoundException;
	void editarTarea(Tarea tarea) throws SystemException, TareaNotFoundException;
	Tarea obtenerTarea(int id) throws SystemException;
	List<Tarea> obtenerTareas() throws SystemException;
	Boolean verificarEliminacionTarea(int id) throws SystemException;
}
