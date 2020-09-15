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
	private static final String GENERIC_ERROR_BD = "Ocurrió un error inesperado. Por favor intente más tarde";
	private static final String ERROR_EMPLEADO_YA_EXISTE = "El empleado ya existe";
	private static final String ERROR_EMPLEADO_NO_EXISTE = "El empleado no existe";
	
	public EmpleadoBO() {}
	
	public void agregarEmpleado(Empleado emp) throws SystemException, EmpleadoAlreadyExists{
		if(empDao.obtenerEmpleado(emp.getLegajo()) == null) {
			try {
				empDao.crearEmpleado(emp);
			}catch (SystemException e) {
				e.printStackTrace();
				throw new SystemException(GENERIC_ERROR_BD);
			}
		} else {
			throw new EmpleadoAlreadyExists(ERROR_EMPLEADO_YA_EXISTE);
		}
	}
	
	public void editarEmpleado(Empleado emp) throws SystemException, EmpleadoNotFoundException {
		if(empDao.obtenerEmpleado(emp.getLegajo()) != null) {
			try {
				empDao.editarEmpleado(emp);
			}catch (SystemException e) {
				e.printStackTrace();
				throw new SystemException(GENERIC_ERROR_BD);
			}
		} else {
			throw new EmpleadoNotFoundException(ERROR_EMPLEADO_NO_EXISTE);
		}
	}
	
	public void eliminarEmpleado(int legajo) throws SystemException, EmpleadoNotFoundException {
		if(empDao.obtenerEmpleado(legajo) != null) {
			try {
				empDao.eliminarEmpleado(legajo);
			}catch (SystemException e) {
				e.printStackTrace();
				throw new SystemException(GENERIC_ERROR_BD);
			}
		} else {
			throw new EmpleadoNotFoundException(ERROR_EMPLEADO_NO_EXISTE);
		}
	}
	
	public List<Empleado> obtenerEmpleados() throws SystemException {
		List<Empleado> empleados = new ArrayList<Empleado>();
		try {
			empleados = empDao.obtenerEmpleados(); 
		}catch (SystemException e) {
			e.printStackTrace();
			throw new SystemException(GENERIC_ERROR_BD);
		}
		return empleados;
	}
	
	public Empleado obtenerEmpleado(int legajo) throws SystemException {
		Empleado empleado = new Empleado();
		try {
			empleado = empDao.obtenerEmpleado(legajo);
		}catch (SystemException e) {
			e.printStackTrace();
			throw new SystemException(GENERIC_ERROR_BD);
		}
		return empleado;
	}
	
	public Boolean validarEliminacionDeEmpleado(int legajo) throws SystemException {
		Boolean resultado = false;
		try {
			resultado = empDao.verificarEliminacionEmpleado(legajo);
		} catch (SystemException e) {
			e.printStackTrace();
			throw new SystemException(GENERIC_ERROR_BD);
		}
		return resultado;
	}
	
	public void setEmpDao(EmpleadoDAO empDao) {
		this.empDao = empDao;
	}

}
