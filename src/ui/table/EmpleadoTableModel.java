package ui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import empresa.Empleado;

public class EmpleadoTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8674074612139872520L;

	private List <Empleado> empleados;

	private String[] headers = {"Legajo","Nombre", "Apellido", "DNI", "Direccion", "Honorarios"};

	private final static int Legajo = 0;
	private final static int Nombre = 1;
	private final static int Apellido = 2;
	private final static int DNI = 3;
	private final static int Direccion = 4;
	private final static int Honorarios = 5;
	
	
	public EmpleadoTableModel(List<Empleado> empleados){
		this.empleados = empleados;
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
	
	
	public Object getValueAt(int row, int column){
		Empleado empleado = empleados.get(row);
		
		switch(column){
		
			case Legajo: 
				return empleado.getLegajo();
			case Nombre: 
				return empleado.getNombre();
			case Apellido:
				return empleado.getApellido();
			case Direccion:
				return empleado.getDireccion();
			case DNI:
				return empleado.getDni();
			case Honorarios:
				return empleado.getHonorarios();
		}
		
		return null;
		
	}
	

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public String[] getHeaders() {
		return headers;
	}

}
