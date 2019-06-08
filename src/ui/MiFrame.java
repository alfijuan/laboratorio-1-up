package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import handler.Handler;

public class MiFrame extends JFrame{
	public MiFrame(String titulo, Handler handler) {
		super(titulo);
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		mb.add(menu);
		JMenuItem item1 = new JMenuItem("Listar");
		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarTablaEmpleado();
			}
		});
        menu.add(item1);
        JMenuItem item2 = new JMenuItem("Agregar");
        item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarAgregarEmpleado();
			}
		});
        menu.add(item2);
        setJMenuBar(mb);
		initUI();
	}
	
	private void initUI() {
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void cambiarPanel(JPanel panel){
		getContentPane().removeAll();
		getContentPane().add(panel);
		getContentPane().validate();
	}

}
