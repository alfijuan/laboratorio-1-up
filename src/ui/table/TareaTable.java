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
import empresa.Tarea;
import handler.Handler;

public class TareaTable extends JPanel {
	private TableModel modelo = new TableModel();
	private JTable tabla = new JTable(modelo);

	public TareaTable(List<Tarea> lista, Handler handler) {
		this.modelo.addColumn("ID");
		this.modelo.addColumn("Nombre");
		this.modelo.addColumn("Descripcion");
		this.modelo.addColumn("Horas");
		this.modelo.addColumn("Legajo Empleado");

		for (int i = 0; i < lista.size(); i++) {
			this.modelo.addRow(new Object[] { lista.get(i).getId(), lista.get(i).getNombre(),
					lista.get(i).getDescripcion(), lista.get(i).getHoras(), lista.get(i).getLegajoEmpleado() });
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
				if (index != -1) {
					System.out.println("FALTA DESARROLLAR");
					//					handler.mostrarEditarTarea(lista.get(index));
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
				if (index != -1) {
					int input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que queres borrar?", "",
							JOptionPane.OK_CANCEL_OPTION);
					if (input == 0) {
						System.out.println("FALTA DESARROLLAR");
						//						handler.mostrarBorrarTarea(lista.get(index).getId());
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
