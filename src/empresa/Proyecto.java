package empresa;

public class Proyecto {
	private Integer idProyecto;
	private String nombre;
	private Double costo;
	
	public Proyecto() {
	}
	
	public Proyecto(Integer id, String nombre) {
		this.idProyecto = id;
		this.nombre = nombre;
	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	
	
}
