package dao;

import java.util.List;

import empresa.Hora;
import exceptions.SystemException;
import exceptions.horas.HoraNotFoundException;

public interface HorasDAO {
	
	void cargarHoras(int idEmpleado, int idTarea, Hora hora) throws SystemException;
	void eliminarHoras(int idEmpleado, int idTarea) throws SystemException;
	void editarHoras(int idEmpleado, int idTarea, Hora hora) throws SystemException, HoraNotFoundException;
	Hora obtenerHoraRegistrada(int idEmpleado, int idTarea)throws SystemException;
	List<Hora> obtenerHoras() throws SystemException;
	List<Integer> obtenerHoras(int legajo) throws SystemException;
	List<Hora> obtenerHorasMes(int idEmpleado, int idTarea, int mes) throws SystemException;
}
