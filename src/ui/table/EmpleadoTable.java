package ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import empresa.Empleado;
import handler.Handler;

public class EmpleadoTable extends JPanel {
	private TableModel modelo = new TableModel();
	private JTable tabla = new JTable(modelo);

	public EmpleadoTable(List<Empleado> lista, Handler handler) {
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
					int input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que queres borrar?", "", JOptionPane.OK_CANCEL_OPTION);
					if(input == 0) {
						handler.mostrarBorrarEmpleado(lista.get(index).getLegajo());
					}
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
