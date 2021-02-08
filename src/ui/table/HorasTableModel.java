package ui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import empresa.Hora;

public class HorasTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8674074612139872520L;

	private final static int Legajo = 0;
	private final static int Tareas = 1;
	private final static int Cantidad = 2;
	private final static int Fecha = 3;
	
	private List <Hora> horas;

	private String[] headers = {"Legajo","Tareas", "Cantidad", "Fecha"};

	
	public HorasTableModel(List<Hora> horas){
		this.horas = horas;
	}
	
	public int getRowCount(){
		return horas.size();
		}
	
	public int getColumnCount(){
		return headers.length;
	}
	
	public String getColumnName(int column){
		return headers[column];
	}
	
	public Object getValueAt(int row, int column) {
		Hora hora = horas.get(row);
	
		switch(column){
		
			case Legajo: 
				return hora.getLegajoEmpleado();
			case Tareas: 
				return hora.getIdTarea();
			case Cantidad:
				return hora.getCantidad();
			case Fecha:
				return hora.getFecha();
		}
		return null;
	}
	
	public List<Hora> getHoras() {
		return horas;
	}

	public void setHoras(List<Hora> horas) {
		this.horas = horas;
	}

	public String[] getHeaders() {
		return headers;
	}

}
