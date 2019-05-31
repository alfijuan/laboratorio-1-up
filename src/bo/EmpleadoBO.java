package bo;

import java.util.ArrayList;

import dao.EmpleadoDaoImpl;
import empresa.Empleado;
import exceptions.HorasException;

public class EmpleadoBO {
	private EmpleadoDaoImpl empDao = new EmpleadoDaoImpl();
	
	public EmpleadoBO() {}
	
	public void agregarEmpleado(Empleado emp) throws HorasException {
		if(empDao.obtenerEmpleado(emp.getLegajo()) == null) {
			empDao.crearEmpleado(emp);
		} else {
			System.out.println("Existe");
		}
	}
	
	public ArrayList<Empleado> obtenerEmpleados() throws HorasException {
		return obtenerEmpleados();
	}
	
	public void eliminarEmpleado(int legajo) throws HorasException {
		empDao.eliminarEmpleado(legajo);
	}
	
	public Empleado obtenerEmpleado(int legajo) throws HorasException {
		return empDao.obtenerEmpleado(legajo);
	}
	
	public EmpleadoDaoImpl getEmpDao() {
		return empDao;
	}
	public void setEmpDao(EmpleadoDaoImpl empDao) {
		this.empDao = empDao;
	}
}
