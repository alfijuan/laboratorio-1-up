package bo;

import java.util.List;

import dao.ProyectoDAO;
import empresa.Proyecto;
import exceptions.SystemException;
import exceptions.proyecto.ProyectoNotFoundException;

public class ProyectoBO {
	private ProyectoDAO proyectoDao;
	
	public ProyectoBO() {}
	
	
	public List<Proyecto> obtenerProyectos() throws SystemException {
		return proyectoDao.obtenerProyectos();
	}
	
	public Proyecto obtenerProyectoById(int id) throws SystemException {
		return proyectoDao.obtenerProyectoById(id);
	}
	
	public Proyecto obtenerCostosById(int id) throws SystemException, ProyectoNotFoundException {
		if(proyectoDao.obtenerProyectoById(id) != null) {
			return proyectoDao.obtenerCostosById(id);
		} else {
			throw new ProyectoNotFoundException("El proyecto no existe!");
		}
	}
	
	public void setProyectoDao(ProyectoDAO proyectoDao) {
		this.proyectoDao = proyectoDao;
	}

}
