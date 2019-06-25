package bo;

import java.util.List;

import dao.TareaDAO;
import empresa.Tarea;
import exceptions.SystemException;

public class TareaBO {
	private TareaDAO tareaDAO;
	
	public TareaBO() {};
	
	public void agregarTarea(Tarea tarea) throws SystemException{
		if(tareaDAO.obtenerTarea(tarea.getId()) == null) {
			tareaDAO.crearTarea(tarea);
		}else {
			throw new SystemException("Ya existe una tarea con este ID");
		}
	}
	
	public List<Tarea> obtenerTareas() throws SystemException {
		return tareaDAO.obtenerTareas();
	}
	
	
	public void setTareaDAO(TareaDAO tareaDAO) {
		this.tareaDAO = tareaDAO;
	};
	
	
}
