package ui;

import javax.swing.Box;
import javax.swing.JPanel;

import handler.Handler;
import ui.containers.InputContainer;

public abstract class EmpleadoBase extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 20; 
	private InputContainer nombre;
	private InputContainer dni;
	private InputContainer legajo;
	private InputContainer honorarios;
	private InputContainer user;
	private InputContainer pass;
	private Handler handler;
	
	public EmpleadoBase(Handler handler){
		setHandler(handler);
		createUI();
	}
	
	private void createUI(){
		Box vertical = Box.createVerticalBox();
		
		nombre = new InputContainer("Nombre", 30);
		vertical.add(nombre.createHelperBox());
		vertical.add(Box.createVerticalStrut(HEIGHT));
        
		dni = new InputContainer("DNI", 8);
		vertical.add(dni.createHelperBox());
        vertical.add(Box.createVerticalStrut(HEIGHT));
        
        honorarios = new InputContainer("Honorarios", 8);
        vertical.add(honorarios.createHelperBox());
        vertical.add(Box.createVerticalStrut(HEIGHT));
        
        user = new InputContainer("Nombre de usuario", 30);
        vertical.add(user.createHelperBox());
        vertical.add(Box.createVerticalStrut(HEIGHT));
        
        pass = new InputContainer("Password", 30);
        vertical.add(pass.createHelperBox());
        
        
        vertical.add(Box.createVerticalStrut(40));
        vertical.add(agregarBotones());
        
        add(vertical);
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
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

	public InputContainer getUser() {
		return user;
	}

	public void setUser(InputContainer user) {
		this.user = user;
	}

	public InputContainer getPass() {
		return pass;
	}

	public void setPass(InputContainer pass) {
		this.pass = pass;
	}

	protected abstract Box agregarBotones();

}
