package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bo.ProyectoBO;
import dao.ProyectoDaoImpl;
import empresa.Proyecto;
import exceptions.SystemException;

public abstract class ProyectoBase extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8254079957857169917L;
	private static final int HEIGHT = 20; 
	
	private JLabel comboProyectoLabel;
	private JComboBox<String> comboProyecto;
	private List<Proyecto> proyectos;
	
	private Handler handler;
	
	public ProyectoBase(Handler handler){
		setHandler(handler);
		createUI();
	}
	
	private void createUI(){
		Box vertical = Box.createVerticalBox();
		Box inLineProyecto = Box.createHorizontalBox();
        
		proyectos = new ArrayList<Proyecto>();
		setProyectos(obtenerProyectos());
		
		comboProyecto = new JComboBox<String>();
		comboProyecto.addItem("Seleccionar proyecto");
    	for(Proyecto proyecto : proyectos) {
    		comboProyecto.addItem(String.valueOf(proyecto.getIdProyecto() + "-" + proyecto.getNombre()));
    	}
		
    	comboProyectoLabel = new JLabel("Proyectos", JLabel.LEFT);
    	inLineProyecto.add(comboProyectoLabel);
    	inLineProyecto.add(comboProyecto);
    	vertical.add(inLineProyecto);
    	vertical.add(Box.createVerticalStrut(HEIGHT));
    	
        vertical.add(Box.createVerticalStrut(40));
        vertical.add(agregarBotones());
        
        add(vertical);
	}
	
	
	
	protected static List<Proyecto> obtenerProyectos(){
		
		ProyectoBO proyectoBO = new ProyectoBO();
		proyectoBO.setProyectoDao(new ProyectoDaoImpl());
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		try {
			 proyectos = proyectoBO.obtenerProyectos();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		return proyectos;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	

	public JComboBox<String> getComboProyecto() {
		return comboProyecto;
	}

	public void setComboProyecto(JComboBox<String> comboProyecto) {
		this.comboProyecto = comboProyecto;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	protected abstract Box agregarBotones();

}
