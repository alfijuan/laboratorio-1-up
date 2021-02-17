package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import empresa.User;
import ui.containers.InputContainer;
import ui.containers.SalirListener;

public class Login extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 20; 
	private InputContainer user;
	private JPasswordField pass;
	private JLabel passLabel;
	private JLabel titulo;
	
	private Handler handler;
	
	public Login(Handler handler){
		setHandler(handler);
		createUI();
	}
	
	private void createUI(){
		Box vertical = Box.createVerticalBox();
		titulo = new JLabel(setTitulo(), JLabel.LEFT);
		passLabel = new JLabel("Password ",JLabel.LEFT);
		
		Box inLinePass = Box.createHorizontalBox();
		
		user = new InputContainer("User", 30);
		pass = new JPasswordField("", 30);
        
		vertical.add(titulo);
		vertical.add(Box.createVerticalStrut(HEIGHT));
		
        vertical.add(user.createHelperBox());
        vertical.add(Box.createVerticalStrut(HEIGHT));
        
        inLinePass.add(passLabel);
        inLinePass.add(pass);
        vertical.add(inLinePass);
        
        vertical.add(Box.createVerticalStrut(40));
        vertical.add(agregarBotones());
        
        add(vertical);
	}
	
	protected Box agregarBotones() {
		Box botonera = Box.createHorizontalBox();
		JButton OKBtn = new JButton("Login");
        JButton SalirBtn = new JButton("Salir");
        
        botonera.add(SalirBtn);
        botonera.add(Box.createHorizontalGlue());
        
        botonera.add(OKBtn);
        botonera.add(Box.createHorizontalGlue());
        
        SalirBtn.addActionListener(new SalirListener() {
		});
		
		OKBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
        		User user = new User(getUser().getField().getText(), String.valueOf(getPass().getPassword()));
				getHandler().loginUsuario(user);
				limpiarDatosLogin();
			}
		});
		return botonera;
	}
	
	private void limpiarDatosLogin() {
		user.cleanTextField();
		pass.setText("");
	};

	protected String setTitulo() {
		return "Login";
	};
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public InputContainer getUser() {
		return user;
	}

	public void setUser(InputContainer user) {
		this.user = user;
	}

	public void setPass(JPasswordField pass) {
		this.pass = pass;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JPasswordField getPass() {
		return pass;
	}

}
