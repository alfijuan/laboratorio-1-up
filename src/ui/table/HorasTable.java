package ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import empresa.Hora;
import ui.Handler;

public class HorasTable extends TablePanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1104454874696883336L;
	
	public HorasTable(Handler handler, List<Hora> horas) {
		super(new HorasTableModel(horas));
		getVertical().add(agregarBotonera(getTabla(), handler, horas));
		
	}
	
	public Box agregarBotonera(JTable tabla, Handler handler, List<Hora> horas) {
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
						handler.borrarHora(horas.get(index).getIdHora());
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
