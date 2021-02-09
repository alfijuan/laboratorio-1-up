package bo;

import java.util.ArrayList;
import java.util.List;

import dao.ProyectoDAO;
import empresa.Proyecto;
import exceptions.SystemException;
import exceptions.proyecto.ProyectoNotFoundException;

public class ProyectoBO {
	private ProyectoDAO proyectoDao;
	private static final String GENERIC_ERROR_BD = "Ocurrió un error inesperado. Por favor intente más tarde";
	private static final String ERROR_PROYECTO_NO_EXISTE = "El proyecto no existe";
	
	public ProyectoBO() {}
	
	
	public List<Proyecto> obtenerProyectos() throws SystemException {
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		proyectos = proyectoDao.obtenerProyectos();
		return proyectos;
	}
	
	public Proyecto obtenerProyectoById(int id) throws SystemException {
		Proyecto proyecto = new Proyecto();
		try {
			proyecto = proyectoDao.obtenerProyectoById(id);
		}catch (SystemException e) {
			e.printStackTrace();
			throw new SystemException(GENERIC_ERROR_BD);
		}
		return proyecto;
		
	}
	
	public Proyecto obtenerCostosById(int id) throws SystemException, ProyectoNotFoundException {
		Proyecto proyecto = new Proyecto();
		if(proyectoDao.obtenerProyectoById(id) != null) {
				proyecto = proyectoDao.obtenerCostosById(id);
		} else {
			throw new ProyectoNotFoundException(ERROR_PROYECTO_NO_EXISTE);
		}
		return proyecto;
	}
	
	public Proyecto obtenerCostosProyectosById(int idProyecto) throws SystemException{
		Proyecto proyecto = new Proyecto();
		try {
			proyecto = proyectoDao.obtenerCostosDetalladoById(idProyecto);
		}catch (SystemException e) {
			e.printStackTrace();
			throw new SystemException(e.getMessage());
		}
		return proyecto;
	}
	
	public void setProyectoDao(ProyectoDAO proyectoDao) {
		this.proyectoDao = proyectoDao;
	}

}
