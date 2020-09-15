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

import empresa.Empleado;
import ui.Handler;

public class EmpleadoTable extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5904454874696819147L;
	private TableModel modelo = new TableModel();
	private JTable tabla = new JTable(modelo);
	TableColumnModel columnModel = tabla.getColumnModel();
	
	public EmpleadoTable(List<Empleado> lista, Handler handler) {
		this.modelo.addColumn("Legajo");
		this.modelo.addColumn("Nombre");
		this.modelo.addColumn("Apellido");
		this.modelo.addColumn("DNI");
		this.modelo.addColumn("Direccion");
		this.modelo.addColumn("Honorarios");
		
		columnModel.getColumn(0).setPreferredWidth(500);
		columnModel.getColumn(1).setPreferredWidth(500);
		columnModel.getColumn(2).setPreferredWidth(500);
		columnModel.getColumn(3).setPreferredWidth(500);
		columnModel.getColumn(4).setPreferredWidth(500);
		columnModel.getColumn(5).setPreferredWidth(500);
		
		for(Empleado empleado : lista) {
			this.modelo.addRow(new Object[] {
				empleado.getLegajo(),
				empleado.getNombre(),
				empleado.getApellido(),
				empleado.getDni(),
				empleado.getDireccion(),
				empleado.getHonorarios(),
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
		JButton calculateBtn = new JButton("Cierre");
		calculateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tabla.getSelectedRow();
				if(index != -1) {
					// Get legajo
					handler.calcularCostoEmpleado(lista.get(index).getLegajo());
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
		botonera.add(calculateBtn);
		botonera.add(Box.createHorizontalGlue());
		botonera.add(deleteBtn);
		vertical.add(botonera);
		add(vertical);
	}
	
}
