package ui;

import javax.swing.Box;
import empresa.Tarea;
import handler.Handler;
import ui.containers.InputContainer;

public class TareaPanel extends Panel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2756342206651835302L;
	private Handler handler;
	private InputContainer idField;
	private InputContainer nameField;
	private InputContainer descriptionField;
	private Tarea tarea;
	
	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public TareaPanel(Handler handler, String titulo) {
		this.setHandler(handler);
		altaPanel();
    }
	
	public TareaPanel(Handler handler, String titulo, Tarea tarea) {
		this.setHandler(handler);
    	this.setTarea(tarea);
		modificarPanel();
    }
	
	@Override
	public Box completarCampos(Box vertical, Boolean esEdicion) {    	
    	this.setIdField(new InputContainer("ID", 30));
    	this.setNameField(new InputContainer("Nombre", 30));
		this.setDescriptionField(new InputContainer("Descripcion", 30));
    	
    	
    	vertical.add(esEdicion ? idField.createHelperBox(Integer.toString(this.getTarea().getId()), true): idField.createHelperBox());
        vertical.add(Box.createVerticalStrut(Panel.HEIGHT));
        vertical.add(esEdicion ? nameField.createHelperBox(this.getTarea().getNombre(), false) :nameField.createHelperBox());
        vertical.add(Box.createVerticalStrut(Panel.HEIGHT));
        vertical.add(esEdicion ? descriptionField.createHelperBox(this.getTarea().getDescripcion(), false) : descriptionField.createHelperBox());
        vertical.add(Box.createVerticalStrut(Panel.HEIGHT));
        
		return vertical;
	}
	

	@Override
	public void agregar() {
		Tarea tarea= new Tarea();
		tarea.setId(Integer.parseInt(idField.getField().getText()));
		tarea.setNombre(nameField.getField().getText());
		tarea.setDescripcion(descriptionField.getField().getText());
		handler.agregarTarea(tarea);
	}
	
	@Override
	public void modificar() {
		tarea.setNombre(nameField.getField().getText());
		tarea.setDescripcion(descriptionField.getField().getText());
		handler.editarTarea(tarea);
	}
	
    	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public InputContainer getIdField() {
		return idField;
	}

	public void setIdField(InputContainer idField) {
		this.idField = idField;
	}

	public InputContainer getNameField() {
		return nameField;
	}

	public void setNameField(InputContainer nameField) {
		this.nameField = nameField;
	}

	public InputContainer getDescriptionField() {
		return descriptionField;
	}

	public void setDescriptionField(InputContainer descriptionField) {
		this.descriptionField = descriptionField;
	}

}
