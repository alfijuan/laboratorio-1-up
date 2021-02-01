package ui;

import javax.swing.Box;
import javax.swing.JPanel;

public abstract class Base extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 20;
	private Handler handler;
	

	public Base(Handler handler){
		setHandler(handler);
	}
	
	protected abstract void initUI();
	
	protected abstract Object panelToObject();
	
	protected abstract void objectToPanel(Object data);
	
	protected abstract Box agregarBotones();
	
	protected abstract String setTitulo();
	
	protected abstract void limpiarCampos();
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	public int getHeightSpace() {
		return HEIGHT;
	}
}
