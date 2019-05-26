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
    
    private JTextField textField;
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
        JButton OKBtn = new JButton("OK");
        OKBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//aca iria el alta de empleado.
				
				String text = textField.getText();
				System.out.println(text);
				
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
