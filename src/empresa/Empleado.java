package empresa;

public class Empleado {
	private String nombre;
	private String apellido;
	private int dni;
	private int legajo;
	private String direccion;
	private float honorarios;
	
	public Empleado() {}
	
	public Empleado(String nombre, String apellido, int dni, int legajo, String direccion, float honorarios) {
		setNombre(nombre);
		setApellido(apellido);
		setDni(dni);
		setLegajo(legajo);
		setDireccion(direccion);
		setHonorarios(honorarios);
	}
	
	public String toString() {
		return "Nombre: " + getNombre() + "\nApellido: " + getApellido() + "\nDNI: " + getDni() + "\nLegajo: " + getLegajo() + 
				"\nDireccion: " + getDireccion() + "\nHonorarios: " + getHonorarios();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public float getHonorarios() {
		return honorarios;
	}
	public void setHonorarios(float honorarios) {
		this.honorarios = honorarios;
	}
	
}
