package bo;

import java.util.List;

import dao.TareaDAO;
import empresa.Tarea;
import exceptions.SystemException;
import exceptions.tarea.TareaAlreadyExists;
import exceptions.tarea.TareaNotFoundException;

public class TareaBO {
	private TareaDAO tareaDAO;
	private static final String YA_EXISTE_TAREA = "Ya existe una tarea con este ID";
	private static final String NO_EXISTE_TAREA = "La tarea no existe";
	
	public TareaBO() {};
	
	public void agregarTarea(Tarea tarea) throws SystemException, TareaAlreadyExists{
		if(tareaDAO.obtenerTarea(tarea.getId()) == null) {
			tareaDAO.crearTarea(tarea);
		}else {
			throw new TareaAlreadyExists(YA_EXISTE_TAREA);
		}
	}
	
	public void editarTarea(Tarea tarea) throws SystemException, TareaNotFoundException{
		if(tareaDAO.obtenerTarea(tarea.getId()) != null) {
			tareaDAO.editarTarea(tarea);
		} else {
			throw new TareaNotFoundException(NO_EXISTE_TAREA);
		}
	}
	
	public void borrarTarea(int id) throws SystemException, TareaNotFoundException{
		if(tareaDAO.obtenerTarea(id) != null) {
			tareaDAO.borrarTarea(id);
		} else {
			throw new TareaNotFoundException(NO_EXISTE_TAREA);
		}
	}
	
	public List<Tarea> obtenerTareas()  throws SystemException{
		return tareaDAO.obtenerTareas();
	}
	
	public void setTareaDAO(TareaDAO tareaDAO) {
		this.tareaDAO = tareaDAO;
	};
	
	public Boolean validarEliminacionDeTarea(int id) throws SystemException {
		Boolean resultado = false;
		resultado = tareaDAO.verificarEliminacionTarea(id);
		return resultado;
	}
	
}
