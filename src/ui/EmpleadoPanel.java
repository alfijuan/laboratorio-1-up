package ui;

import javax.swing.Box;
import empresa.Empleado;
import handler.Handler;
import ui.containers.InputContainer;

public class EmpleadoPanel extends Panel {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = -148160877678071549L;
	private Handler handler;
    private InputContainer nameField;
    private InputContainer lastNameField;
    private InputContainer dniField;
    private InputContainer direccionField;
    private InputContainer honorariosField;
    private InputContainer userField;
    private InputContainer passField;
    private Empleado empleado;
    
	public EmpleadoPanel(Handler handler, String titulo) {
    	this.setHandler(handler);
		altaPanel();
    }
	
	public EmpleadoPanel(Handler handler, String titulo, Empleado emp) {
    	this.setHandler(handler);
    	this.setEmpleado(emp);
		modificarPanel();
    }
    
	@Override
	public Box completarCampos(Box vertical, Boolean esEdicion) {    	
    	this.setNameField(new InputContainer("Nombre", 30));
    	this.setLastNameField(new InputContainer("Apellido", 30));
		this.setDniField(new InputContainer("DNI", 8));
    	this.setDireccionField(new InputContainer("Direccion", 30));
    	this.setHonorariosField(new InputContainer("Honorarios", 8));
    	this.setUserField(new InputContainer("Nombre de usuario", 30));
    	this.setPassField(new InputContainer("Password", 30));
    	
    	vertical.add(esEdicion ? nameField.createHelperBox(this.getEmpleado().getNombre(), false): nameField.createHelperBox());
        vertical.add(Box.createVerticalStrut(Panel.HEIGHT));
        vertical.add(esEdicion ? lastNameField.createHelperBox(this.getEmpleado().getApellido(), false) :lastNameField.createHelperBox());
        vertical.add(Box.createVerticalStrut(Panel.HEIGHT));
        vertical.add(esEdicion ? dniField.createHelperBox(Integer.toString(this.getEmpleado().getDni()), true) : dniField.createHelperBox());
        vertical.add(Box.createVerticalStrut(Panel.HEIGHT));
        vertical.add(esEdicion ? direccionField.createHelperBox(this.getEmpleado().getDireccion(), false): direccionField.createHelperBox());
        vertical.add(Box.createVerticalStrut(Panel.HEIGHT));
        vertical.add(esEdicion ? honorariosField.createHelperBox(Float.toString(this.getEmpleado().getHonorarios()), false) : honorariosField.createHelperBox());
        vertical.add(Box.createVerticalStrut(Panel.HEIGHT));
        vertical.add(esEdicion ? userField.createHelperBox(this.getEmpleado().getNombreUsuario(), false) : userField.createHelperBox());
        vertical.add(Box.createVerticalStrut(Panel.HEIGHT));
        vertical.add(esEdicion ? passField.createHelperBox(this.getEmpleado().getPassword(), false) : passField.createHelperBox());
		return vertical;
	}
	

	@Override
	public void agregar() {
		Empleado empleado = new Empleado();
		empleado.setDni(Integer.parseInt(dniField.getField().getText()));
		empleado.setNombre(nameField.getField().getText());
		empleado.setApellido(lastNameField.getField().getText());
		empleado.setDireccion(direccionField.getField().getText());
		empleado.setHonorarios(Float.parseFloat(honorariosField.getField().getText()));
		empleado.setNombreUsuario(userField.getField().getText());
		empleado.setPassword(passField.getField().getText());
		handler.agregarEmpleado(empleado);
		
	}
	
	@Override
	public void modificar() {
		empleado.setNombre(nameField.getField().getText());
		empleado.setApellido(lastNameField.getField().getText());
		empleado.setDireccion(direccionField.getField().getText());
		empleado.setHonorarios(Float.parseFloat(honorariosField.getField().getText()));
		empleado.setNombreUsuario(userField.getField().getText());
		empleado.setPassword(passField.getField().getText());
		handler.editarEmpleado(empleado);
		
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	public InputContainer getNameField() {
		return nameField;
	}

	public void setNameField(InputContainer nameField) {
		this.nameField = nameField;
	}

	public InputContainer getLastNameField() {
		return lastNameField;
	}

	public void setLastNameField(InputContainer lastNameField) {
		this.lastNameField = lastNameField;
	}

	public InputContainer getDniField() {
		return dniField;
	}

	public void setDniField(InputContainer dniField) {
		this.dniField = dniField;
	}

	public InputContainer getDireccionField() {
		return direccionField;
	}

	public void setDireccionField(InputContainer direccionField) {
		this.direccionField = direccionField;
	}

	public InputContainer getHonorariosField() {
		return honorariosField;
	}

	public void setHonorariosField(InputContainer honorariosField) {
		this.honorariosField = honorariosField;
	}

	public InputContainer getUserField() {
		return userField;
	}

	public void setUserField(InputContainer userField) {
		this.userField = userField;
	}

	public InputContainer getPassField() {
		return passField;
	}

	public void setPassField(InputContainer passField) {
		this.passField = passField;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
