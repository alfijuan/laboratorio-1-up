package ui.table;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel{
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableModel() {
		
	}
	public boolean isCellEditable (int row, int column){
		return false;
	}
   
}
