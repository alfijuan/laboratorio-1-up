package bo;

import java.util.List;

import dao.ProyectoDAO;
import empresa.Proyecto;
import exceptions.SystemException;

public class ProyectoBO {
	private ProyectoDAO proyectoDao;
	
	public ProyectoBO() {}
	
	
	public List<Proyecto> obtenerProyectos() throws SystemException {
		return proyectoDao.obtenerProyectos();
	}
	
	public Proyecto obtenerProyectoById(Integer id) throws SystemException {
		return proyectoDao.obtenerProyectoById(id);
	}
	
	public Proyecto obtenerCostosById(Integer id) throws SystemException {
		return proyectoDao.obtenerCostosById(id);
	}
	
	public void setProyectoDao(ProyectoDAO proyectoDao) {
		this.proyectoDao = proyectoDao;
	}

}
