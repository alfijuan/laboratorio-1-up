package dao;

import empresa.Empleado;
import exceptions.HorasException;

public interface EmpleadoDAO {
	
	void crearEmpleado(Empleado empleado) throws HorasException;
	void eliminarEmpleado(int legajo) throws HorasException;
	void mostrarEmpleado(int legajo) throws HorasException;
}
