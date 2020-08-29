package empresa;

public class Tarea {
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer idProyecto ;
	
	public Tarea (){};
	
	public Tarea(Integer id, String nombre, String descripcion, Integer idProyecto) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.idProyecto = idProyecto;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}
	
}
