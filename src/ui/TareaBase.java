package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bo.EmpleadoBO;
import bo.ProyectoBO;
import dao.EmpleadoDaoImpl;
import dao.ProyectoDaoImpl;
import empresa.Empleado;
import empresa.Proyecto;
import exceptions.SystemException;
import handler.Handler;
import ui.containers.InputContainer;

public abstract class TareaBase extends JPanel{
	
	private static final long serialVersionUID = 2756342206651835302L;
	private static final int HEIGHT = 20; 
	private Handler handler;
	
	private InputContainer id;
	private InputContainer nombre;
	private InputContainer description;
	private InputContainer idProyecto;
	private JLabel comboProyectoLabel;
	private JComboBox<String> comboProyecto;
	private List<Proyecto> proyectos;
	
	private void createUI(){
		Box vertical = Box.createVerticalBox();
		Box inLineProyecto = Box.createHorizontalBox();
		
		id = new InputContainer("ID", 30);
		vertical.add(id.createHelperBox());
		vertical.add(Box.createVerticalStrut(HEIGHT));
		
		nombre = new InputContainer("Nombre", 30);
		vertical.add(nombre.createHelperBox());
		vertical.add(Box.createVerticalStrut(HEIGHT));
		
		description = new InputContainer("Descripcion", 30);
		vertical.add(description.createHelperBox());
		vertical.add(Box.createVerticalStrut(HEIGHT));
		
		
		proyectos = new ArrayList<Proyecto>();
		setProyectos(ProyectoBase.obtenerProyectos());
		
		comboProyecto = new JComboBox<String>();
		comboProyecto.addItem("Seleccionar proyecto");
    	for(Proyecto proyecto : proyectos) {
    		comboProyecto.addItem(String.valueOf(proyecto.getIdProyecto() + "-" + proyecto.getNombre()));
    	}
		
    	comboProyectoLabel = new JLabel("Proyectos", JLabel.LEFT);
    	inLineProyecto.add(comboProyectoLabel);
    	inLineProyecto.add(comboProyecto);
    	vertical.add(inLineProyecto);
		
		vertical.add(Box.createVerticalStrut(40));
		vertical.add(agregarBotones());
        
        add(vertical);
		
	}
	
	protected abstract Box agregarBotones();
	
	public InputContainer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(InputContainer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public InputContainer getId() {
		return id;
	}

	public void setId(InputContainer id) {
		this.id = id;
	}

	public InputContainer getNombre() {
		return nombre;
	}

	public void setNombre(InputContainer nombre) {
		this.nombre = nombre;
	}

	public InputContainer getDescription() {
		return description;
	}

	public void setDescription(InputContainer description) {
		this.description = description;
	}

	public JLabel getComboProyectoLabel() {
		return comboProyectoLabel;
	}

	public void setComboProyectoLabel(JLabel comboProyectoLabel) {
		this.comboProyectoLabel = comboProyectoLabel;
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

	public TareaBase(Handler handler){
		setHandler(handler);
		createUI();
	}
	
}
