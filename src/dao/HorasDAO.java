package dao;

import java.util.List;

import empresa.Hora;
import exceptions.SystemException;
import exceptions.horas.HoraNotFoundException;

public interface HorasDAO {
	
	void cargarHoras(Hora hora) throws SystemException;
	void eliminarHoras(Integer idHora) throws SystemException;
	void editarHoras(Hora hora) throws SystemException, HoraNotFoundException;
	Hora obtenerHoraRegistrada(int idEmpleado, int idTarea)throws SystemException;
	List<Hora> obtenerHoras() throws SystemException;
	List<Hora> obtenerHorasMes(int idEmpleado, int idTarea, int mes) throws SystemException;
}
