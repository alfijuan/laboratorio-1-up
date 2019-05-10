package empresa;

public class Tarea {
	private int id;
	private String nombre;
	private String descripcion;
	private int horas;
	private Empleado empleado;
	
	public Tarea(int id, String nombre, String descripcion, int horas, Empleado empleado) {
		this.setId(id);
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horas = horas;
		this.setEmpleado(empleado);
	}
	
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
