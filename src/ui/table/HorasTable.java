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
import javax.swing.table.TableColumnModel;
import empresa.Hora;
import handler.Handler;

public class HorasTable extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1104454874696883336L;
	private TableModel modelo = new TableModel();
	private JTable tabla = new JTable(modelo);
	TableColumnModel columnModel = tabla.getColumnModel();
	
	public HorasTable(List<Hora> horas, Handler handler) {
		this.modelo.addColumn("Legajo");
		this.modelo.addColumn("Tarea");
		this.modelo.addColumn("Cantidad");
		this.modelo.addColumn("Fecha");
		
		columnModel.getColumn(0).setPreferredWidth(500);
		columnModel.getColumn(1).setPreferredWidth(500);
		columnModel.getColumn(2).setPreferredWidth(500);
		columnModel.getColumn(3).setPreferredWidth(500);
		
		for(Hora hora : horas) {
			this.modelo.addRow(new Object[] {
				hora.getLegajoEmpleado(),
				hora.getIdTarea(),
				hora.getCantidad(),
				hora.getFecha(),
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
					handler.mostrarEditarHora(horas.get(index));
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
						handler.borrarHora(horas.get(index).getLegajoEmpleado(), horas.get(index).getIdTarea());
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
