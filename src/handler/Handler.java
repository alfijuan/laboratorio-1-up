package handler;

import javax.swing.JOptionPane;

import bo.EmpleadoBO;
import dao.EmpleadoDaoImpl;
import empresa.Empleado;
import exceptions.SystemException;
import exceptions.empleado.EmpleadoAlreadyExists;
import exceptions.empleado.EmpleadoNotFoundException;
import ui.EmpleadoPanel;
import ui.Login;
import ui.MiFrame;
import ui.table.EmpleadoTable;

public class Handler {
	
	private MiFrame frame;
	private EmpleadoBO empleadoBO;
	
	public Handler() {
		empleadoBO = new EmpleadoBO();
		empleadoBO.setEmpDao(new EmpleadoDaoImpl());
		
		frame = new MiFrame("v1.0");
	}
	
	public void init() {
        frame.setVisible(true);
        frame.cambiarPanel(new Login(this, "Login"));      
	}
	
	public void mostrarModal(String title) {
		JOptionPane.showOptionDialog(null, title, "", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, null, null);
	}
	
	public void mostrarTablaEmpleado() {
		try {
			frame.cambiarPanel(new EmpleadoTable(this.getEmpleadoBO().obtenerEmpleados(), this));
		} catch (SystemException e1) {
			this.mostrarModal(e1.getMessage());
		}
	}
	
	public void mostrarAgregarEmpleado() {
		frame.cambiarPanel(new EmpleadoPanel(this, "Panel"));
	}
	
	public void mostrarEditarEmpleado(Empleado emp) {
		frame.cambiarPanel(new EmpleadoPanel(this, "Panel", emp));
	}
	
	public void mostrarBorrarEmpleado(int legajo) {
		try {
			this.empleadoBO.eliminarEmpleado(legajo);
			mostrarModal("Empleado borrado correctamente!");
			this.mostrarTablaEmpleado();
		} catch (EmpleadoNotFoundException e1) {
			this.mostrarModal(e1.getMessage());
		} catch (SystemException e1) {
			this.mostrarModal(e1.getMessage());
		}
	}

	public void agregarEmpleado(Empleado empleado) {
		try {
			empleadoBO.agregarEmpleado(empleado);
			mostrarModal("Empleado agregado correctamente!");
			mostrarTablaEmpleado();
		} catch (EmpleadoAlreadyExists e1) {
			mostrarModal(e1.getMessage());
		} catch (SystemException e1) {
			mostrarModal(e1.getMessage());
		} catch (EmpleadoNotFoundException e1) {
			mostrarModal(e1.getMessage());
		}
	}
	
	public void editarEmpleado(Empleado empleado) {
		try {
			getEmpleadoBO().editarEmpleado(empleado);
			mostrarModal("Empleado editado correctamente!");
			mostrarTablaEmpleado();
		} catch (EmpleadoNotFoundException e1) {
			mostrarModal(e1.getMessage());
		} catch (SystemException e1) {
			mostrarModal(e1.getMessage());
		}
	}
	
	public EmpleadoBO getEmpleadoBO() {
		return empleadoBO;
	}

	public void setEmpleadoBO(EmpleadoBO empleadoBO) {
		this.empleadoBO = empleadoBO;
	}
	
	public MiFrame getFrame() {
		return frame;
	}
	
	
}
