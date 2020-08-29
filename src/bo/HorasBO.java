package bo;

import java.util.List;
import dao.HorasDAO;
import empresa.Hora;
import exceptions.SystemException;
import exceptions.horas.HoraNotFoundException;

public class HorasBO {
	private HorasDAO horasDao;
	
	public HorasBO() {}
	
	public void cargarHoras(Hora hora) throws SystemException{
		horasDao.cargarHoras(hora);
	}
	
	public void editarHoras(Hora hora) throws SystemException, HoraNotFoundException {
//		if(horasDao.obtenerHoraRegistrada(hora.getLegajoEmpleado(), hora.getIdTarea()) != null) {
			horasDao.editarHoras(hora);
//		} else {
//			throw new HoraNotFoundException("No existe el registro!");
//		}
	}
	
	public List<Hora> obtenerHoras() throws SystemException {
		return horasDao.obtenerHoras();
	}
	
	public void eliminarHoras(Integer idHora) throws SystemException, HoraNotFoundException {
		horasDao.eliminarHoras(idHora);
	}
	
	public void setHorasDao(HorasDAO horasDao) {
		this.horasDao = horasDao;
	}

}
