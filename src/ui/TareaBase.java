package ui;

import javax.swing.Box;
import javax.swing.JPanel;

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
	
	public TareaBase(Handler handler){
		setHandler(handler);
		createUI();
	}
	
	private void createUI(){
		Box vertical = Box.createVerticalBox();
		
		id = new InputContainer("ID", 30);
		vertical.add(id.createHelperBox());
		vertical.add(Box.createVerticalStrut(HEIGHT));
		
		nombre = new InputContainer("Nombre", 30);
		vertical.add(nombre.createHelperBox());
		vertical.add(Box.createVerticalStrut(HEIGHT));
		
		description = new InputContainer("Descripcion", 30);
		vertical.add(description.createHelperBox());
		vertical.add(Box.createVerticalStrut(HEIGHT));
		
		idProyecto = new InputContainer("ID Proyecto", 30);
		vertical.add(idProyecto.createHelperBox());
		
		
		vertical.add(Box.createVerticalStrut(40));
		vertical.add(agregarBotones());
        
        add(vertical);
		
	}

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
	
	protected abstract Box agregarBotones();
	
	
	
}
