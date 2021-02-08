package ui.table;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import empresa.Proyecto;

public class ProyectoCostoDetalladoTable extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5904454874696819147L;
	private JLabel nombreProyectoLabel;
	private JLabel costoTotalLabel;
	private JLabel costoTotal;
	
	public ProyectoCostoDetalladoTable(JTable tabla, Proyecto proyecto) {
		Box vertical = Box.createVerticalBox();
		JScrollPane tableContainer = new JScrollPane(tabla);
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
		
		vertical.add(nombreProyecto);
		vertical.add(Box.createVerticalStrut(20));
		
		vertical.add(tableContainer);
		vertical.add(Box.createVerticalStrut(20));

		vertical.add(inLineCosto);
		vertical.add(Box.createVerticalStrut(20));
		
		add(vertical);
	}
	
	
}
