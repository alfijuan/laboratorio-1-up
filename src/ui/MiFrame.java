package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiFrame extends JFrame{
	
	public MiFrame(String titulo) {
		super(titulo);
		initUI();
	}
	
	private void initUI() {
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void cambiarPanel(JPanel panel){
		getContentPane().removeAll();
		getContentPane().add(panel);
		getContentPane().validate();
	}

}
