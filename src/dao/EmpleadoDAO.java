package dao;

import empresa.Empleado;
import exceptions.HorasException;

public interface EmpleadoDAO {
	
	boolean crearEmpleado(Empleado empleado) throws HorasException;
	boolean eliminarEmpleado(int legajo) throws HorasException;
	Empleado obtenerEmpleado(int legajo) throws HorasException;
}
