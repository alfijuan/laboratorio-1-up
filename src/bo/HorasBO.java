package bo;

import java.util.List;
import dao.HorasDAO;
import empresa.Hora;
import exceptions.SystemException;
import exceptions.horas.HoraNotFoundException;

public class HorasBO {
	private HorasDAO horasDao;
	
	public HorasBO() {}
	
	public void cargarHoras(int idEmpleado, int idTarea, Hora hora) throws SystemException, HoraNotFoundException{
		horasDao.cargarHoras(idEmpleado, idTarea, hora);
	}
	
	public void editarHoras(int idEmpleado, int idTarea, Hora hora) throws SystemException, HoraNotFoundException {
		if(horasDao.obtenerHoraRegistrada(idEmpleado, idTarea) != null) {
			horasDao.editarHoras(idEmpleado, idTarea, hora);
		} else {
			throw new HoraNotFoundException("No existe el registro!");
		}
	}
	
	public List<Hora> obtenerHoras() throws SystemException {
		return horasDao.obtenerHoras();
	}
	
	public void eliminarHoras(int idEmpleado, int idTarea) throws SystemException, HoraNotFoundException {
		if(horasDao.obtenerHoraRegistrada(idEmpleado, idTarea) != null) {
			horasDao.eliminarHoras(idEmpleado, idTarea);
		} else {
			throw new HoraNotFoundException("No existe el registro!");
		}
	}
	
	public void setHorasDao(HorasDAO horasDao) {
		this.horasDao = horasDao;
	}

}
