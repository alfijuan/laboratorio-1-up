package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import empresa.Empleado;
import handler.Handler;
import ui.containers.InputContainer;

public class Login extends JPanel {
	 
    private Handler handler;

	public Login(Handler handler, String titulo) {
    	this.setHandler(handler);
		initUI(titulo);
    }
    
    private void initUI(String titulo) {
    	Box vertical = Box.createVerticalBox();
    	
    	InputContainer usernameField = new InputContainer("Usuario", 30);
    	InputContainer passwordField = new InputContainer("Password", 30);
        vertical.add(usernameField.createHelperBox());
        vertical.add(Box.createVerticalStrut(20));
        vertical.add(passwordField.createHelperBox());
        vertical.add(Box.createVerticalStrut(20));
        
        Box botonera = Box.createHorizontalBox();
        botonera.add(Box.createHorizontalGlue());
        JButton OKBtn = new JButton("Conectarse");
        OKBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				handler.getFrame().initMenu(handler);
				System.out.println("login");
			}
		});
        
        botonera.add(OKBtn);
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
    
   
}
