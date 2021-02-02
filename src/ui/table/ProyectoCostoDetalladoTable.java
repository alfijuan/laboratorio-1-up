package ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import empresa.Empleado;
import empresa.Proyecto;
import ui.Handler;

public class ProyectoCostoDetalladoTable extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5904454874696819147L;
	private TableModel modelo = new TableModel();
	private JTable tabla = new JTable(modelo);
	TableColumnModel columnModel = tabla.getColumnModel();
	
	public ProyectoCostoDetalladoTable(Proyecto proyecto, Handler handler) {
		this.modelo.addColumn("Id Proyecto");
		this.modelo.addColumn("Nombre Proyecto");
		this.modelo.addColumn("Empleado");
		this.modelo.addColumn("Costo");
		
		columnModel.getColumn(0).setPreferredWidth(500);
		columnModel.getColumn(1).setPreferredWidth(500);
		columnModel.getColumn(2).setPreferredWidth(500);
		columnModel.getColumn(3).setPreferredWidth(500);
		
		this.modelo.addRow(new Object[] {
			proyecto.getIdProyecto(),
			proyecto.getNombre(),
			null,
			null
		});
		for(Empleado emp : proyecto.getEmpleados()) {
			this.modelo.addRow(new Object[] {
					null,
					null,
					emp.getLegajo(),
					"$ " + emp.getHonorarios()
				});
		}
		this.modelo.addRow(new Object[] {
				null,
				null,
				"Total",
				"$ " + proyecto.getCosto()
		});
			
		Box vertical = Box.createVerticalBox();
		JScrollPane tableContainer = new JScrollPane(this.tabla);
		vertical.add(tableContainer);
		vertical.add(Box.createVerticalStrut(20));
		
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
        
        vertical.add(botonera);
        
        add(vertical);
	}
	
	
}
