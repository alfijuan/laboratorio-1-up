package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import handler.Handler;
import ui.containers.SalirListener;

public class MiFrame extends JFrame{
	
	public MiFrame(String titulo) {
		super(titulo);
		initUI();
	}
	
	public void initMenu(Handler handler) {
		JMenuBar mb = new JMenuBar();
		JMenu menuEmpleados = new JMenu("Empleados");
		JMenu menuTareas = new JMenu("Tareas");
		JMenu menuArchivo = new JMenu("Archivo");
		mb.add(menuArchivo);
		mb.add(menuEmpleados);
		mb.add(menuTareas);
		
		
		JMenuItem item1Empleados = new JMenuItem("Listar");
		item1Empleados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarTablaEmpleado();
			}
		});
        menuEmpleados.add(item1Empleados);
        JMenuItem item2Empleados = new JMenuItem("Agregar");
        item2Empleados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarAgregarEmpleado();
			}
		});
        menuEmpleados.add(item2Empleados);
        
        JMenuItem item1Tareas = new JMenuItem("Listar");
        item1Tareas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarTablaTarea();
			}
		});
        menuTareas.add(item1Tareas);
        JMenuItem item2Tareas = new JMenuItem("Agregar");
        item2Tareas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarAgregarTarea();
			}
		});
        menuTareas.add(item2Tareas);
        
        JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(new SalirListener() {
		});
        menuArchivo.add(salir);
		
        setJMenuBar(mb);
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
