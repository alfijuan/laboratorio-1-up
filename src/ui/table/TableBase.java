package ui.table;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import handler.Handler;

public abstract class TableBase extends JPanel {

	private static final long serialVersionUID = -5904454874696819147L;
	private TableModel modelo = new TableModel();
	private JTable tabla = new JTable(modelo);
	private Handler handler;
	private TableColumnModel columnModel = tabla.getColumnModel();
	
	public TableBase(Handler handler){
		setHandler(handler);
		createUI();
	}
	
	private void createUI(){
		
		agregarColumnas();
		
		Box vertical = Box.createVerticalBox();
		JScrollPane tableContainer = new JScrollPane(this.tabla);
		vertical.add(tableContainer);
		vertical.add(Box.createVerticalStrut(20));
		
		vertical.add(agregarBotones());
		
		add(vertical);
	}

	public TableModel getModelo() {
		return modelo;
	}

	public void setModelo(TableModel modelo) {
		this.modelo = modelo;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	
	public TableColumnModel getColumnModel() {
		return columnModel;
	}

	public void setColumnModel(TableColumnModel columnModel) {
		this.columnModel = columnModel;
	}

	protected abstract void agregarColumnas();
	
	protected abstract Box agregarBotones();
}
