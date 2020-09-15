package bo;

import java.util.List;

import dao.TareaDAO;
import empresa.Tarea;
import exceptions.SystemException;
import exceptions.tarea.TareaAlreadyExists;
import exceptions.tarea.TareaNotFoundException;

public class TareaBO {
	private TareaDAO tareaDAO;
	private static final String GENERIC_ERROR_BD = "Ocurrió un error inesperado. Por favor intente más tarde";
	private static final String YA_EXISTE_TAREA = "Ya existe una tarea con este ID";
	private static final String NO_EXISTE_TAREA = "La tarea no existe";
	
	public TareaBO() {};
	
	public void agregarTarea(Tarea tarea) throws SystemException, TareaAlreadyExists{
		if(tareaDAO.obtenerTarea(tarea.getId()) == null) {
			try{
				tareaDAO.crearTarea(tarea);
			}catch (SystemException e) {
				e.printStackTrace();
				throw new SystemException(GENERIC_ERROR_BD);
			}
		}else {
			throw new TareaAlreadyExists(YA_EXISTE_TAREA);
		}
	}
	
	public void editarTarea(Tarea tarea) throws SystemException, TareaNotFoundException{
		if(tareaDAO.obtenerTarea(tarea.getId()) != null) {
			try{
				tareaDAO.editarTarea(tarea);
			}catch (SystemException e) {
				e.printStackTrace();
				throw new SystemException(GENERIC_ERROR_BD);
			}
		} else {
			throw new TareaNotFoundException(NO_EXISTE_TAREA);
		}
	}
	
	public void borrarTarea(int id) throws SystemException, TareaNotFoundException{
		if(tareaDAO.obtenerTarea(id) != null) {
			try{
				tareaDAO.borrarTarea(id);
			}catch (SystemException e) {
				e.printStackTrace();
				throw new SystemException(GENERIC_ERROR_BD);
			}
		} else {
			throw new TareaNotFoundException(NO_EXISTE_TAREA);
		}
	}
	
	public List<Tarea> obtenerTareas()  throws SystemException{
		try {
			return tareaDAO.obtenerTareas();
		} catch (SystemException e) {
			e.printStackTrace();
			throw new SystemException(GENERIC_ERROR_BD);
		}
	}
	
	public Tarea obtenerTarea(int id) throws SystemException{
		Tarea tarea = new Tarea();
		try {
			tarea = tareaDAO.obtenerTarea(id);
		} catch (SystemException e) {
			e.printStackTrace();
			throw new SystemException(GENERIC_ERROR_BD);
		}
		return tarea;
	}
	
	public void setTareaDAO(TareaDAO tareaDAO) {
		this.tareaDAO = tareaDAO;
	};
	
	
}
