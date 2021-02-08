package ui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import empresa.Empleado;
import empresa.Proyecto;
public class ProyectoCostoDetalladoTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9074074612139172520L;

	private final static int LegajoEmpleado = 0;
	private final static int Costo = 1;
	
	private Proyecto proyecto;
	private List<Empleado> empleados;
	
	private String[] headers = {"Legajo empleado", "Costo"};
	
	public ProyectoCostoDetalladoTableModel(Proyecto proyecto){
		this.proyecto = proyecto;
		this.empleados = proyecto.getEmpleados();
	}
	
	public int getRowCount(){
		return empleados.size();
		}
	
	public int getColumnCount(){
		return headers.length;
	}
	
	public String getColumnName(int column){
		return headers[column];
	}
	
	public Object getValueAt(int row, int column) {
		Empleado empleados = proyecto.getEmpleados().get(row);
		
		switch(column){
			case LegajoEmpleado:
				return empleados.getLegajo();
			case Costo:
				return empleados.getHonorarios();
		}
		return null;
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public String[] getHeaders() {
		return headers;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

}
