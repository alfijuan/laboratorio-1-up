package ui.table;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1673138836216830797L;
	private Box vertical;
	
	public TablePanel(JTable tabla) {
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

}
