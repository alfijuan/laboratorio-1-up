package ui;

import javax.swing.*;

import ui.containers.InputContainer;

public class EmpleadoPanel extends JPanel {
	 
    public EmpleadoPanel(String titulo) {
    	initUI(titulo);
    }

    private void initUI(String titulo) {
    	Box vertical = Box.createVerticalBox();
    	
        vertical.add(InputContainer.createHelperBox("Nombre", null, false));
        vertical.add(Box.createVerticalStrut(20));
        vertical.add(InputContainer.createHelperBox("Apellido", null, false));
        vertical.add(Box.createVerticalStrut(20));
        vertical.add(InputContainer.createHelperBox("DNI", null, false));
        vertical.add(Box.createVerticalStrut(20));
        vertical.add(InputContainer.createHelperBox("Legajo", null, false));
        vertical.add(Box.createVerticalStrut(20));
        vertical.add(InputContainer.createHelperBox("Direccion", null, false));
        vertical.add(Box.createVerticalStrut(20));
        vertical.add(InputContainer.createHelperBox("Honorarios", null, false));
        vertical.add(Box.createVerticalStrut(20));
        vertical.add(InputContainer.createHelperBox("Nombre de usuario", null, false));
        vertical.add(Box.createVerticalStrut(20));
        vertical.add(InputContainer.createHelperBox("Password", null, false));
        
        Box botonera = Box.createHorizontalBox();
        botonera.add(Box.createHorizontalGlue());
        botonera.add(new JButton("OK"));
        botonera.add(Box.createHorizontalGlue());
        
        vertical.add(botonera);
        vertical.add(Box.createVerticalStrut(30));
       
        add(vertical);
    }
   
}
