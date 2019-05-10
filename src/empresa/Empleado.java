package empresa;

import java.util.ArrayList;

public class Empleado {
	private String nombre;
	private String apellido;
	private int dni;
	private int legajo;
	private String direccion;
	private float honorarios;
	private String nombreUsuario;
	private String password;

	
	
	public Empleado() {}
	
	public Empleado(String nombre, String apellido, int dni, int legajo, String direccion, float honorarios, String nombreUsuario, String password) {
		setNombre(nombre);
		setApellido(apellido);
		setDni(dni);
		setLegajo(legajo);
		setDireccion(direccion);
		setHonorarios(honorarios);
		setNombreUsuario(nombreUsuario);
		setPassword(password);
	}
	
	public String toString() {
		return "Nombre: " + getNombre() + "Apellido: " + getApellido() + "DNI: " + getDni() + "Legajo: " + getLegajo() + 
				"Direccion: " + getDireccion() + "Honorarios: " + getHonorarios();
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
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
