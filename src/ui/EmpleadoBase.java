package ui;

import javax.swing.Box;
import javax.swing.JLabel;

import empresa.Empleado;
import ui.containers.InputContainer;

public abstract class EmpleadoBase extends Base {
	
	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private InputContainer nombre;
	private InputContainer apellido;
	private InputContainer direccion;
	private InputContainer dni;
	private InputContainer legajo;
	private InputContainer honorarios;
	
	public EmpleadoBase(Handler handler) {
		super(handler);
		initUI();
	}
	
	@Override
	protected void initUI(){
		Box vertical = Box.createVerticalBox();
		
		titulo = new JLabel(setTitulo(), JLabel.LEFT);
		nombre = new InputContainer("Nombre", 30);
		apellido = new InputContainer("Apellido", 30);
		direccion = new InputContainer("Direccion", 30);
		dni = new InputContainer("DNI", 8);
        honorarios = new InputContainer("Honorarios", 8);
        
        vertical.add(titulo);
        vertical.add(Box.createVerticalStrut(getHeight()));
        
        vertical.add(nombre.createHelperBox());
        vertical.add(Box.createVerticalStrut(getHeight()));
        
        vertical.add(apellido.createHelperBox());
        vertical.add(Box.createVerticalStrut(getHeight()));
        
        vertical.add(dni.createHelperBox());
        vertical.add(Box.createVerticalStrut(getHeight()));
        
        vertical.add(direccion.createHelperBox());
        vertical.add(Box.createVerticalStrut(getHeight()));
        
        vertical.add(honorarios.createHelperBox());
        vertical.add(Box.createVerticalStrut(getHeight()));
        
        vertical.add(Box.createVerticalStrut(40));
        vertical.add(agregarBotones());
        
        add(vertical);
	}
	
	@Override
	public Empleado panelToObject() {
		Empleado empleado = new Empleado();
		empleado.setDni(Integer.parseInt(getDni().getField().getText()));
		empleado.setNombre(getNombre().getField().getText());
		empleado.setApellido(getApellido().getField().getText());
		empleado.setDireccion(getDireccion().getField().getText());
		empleado.setHonorarios(Float.parseFloat(getHonorarios().getField().getText()));
		return empleado;
	}
	
	@Override
	public void objectToPanel(Object data) { 
		Empleado empleado = (Empleado) data;
		getNombre().getField().setText(empleado.getNombre());
		getApellido().getField().setText(empleado.getApellido());
		getDni().getField().setText(Integer.toString(empleado.getDni()));
		getDni().getField().setEnabled(false);
		getDireccion().getField().setText(empleado.getDireccion());
		getHonorarios().getField().setText(Float.toString(empleado.getHonorarios()));
	}
	
	
	public InputContainer getNombre() {
		return nombre;
	}

	public void setNombre(InputContainer nombre) {
		this.nombre = nombre;
	}

	public InputContainer getDni() {
		return dni;
	}

	public void setDni(InputContainer dni) {
		this.dni = dni;
	}

	public InputContainer getLegajo() {
		return legajo;
	}

	public void setLegajo(InputContainer legajo) {
		this.legajo = legajo;
	}

	public InputContainer getHonorarios() {
		return honorarios;
	}

	public void setHonorarios(InputContainer honorarios) {
		this.honorarios = honorarios;
	}

	public InputContainer getApellido() {
		return apellido;
	}

	public void setApellido(InputContainer apellido) {
		this.apellido = apellido;
	}
	
	public InputContainer getDireccion() {
		return direccion;
	}

	public void setDireccion(InputContainer direccion) {
		this.direccion = direccion;
	}
}
