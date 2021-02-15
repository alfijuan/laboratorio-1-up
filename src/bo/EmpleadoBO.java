package bo;

import java.util.ArrayList;
import java.util.List;

import dao.EmpleadoDAO;
import empresa.Empleado;
import exceptions.SystemException;
import exceptions.empleado.EmpleadoAlreadyExists;
import exceptions.empleado.EmpleadoNotFoundException;

public class EmpleadoBO {
	private EmpleadoDAO empDao;
	private static final String ERROR_EMPLEADO_YA_EXISTE = "Ya existe un empleado con el dni ingresado";
	private static final String ERROR_EMPLEADO_NO_EXISTE = "El empleado no existe";
	
	public EmpleadoBO() {}
	
	public void agregarEmpleado(Empleado emp) throws SystemException, EmpleadoAlreadyExists{
		if(empDao.obtenerEmpleado(emp.getDni()) == null) {
			empDao.crearEmpleado(emp);
		} else {
			throw new EmpleadoAlreadyExists(ERROR_EMPLEADO_YA_EXISTE);
		}
	}
	
	public void editarEmpleado(Empleado emp) throws SystemException, EmpleadoNotFoundException {
		if(empDao.obtenerEmpleado(emp.getLegajo()) != null) {
			empDao.editarEmpleado(emp);
		} else {
			throw new EmpleadoNotFoundException(ERROR_EMPLEADO_NO_EXISTE);
		}
	}
	
	public void eliminarEmpleado(int legajo) throws SystemException, EmpleadoNotFoundException {
		if(empDao.obtenerEmpleado(legajo) != null) {
			empDao.eliminarEmpleado(legajo);
		} else {
			throw new EmpleadoNotFoundException(ERROR_EMPLEADO_NO_EXISTE);
		}
	}
	
	public List<Empleado> obtenerEmpleados() throws SystemException {
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados = empDao.obtenerEmpleados(); 
		return empleados;
	}
	
	public Empleado obtenerEmpleado(int legajo) throws SystemException {
		Empleado empleado = new Empleado();
		empleado = empDao.obtenerEmpleado(legajo);
		return empleado;
	}
	
	public Boolean validarEliminacionDeEmpleado(int legajo) throws SystemException {
		Boolean resultado = false;
		resultado = empDao.verificarEliminacionEmpleado(legajo);
		return resultado;
	}
	
	public void setEmpDao(EmpleadoDAO empDao) {
		this.empDao = empDao;
	}

}
