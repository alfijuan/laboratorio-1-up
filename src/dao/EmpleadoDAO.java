package dao;

import java.util.ArrayList;

import empresa.Empleado;
import exceptions.HorasException;
import exceptions.empleado.EmpleadoAlreadyExists;
import exceptions.empleado.EmpleadoNotFoundException;

public interface EmpleadoDAO {
	
	boolean crearEmpleado(Empleado empleado);
	boolean editarEmpleado(Empleado empleado) throws EmpleadoNotFoundException;
	boolean eliminarEmpleado(int legajo) throws EmpleadoNotFoundException;
	Empleado obtenerEmpleado(int legajo) throws EmpleadoNotFoundException;
	ArrayList<Empleado> obtenerEmpleados() throws EmpleadoNotFoundException;
}
