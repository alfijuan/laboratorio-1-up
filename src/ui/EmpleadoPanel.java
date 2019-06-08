package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import empresa.Empleado;
import exceptions.HorasException;
import exceptions.empleado.EmpleadoAlreadyExists;
import exceptions.empleado.EmpleadoNotFoundException;
import handler.Handler;
import ui.containers.InputContainer;
import ui.containers.SalirListener;

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
            vertical.add(nameField.createHelperBox(null, false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(lastNameField.createHelperBox(null, false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(dniField.createHelperBox(null, false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(legajoField.createHelperBox(null, false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(direccionField.createHelperBox(null, false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(honorariosField.createHelperBox(null, false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(userField.createHelperBox(null, false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(passField.createHelperBox(null, false));
    	}
        
        Box botonera = Box.createHorizontalBox();
        botonera.add(Box.createHorizontalGlue());
        JButton OKBtn = new JButton("OK");
        Handler handler = this.getHandler();
        Empleado parentEmp = this.getEmpleado();
        OKBtn.addActionListener(new ActionListener() {
//        	Validar desde el front los textos

			@Override
			public void actionPerformed(ActionEvent e) {
	        	ArrayList<InputContainer> list = new ArrayList<InputContainer>();
	        	if(parentEmp != null) {
	        		parentEmp.setNombre(nameField.getField().getText());
	        		parentEmp.setApellido(lastNameField.getField().getText());
	        		parentEmp.setDireccion(direccionField.getField().getText());
	        		parentEmp.setHonorarios(Float.parseFloat(honorariosField.getField().getText()));
	        		parentEmp.setNombreUsuario(userField.getField().getText());
	        		parentEmp.setPassword(passField.getField().getText());
	        		try {
    					handler.getEmpleadoBO().editarEmpleado(parentEmp);
    					handler.mostrarModal("Empleado editado correctamente!");
    					handler.mostrarTablaEmpleado();
    				} catch (EmpleadoNotFoundException e1) {
    					handler.mostrarModal("Ha ocurrido un error...");
    				}
	        	} else {
	        		Empleado emp = new Empleado(
    					nameField.getField().getText(),
    					lastNameField.getField().getText(),
    					Integer.parseInt(dniField.getField().getText()),
    					Integer.parseInt(legajoField.getField().getText()),
    					direccionField.getField().getText(),
    					Float.parseFloat(honorariosField.getField().getText()),
    					userField.getField().getText(),
    					passField.getField().getText()
    				);
    				try {
    					handler.getEmpleadoBO().agregarEmpleado(emp);
    					handler.mostrarModal("Empleado agregado correctamente!");
    					handler.mostrarTablaEmpleado();
    				} catch (EmpleadoAlreadyExists e1) {
    					handler.mostrarModal("El empleado ya existe!");
    				} catch (EmpleadoNotFoundException e1) {
    					handler.mostrarModal("Ha ocurrido un error...");
    				}
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
