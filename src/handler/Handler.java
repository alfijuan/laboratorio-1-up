package handler;

import bo.EmpleadoBO;
import dao.EmpleadoDaoImpl;
import ui.EmpleadoPanel;
import ui.MiFrame;

public class Handler {
	
	private MiFrame frame;
	private EmpleadoBO empleadoBO = new EmpleadoBO();
	
	public Handler() {
		frame = new MiFrame("Empleados v1.0");
//		empleadoBO.setDAO(new EmpleadoDaoImpl());
	}
	
	public void init() {
		frame.cambiarPanel(new EmpleadoPanel(this, "Panel"));
        frame.setVisible(true);
	}

	public EmpleadoBO getEmpleadoBO() {
		return empleadoBO;
	}

	public void setEmpleadoBO(EmpleadoBO empleadoBO) {
		this.empleadoBO = empleadoBO;
	}
	
	
}
