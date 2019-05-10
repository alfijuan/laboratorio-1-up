package dao;

import empresa.Tarea;
import exceptions.HorasException;

public interface TareaDAO {
	
	void crearEmpleado(Tarea empleado) throws HorasException;
	void eliminarEmpleado(int id) throws HorasException;
	void mostrarEmpleado(int id) throws HorasException;
}
