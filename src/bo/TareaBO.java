package bo;

import java.util.List;

import dao.TareaDAO;
import empresa.Tarea;
import exceptions.SystemException;
import exceptions.tarea.TareaAlreadyExists;

public class TareaBO {
	private TareaDAO tareaDAO;
	
	public TareaBO() {};
	
	public void agregarTarea(Tarea tarea) throws SystemException, TareaAlreadyExists{
		if(tareaDAO.obtenerTarea(tarea.getId()) == null) {
			tareaDAO.crearTarea(tarea);
		}else {
			throw new SystemException("Ya existe una tarea con este ID");
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
	
	
	public void setTareaDAO(TareaDAO tareaDAO) {
		this.tareaDAO = tareaDAO;
	};
	
	
}
