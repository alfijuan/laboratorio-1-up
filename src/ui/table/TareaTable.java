package ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import empresa.Tarea;
import ui.Handler;

public class TareaTable extends TablePanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9132454869629348612L;

	
	public TareaTable(Handler handler, List<Tarea> tareas) {
		super(new TareaTableModel(tareas));
		getVertical().add(agregarBotonera(getTabla(), handler, tareas));
		
	}
	
	public Box agregarBotonera(JTable tabla, Handler handler, List<Tarea> tareas) {
		Box botonera = Box.createHorizontalBox();
		JButton editBtn = new JButton("Editar");
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tabla.getSelectedRow();
				if (index != -1) {
					handler.mostrarEditarTarea(tareas.get(index));
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
					if (handler.verificarBorradoDeTarea(tareas.get(index).getId())) {
						int input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que queres borrar?", "",
								JOptionPane.OK_CANCEL_OPTION);
						if (input == 0) {
							handler.borrarTarea(tareas.get(index).getId());
						}
					} else {
						handler.mostrarModal("No se puede eliminar la tarea porque tiene horas asociadas");
					}
				} else {
					handler.mostrarModal("Debe seleccionar una fila");
				}
			}
		});
		botonera.add(editBtn);
		botonera.add(Box.createHorizontalGlue());
		botonera.add(deleteBtn);
		
		return botonera;
		
	}
}
