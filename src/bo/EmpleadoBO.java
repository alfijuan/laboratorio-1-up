package bo;

import java.util.List;

import dao.EmpleadoDAO;
import empresa.Empleado;
import exceptions.SystemException;
import exceptions.empleado.EmpleadoAlreadyExists;
import exceptions.empleado.EmpleadoNotFoundException;

public class EmpleadoBO {
	private EmpleadoDAO empDao;
	
	public EmpleadoBO() {}
	
	public void agregarEmpleado(Empleado emp) throws SystemException, EmpleadoAlreadyExists{
		if(empDao.obtenerEmpleado(emp.getLegajo()) == null) {
			empDao.crearEmpleado(emp);
		} else {
			throw new EmpleadoAlreadyExists("El empleado ya existe!");
		}
	}
	
	public void editarEmpleado(Empleado emp) throws SystemException, EmpleadoNotFoundException {
		if(empDao.obtenerEmpleado(emp.getLegajo()) != null) {
			empDao.editarEmpleado(emp);
		} else {
			throw new EmpleadoNotFoundException("El empleado no existe!");
		}
	}
	
	public void eliminarEmpleado(int legajo) throws SystemException, EmpleadoNotFoundException {
		if(empDao.obtenerEmpleado(legajo) != null) {
			empDao.eliminarEmpleado(legajo);
		} else {
			throw new EmpleadoNotFoundException("El empleado no existe!");
		}
	}
	
	public List<Empleado> obtenerEmpleados() throws SystemException {
		return empDao.obtenerEmpleados();
	}
	
	public Empleado obtenerEmpleado(int legajo) throws SystemException {
		return empDao.obtenerEmpleado(legajo);
	}
	
	public void setEmpDao(EmpleadoDAO empDao) {
		this.empDao = empDao;
	}

}
