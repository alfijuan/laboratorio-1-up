package bo;

import java.util.List;

import dao.TareaDAO;
import empresa.Tarea;
import exceptions.SystemException;
import exceptions.tarea.TareaAlreadyExists;
import exceptions.tarea.TareaNotFoundException;

public class TareaBO {
	private TareaDAO tareaDAO;
	
	public TareaBO() {};
	
	public void agregarTarea(Tarea tarea) throws TareaAlreadyExists, SystemException{
		if(tareaDAO.obtenerTarea(tarea.getId()) == null) {
			tareaDAO.crearTarea(tarea);
		}else {
			throw new TareaAlreadyExists("Ya existe una tarea con este ID");
		}
	}
	
	public void editarTarea(Tarea tarea) throws SystemException{
		if(tareaDAO.obtenerTarea(tarea.getId()) != null) {
			tareaDAO.editarTarea(tarea);
		} else {
			throw new SystemException("La tarea no existe!");
		}
	}
	
	public void borrarTarea(int id) throws SystemException{
		if(tareaDAO.obtenerTarea(id) != null) {
			tareaDAO.borrarTarea(id);
		} else {
			throw new SystemException("La tarea no existe!");
		}
	}
	
	public List<Tarea> obtenerTareas() throws SystemException {
		return tareaDAO.obtenerTareas();
	}
	
	public Tarea obtenerTarea(int id) throws SystemException, TareaNotFoundException{
		if(tareaDAO.obtenerTarea(id) != null) {
			return tareaDAO.obtenerTarea(id);
		} else {
			throw new TareaNotFoundException("La tarea no existe!");
		}
	}
	
	public void setTareaDAO(TareaDAO tareaDAO) {
		this.tareaDAO = tareaDAO;
	};
	
	
}
