package ui.table;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public abstract class TablePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1673138836216830797L;
	private Box vertical;
	private JTable tabla;
	
	public TablePanel(TableModel tableModel) {
		tabla = new JTable(tableModel);
		
		setVertical(Box.createVerticalBox());
		JScrollPane tableContainer = new JScrollPane(tabla);
		vertical.add(tableContainer);
		vertical.add(Box.createVerticalStrut(20));
		
		add(vertical);
	}

	public Box getVertical() {
		return vertical;
	}

	public void setVertical(Box vertical) {
		this.vertical = vertical;
	}

	public JTable getTabla() {
		return tabla;
	}

}
