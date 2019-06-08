package bo;

import java.util.ArrayList;

import dao.EmpleadoDaoImpl;
import empresa.Empleado;
import exceptions.HorasException;
import exceptions.empleado.EmpleadoAlreadyExists;
import exceptions.empleado.EmpleadoNotFoundException;

public class EmpleadoBO {
	private EmpleadoDaoImpl empDao = new EmpleadoDaoImpl();
	
	public EmpleadoBO() {}
	
	public void agregarEmpleado(Empleado emp) throws EmpleadoNotFoundException, EmpleadoAlreadyExists{
		if(empDao.obtenerEmpleado(emp.getLegajo()) == null) {
			empDao.crearEmpleado(emp);
		} else {
			throw new EmpleadoAlreadyExists();
		}
	}
	
	public void editarEmpleado(Empleado emp) throws EmpleadoNotFoundException {
		if(empDao.obtenerEmpleado(emp.getLegajo()) != null) {
			empDao.editarEmpleado(emp);
		} else {
			System.out.println("No existe el usuario");
		}
	}
	
	public ArrayList<Empleado> obtenerEmpleados() throws EmpleadoNotFoundException {
		return empDao.obtenerEmpleados();
	}
	
	public void eliminarEmpleado(int legajo) throws EmpleadoNotFoundException {
		empDao.eliminarEmpleado(legajo);
	}
	
	public Empleado obtenerEmpleado(int legajo) throws EmpleadoNotFoundException {
		return empDao.obtenerEmpleado(legajo);
	}
	
	public EmpleadoDaoImpl getEmpDao() {
		return empDao;
	}
	public void setEmpDao(EmpleadoDaoImpl empDao) {
		this.empDao = empDao;
	}
}
