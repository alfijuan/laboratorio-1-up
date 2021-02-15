package ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import ui.Handler;
import empresa.Empleado;
public class EmpleadoTable extends TablePanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1878977002724518805L;
	
	public EmpleadoTable(Handler handler, List<Empleado> empleados) {
		super(new EmpleadoTableModel(empleados));
		getVertical().add(agregarBotonera(getTabla(), handler, empleados));
		
	}
	
	public Box agregarBotonera(JTable tabla, Handler handler, List<Empleado> empleados) {
		Box botonera = Box.createHorizontalBox();
		JButton editBtn = new JButton("Editar");
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tabla.getSelectedRow();
				if(index != -1) {
					handler.mostrarEditarEmpleado(empleados.get(index));
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
					handler.calcularCostoEmpleado(empleados.get(index).getLegajo());
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
					if (handler.verificarBorradoDeEmpleado(empleados.get(index).getLegajo())) {
						int input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que queres borrar?", "", JOptionPane.OK_CANCEL_OPTION);
						if(input == 0) {
							handler.mostrarBorrarEmpleado(empleados.get(index).getLegajo());
						}
					} else {
						handler.mostrarModal("No se puede eliminar el empleado porque tiene horas cargadas en el sistema. Por favor esperar al cierre de liquidación.");
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
		
		return botonera;
		
	}


	
	
	
}
