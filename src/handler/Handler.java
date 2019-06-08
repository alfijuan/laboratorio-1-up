package handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import bo.EmpleadoBO;
import dao.EmpleadoDaoImpl;
import empresa.Empleado;
import exceptions.HorasException;
import exceptions.empleado.EmpleadoNotFoundException;
import ui.EmpleadoPanel;
import ui.MiFrame;
import ui.table.EmpleadoTable;

public class Handler {
	
	private MiFrame frame;
	private EmpleadoBO empleadoBO = new EmpleadoBO();
	
	public Handler() throws Exception {
		frame = new MiFrame("Empleados v1.0", this);
	}
	
	public void init() throws HorasException {
        frame.setVisible(true);
	}
	
	public void mostrarModal(String title) {
		int input = JOptionPane.showOptionDialog(frame, title, "", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, null, null);
		if(input == JOptionPane.OK_OPTION){
			
		}
	}
	
	public void mostrarTablaEmpleado() {
		try {
			frame.cambiarPanel(new EmpleadoTable(this.getEmpleadoBO().obtenerEmpleados(), this));
		} catch (EmpleadoNotFoundException e1) {
			this.mostrarModal("No se pudieron cargar los empleados");
		}
	}
	
	public void mostrarAgregarEmpleado() {
		try {
			frame.cambiarPanel(new EmpleadoPanel(this, "Panel"));
		} catch (Exception e1) {
			this.mostrarModal("No se pudieron cargar los empleados");
		}
	}
	
	public void mostrarEditarEmpleado(Empleado emp) {
		try {
			frame.cambiarPanel(new EmpleadoPanel(this, "Panel", emp));
		} catch (Exception e1) {
			this.mostrarModal("No se pudo abrir la edicion del empleado");
		}
	}
	
	public void mostrarBorrarEmpleado(int legajo) {
		try {
//			frame.cambiarPanel(new EmpleadoPanel(this, "Panel", emp));
			int input = JOptionPane.showConfirmDialog(frame, "¿Estas seguro que queres borrar?", "", JOptionPane.OK_CANCEL_OPTION);
			if(input == 0) {
				this.empleadoBO.eliminarEmpleado(legajo);
				this.mostrarTablaEmpleado();
			}
		} catch (EmpleadoNotFoundException e1) {
			this.mostrarModal("No se encontro el empleado");
		} catch (Exception e1) {
			this.mostrarModal("No se pudo eliminar el empleado");
		}
	}

	public EmpleadoBO getEmpleadoBO() {
		return empleadoBO;
	}

	public void setEmpleadoBO(EmpleadoBO empleadoBO) {
		this.empleadoBO = empleadoBO;
	}
	
	
}
