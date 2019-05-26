package handler;

import bo.EmpleadoBO;
import dao.EmpleadoDaoImpl;
import ui.EmpleadoPanel;
import ui.MiFrame;

public class Handler {
	
	private MiFrame frame;
	private EmpleadoBO empleadoBO;
	
	public Handler() {
		frame = new MiFrame("Empleados v1.0");
		empleadoBO = new EmpleadoBO();
//		empleadoBO.setDAO(new EmpleadoDaoImpl());
	}
	
	public void init() {
		frame.cambiarPanel(new EmpleadoPanel("Panel"));
        frame.setVisible(true);
	}
	
	
}
