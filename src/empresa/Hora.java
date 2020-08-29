package empresa;

import java.util.Date;

public class Hora {

	private int legajoEmpleado;
	private int idTarea;
	private int cantidad;
	private Date fecha;
	
	public Hora() {
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getLegajoEmpleado() {
		return legajoEmpleado;
	}

	public void setLegajoEmpleado(int legajoEmpleado) {
		this.legajoEmpleado = legajoEmpleado;
	}

	public int getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}
	
	public String toString() {
		return "Legajo: " + getLegajoEmpleado() 
					+ "\nID Tarea: " + String.valueOf(getIdTarea()) 
					+ "\nCantidad: " + String.valueOf(getCantidad())
					+ "\nFecha: " + getFecha();  
	}
	
}
