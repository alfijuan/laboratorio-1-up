package empresa;

public class Tarea {
	private int id;
	private String nombre;
	private String descripcion;
	private int horas;
	private int legajoEmpleado;
	
	public Tarea (){};
	
	public Tarea(int id, String nombre, String descripcion, int horas, int legajoEmpleado) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horas = horas;
		this.legajoEmpleado = legajoEmpleado;
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
	public int getLegajoEmpleado() {
		return legajoEmpleado;
	}

	public void setLegajoEmpleado(int legajoEmpleado) {
		this.legajoEmpleado = legajoEmpleado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
