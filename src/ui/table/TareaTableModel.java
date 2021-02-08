package ui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import empresa.Tarea;

public class TareaTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9074074612139172520L;

	private final static int ID = 0;
	private final static int Nombre = 1;
	private final static int Descripcion = 2;
	private final static int Proyecto = 3;
	
	private List <Tarea> tareas;

	private String[] headers = {"ID","Nombre", "Descripcion", "Proyecto"};

	
	public TareaTableModel(List<Tarea> tareas){
		this.tareas = tareas;
	}
	
	public int getRowCount(){
		return tareas.size();
		}
	
	public int getColumnCount(){
		return headers.length;
	}
	
	public String getColumnName(int column){
		return headers[column];
	}
	
	public Object getValueAt(int row, int column) {
		Tarea tarea = tareas.get(row);
	
		switch(column){
		
			case ID: 
				return tarea.getId();
			case Nombre: 
				return tarea.getNombre();
			case Descripcion:
				return tarea.getDescripcion();
			case Proyecto:
				return tarea.getIdProyecto();
		}
		return null;
	}
	

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public String[] getHeaders() {
		return headers;
	}

}
