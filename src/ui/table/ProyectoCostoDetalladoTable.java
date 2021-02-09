package ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import empresa.Proyecto;
import ui.Handler;

public class ProyectoCostoDetalladoTable extends TablePanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5904454874696819147L;
	private JLabel nombreProyectoLabel;
	private JLabel costoTotalLabel;
	private JLabel costoTotal;
	
	public ProyectoCostoDetalladoTable(JTable tabla, Proyecto proyecto, Handler handler) {
		super(tabla);
		
		Box nombreProyecto = Box.createHorizontalBox();
		Box inLineCosto = Box.createHorizontalBox();
		
		nombreProyectoLabel = new JLabel("",JLabel.LEFT);
		costoTotalLabel = new JLabel("Costo total: $",JLabel.LEFT);
		costoTotal = new JLabel("",JLabel.LEFT);
		
		nombreProyectoLabel.setText(proyecto.getIdProyecto() + " - " + proyecto.getNombre());

		nombreProyecto.add(nombreProyectoLabel);
		
		costoTotal.setText(String.valueOf(proyecto.getCosto()));
		inLineCosto.add(costoTotalLabel);
		inLineCosto.add(costoTotal);
		
		getVertical().add(nombreProyecto);
		getVertical().add(Box.createVerticalStrut(20));
		
		getVertical().add(inLineCosto);
		getVertical().add(Box.createVerticalStrut(20));
		
		getVertical().add(agregarBotonera(tabla, handler));
	}
	
	public Box agregarBotonera(JTable tabla, Handler handler) {
		
		Box botonera = Box.createHorizontalBox();
		JButton volverBtn = new JButton("Volver");
		
		botonera.add(volverBtn);
		botonera.add(Box.createHorizontalGlue());
		
		volverBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarCostosDetallados();
				
			}
		});
		
		return botonera;
	}
}
