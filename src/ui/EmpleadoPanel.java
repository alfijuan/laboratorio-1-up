package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import empresa.Empleado;
import exceptions.empleado.EmpleadoNotFoundException;
import handler.Handler;
import ui.containers.InputContainer;

public class EmpleadoPanel extends JPanel {
	 
    private Handler handler;
    private Empleado current;

	public EmpleadoPanel(Handler handler, String titulo) {
    	this.setHandler(handler);
		initUI(titulo);
    }
	
	public EmpleadoPanel(Handler handler, String titulo, Empleado emp) {
    	this.setHandler(handler);
    	this.setEmpleado(emp);
		initUI(titulo);
    }
    
    private void initUI(String titulo) {
    	Box vertical = Box.createVerticalBox();
    	
    	InputContainer nameField = new InputContainer("Nombre", 30);
    	InputContainer lastNameField = new InputContainer("Apellido", 30);
    	InputContainer dniField = new InputContainer("DNI", 30);
    	InputContainer legajoField = new InputContainer("Legajo", 30);
    	InputContainer direccionField = new InputContainer("Direccion", 30);
    	InputContainer honorariosField = new InputContainer("Honorarios", 30);
    	InputContainer userField = new InputContainer("Nombre de usuario", 30);
    	InputContainer passField = new InputContainer("Password", 30);
    	
    	if(this.getEmpleado() != null) {
    		vertical.add(nameField.createHelperBox(this.getEmpleado().getNombre(), false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(lastNameField.createHelperBox(this.getEmpleado().getApellido(), false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(dniField.createHelperBox(Integer.toString(this.getEmpleado().getDni()), true));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(legajoField.createHelperBox(Integer.toString(this.getEmpleado().getLegajo()), true));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(direccionField.createHelperBox(this.getEmpleado().getDireccion(), false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(honorariosField.createHelperBox(Float.toString(this.getEmpleado().getHonorarios()), false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(userField.createHelperBox(this.getEmpleado().getNombreUsuario(), false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(passField.createHelperBox(this.getEmpleado().getPassword(), false));
    	} else {
            vertical.add(nameField.createHelperBox());
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(lastNameField.createHelperBox());
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(dniField.createHelperBox());
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(legajoField.createHelperBox());
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(direccionField.createHelperBox());
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(honorariosField.createHelperBox());
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(userField.createHelperBox());
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(passField.createHelperBox());
    	}
        
        Box botonera = Box.createHorizontalBox();
        botonera.add(Box.createHorizontalGlue());
        JButton OKBtn = new JButton("OK");
        OKBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	        	if(current != null) {
	        		current.setNombre(nameField.getField().getText());
	        		current.setApellido(lastNameField.getField().getText());
	        		current.setDireccion(direccionField.getField().getText());
	        		current.setHonorarios(Float.parseFloat(honorariosField.getField().getText()));
	        		current.setNombreUsuario(userField.getField().getText());
	        		current.setPassword(passField.getField().getText());
	        		handler.editarEmpleado(current);
	        	} else {
	        		Empleado empleado = new Empleado(
    					nameField.getField().getText(),
    					lastNameField.getField().getText(),
    					Integer.parseInt(dniField.getField().getText()),
    					Integer.parseInt(legajoField.getField().getText()),
    					direccionField.getField().getText(),
    					Float.parseFloat(honorariosField.getField().getText()),
    					userField.getField().getText(),
    					passField.getField().getText()
    				);
    				handler.agregarEmpleado(empleado);
	        	}
			}
		});
        
        JButton SalirBtn = new JButton("Volver");
        SalirBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarTablaEmpleado();
			}
		});
        
        botonera.add(OKBtn);
        botonera.add(Box.createHorizontalGlue());
        
        botonera.add(SalirBtn);
        botonera.add(Box.createHorizontalGlue());
        vertical.add(botonera);
        vertical.add(Box.createVerticalStrut(30));
        
        add(vertical);
    }

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	public Empleado getEmpleado() {
		return current;
	}

	public void setEmpleado(Empleado emp) {
		this.current = emp;
	}
    
   
}
