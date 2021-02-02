package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ui.containers.SalirListener;

public class MiFrame extends FrameBase {

	private static final long serialVersionUID = -221347292852008772L;

	public MiFrame(Handler handler) {
		super(handler);
		initUI();
		JMenuBar menuBar = new JMenuBar();
		agregarFuncionesMenu(menuBar);
		setJMenuBar(menuBar);
	}
	
	public void initUI() {
		setSize(800, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void agregarFuncionesMenu(JMenuBar menuBar) {
		JMenu menuEmpleados = new JMenu("Empleados");
		JMenu menuTareas = new JMenu("Tareas");
		JMenu menuArchivo = new JMenu("Archivo");
		JMenu menuHoras = new JMenu("Horas");
		JMenu menuProyecto = new JMenu("Proyecto");
		menuBar.add(menuArchivo);
		menuBar.add(menuEmpleados);
		menuBar.add(menuTareas);
		menuBar.add(menuHoras);
		menuBar.add(menuProyecto);
		
		
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
		
        JMenuItem item1Horas = new JMenuItem("Listar todas las horas");
        item1Horas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarTablaHoras();
			}
		});
        menuHoras.add(item1Horas);
        
        JMenuItem item2Horas = new JMenuItem("Cargar horas");
        item2Horas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarCargarHoras();
			}
		});
        menuHoras.add(item2Horas);
        
        JMenuItem item1Proyecto = new JMenuItem("Calcular Costo");
        item1Proyecto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarCostoProyecto();
			}
		});
        menuProyecto.add(item1Proyecto);
        
        JMenuItem item2Proyecto = new JMenuItem("Calcular Costo Detallado");
        item2Proyecto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarCostosDetallados();
			}
		});
        menuProyecto.add(item2Proyecto);
		
	}
	
	@Override
	protected String setTitulo() {
		return "Mi frame";
	}

}
