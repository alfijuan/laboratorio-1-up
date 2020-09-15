package dao;

import java.util.List;

import empresa.Empleado;
import exceptions.SystemException;
import exceptions.empleado.EmpleadoNotFoundException;

public interface EmpleadoDAO {
	
	void crearEmpleado(Empleado empleado) throws SystemException;
	void editarEmpleado(Empleado empleado) throws SystemException, EmpleadoNotFoundException;
	void eliminarEmpleado(int legajo) throws SystemException, EmpleadoNotFoundException;
	Empleado obtenerEmpleado(int legajo) throws SystemException;
	List<Empleado> obtenerEmpleados() throws SystemException;
	Boolean verificarEliminacionEmpleado (int legajo) throws SystemException;
}
