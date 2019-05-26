package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import empresa.Empleado;
import ui.containers.InputContainer;
import ui.containers.SalirListener;

public class EmpleadoPanel extends JPanel {
	 
    public EmpleadoPanel(String titulo) {
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
        
        Box botonera = Box.createHorizontalBox();
        botonera.add(Box.createHorizontalGlue());
        JButton OKBtn = new JButton("OK");
        OKBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("nombre: " + nameField.getField().getText() + "\n" +
								   "apellido: " + lastNameField.getField().getText() + "\n" +
								   "dni: " + dniField.getField().getText() + "\n" +
								   "legajo: " + legajoField.getField().getText() + "\n" +
								   "direccion: " + direccionField.getField().getText() + "\n" +
								   "honorarios: " + honorariosField.getField().getText() + "\n" +
								   "username: " + userField.getField().getText() + "\n" +
								   "pass: " + passField.getField().getText() + "\n"
				);
				
			}
		});
        
        JButton SalirBtn = new JButton("Salir");
        SalirBtn.addActionListener(new SalirListener());
        
        
        botonera.add(OKBtn);
        botonera.add(Box.createHorizontalGlue());
        vertical.add(botonera);
        vertical.add(Box.createVerticalStrut(30));
       
        botonera.add(SalirBtn);
        botonera.add(Box.createHorizontalGlue());
        
        add(vertical);
    }
    
   
}
