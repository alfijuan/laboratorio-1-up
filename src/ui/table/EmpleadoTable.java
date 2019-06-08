package ui.table;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import empresa.Empleado;
import exceptions.empleado.EmpleadoNotFoundException;
import handler.Handler;

public class EmpleadoTable extends JPanel {
	private TableModel modelo = new TableModel();
	private JTable tabla = new JTable(modelo);

	public EmpleadoTable(ArrayList<Empleado> lista, Handler handler) {
		this.modelo.addColumn("Nombre");
		this.modelo.addColumn("Apellido");
		this.modelo.addColumn("DNI");
		this.modelo.addColumn("Legajo");
		this.modelo.addColumn("Direccion");
		this.modelo.addColumn("Honorarios");
		this.modelo.addColumn("Username");
		this.modelo.addColumn("Password");
		
		for (int i = 0; i < lista.size(); i++) {
			this.modelo.addRow(new Object[] {
				lista.get(i).getNombre(),
				lista.get(i).getApellido(),
				lista.get(i).getDni(),
				lista.get(i).getLegajo(),
				lista.get(i).getDireccion(),
				lista.get(i).getHonorarios(),
				lista.get(i).getNombreUsuario(),
				lista.get(i).getPassword()
			});
		}
		
		Box vertical = Box.createVerticalBox();
		JScrollPane tableContainer = new JScrollPane(this.tabla);
		vertical.add(tableContainer);
		vertical.add(Box.createVerticalStrut(20));
		Box botonera = Box.createHorizontalBox();
		JButton editBtn = new JButton("Editar");
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tabla.getSelectedRow();
				if(index != -1) {
					handler.mostrarEditarEmpleado(lista.get(index));
				} else {
					handler.mostrarModal("Debe seleccionar una fila");
				}
			}
		});
		JButton deleteBtn = new JButton("Borrar");
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tabla.getSelectedRow();
				if(index != -1) {
					handler.mostrarBorrarEmpleado(lista.get(index).getLegajo());
				} else { 
					handler.mostrarModal("Debe seleccionar una fila");
				}
			}
		});
		botonera.add(editBtn);
		botonera.add(Box.createHorizontalGlue());
		botonera.add(deleteBtn);
		vertical.add(botonera);
		add(vertical);
	}
	
}
