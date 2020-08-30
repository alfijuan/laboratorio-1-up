package handler;

import java.util.List;

import javax.swing.JOptionPane;
import bo.EmpleadoBO;
import bo.HorasBO;
import bo.ProyectoBO;
import bo.TareaBO;
import dao.EmpleadoDaoImpl;
import dao.HorasDaoImpl;
import dao.ProyectoDAO;
import dao.ProyectoDaoImpl;
import dao.TareaDaoImpl;
import empresa.Empleado;
import empresa.Hora;
import empresa.Proyecto;
import empresa.Tarea;
import exceptions.SystemException;
import exceptions.empleado.EmpleadoAlreadyExists;
import exceptions.empleado.EmpleadoNotFoundException;
import exceptions.horas.HoraNotFoundException;
import exceptions.tarea.TareaAlreadyExists;
import ui.EmpleadoAlta;
import ui.EmpleadoModificacion;
import ui.HoraAlta;
import ui.HoraModificacion;
import ui.TareaAlta;
import ui.TareaModificacion;
import ui.MiFrame;
import ui.ProyectoCosto;
import ui.table.EmpleadoTable;
import ui.table.HorasTable;
import ui.table.TareaTable;

public class Handler {
	
	private MiFrame frame;
	private EmpleadoBO empleadoBO;
	private TareaBO tareaBO;
	private HorasBO horasBO;
	private ProyectoBO proyectoBO;

	public Handler() {
		empleadoBO = new EmpleadoBO();
		empleadoBO.setEmpDao(new EmpleadoDaoImpl());
		
		tareaBO = new TareaBO();
		tareaBO.setTareaDAO(new TareaDaoImpl());
		
		horasBO = new HorasBO();
		horasBO.setHorasDao(new HorasDaoImpl());
		
		proyectoBO = new ProyectoBO();
		proyectoBO.setProyectoDao(new ProyectoDaoImpl());
		
		frame = new MiFrame("v1.0", this);
	}
	
	public void init() {
        frame.setVisible(true);
	}
	
	public void mostrarModal(String title) {
		JOptionPane.showOptionDialog(null, title, "", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, null, null);
	}
	
	public void mostrarTablaEmpleado() {
		try {
			frame.cambiarPanel(new EmpleadoTable(this.getEmpleadoBO().obtenerEmpleados(), this));
		} catch (SystemException e1) {
			this.mostrarModal(e1.getMessage());
		}
	}
	
	public void mostrarAgregarEmpleado() {
		frame.cambiarPanel(new EmpleadoAlta(this));
	}
	
	public void mostrarEditarEmpleado(Empleado emp) {
		frame.cambiarPanel(new EmpleadoModificacion(this, emp));
	}
	
	public void mostrarBorrarEmpleado(int legajo) {
		try {
			this.empleadoBO.eliminarEmpleado(legajo);
			mostrarModal("Empleado borrado correctamente!");
			this.mostrarTablaEmpleado();
		} catch (EmpleadoNotFoundException e1) {
			this.mostrarModal(e1.getMessage());
		} catch (SystemException e1) {
			this.mostrarModal(e1.getMessage());
		}
	}

	public void agregarEmpleado(Empleado empleado) {
		try {
			empleadoBO.agregarEmpleado(empleado);
			mostrarModal("Empleado agregado correctamente!");
			mostrarTablaEmpleado();
		} catch (EmpleadoAlreadyExists e1) {
			mostrarModal(e1.getMessage());
		} catch (SystemException e1) {
			mostrarModal(e1.getMessage());
		} catch (EmpleadoNotFoundException e1) {
			mostrarModal(e1.getMessage());
		}
	}
	
	public void editarEmpleado(Empleado empleado) {
		try {
			getEmpleadoBO().editarEmpleado(empleado);
			mostrarModal("Empleado editado correctamente!");
			mostrarTablaEmpleado();
		} catch (EmpleadoNotFoundException e1) {
			mostrarModal(e1.getMessage());
		} catch (SystemException e1) {
			mostrarModal(e1.getMessage());
		}
	}
	
	
	public void mostrarAgregarTarea() {
		frame.cambiarPanel(new TareaAlta(this));
	}
	
	public void mostrarTablaTarea() {
		try {
			frame.cambiarPanel(new TareaTable(this.getTareaBO().obtenerTareas(), this));
		} catch (SystemException e1) {
			this.mostrarModal(e1.getMessage());
		}
	}
	public void agregarTarea(Tarea tarea) {
		try {
			tareaBO.agregarTarea(tarea);
			mostrarModal("Tarea agregada correctamente!");
			mostrarTablaTarea();
		} catch (TareaAlreadyExists e1) {
			mostrarModal(e1.getMessage());
		} catch (SystemException e1) {
			mostrarModal(e1.getMessage());
		}
	}
	public void mostrarEditarTarea(Tarea tarea) {
		frame.cambiarPanel(new TareaModificacion(this, tarea));
	}
	
	public void editarTarea(Tarea tarea) {
		try {
			getTareaBO().editarTarea(tarea);
			mostrarModal("Tarea editada correctamente!");
			mostrarTablaTarea();
		} catch (SystemException e1) {
			mostrarModal(e1.getMessage());
		}
	}
	
	public void borrarTarea(int id) {
		try {
			getTareaBO().borrarTarea(id);
			mostrarModal("Tarea borrada correctamente!");
			mostrarTablaTarea();
		} catch (SystemException e1) {
			mostrarModal(e1.getMessage());
		}
	}
	
	public void mostrarTablaHoras() {
		try {
			frame.cambiarPanel(new HorasTable(this.getHorasBO().obtenerHoras(), this));
		} catch (SystemException e1) {
			this.mostrarModal(e1.getMessage());
		}
	}
	
	public void mostrarCargarHoras() {
		frame.cambiarPanel(new HoraAlta(this));
	}
	
	public void agregarHora(Hora hora) {
		
		try {
			horasBO.cargarHoras(hora);
		} catch (SystemException e) {
			mostrarModal(e.getMessage());
		}
		mostrarModal("Hora cargada correctamente!");
	}
	
	public void mostrarEditarHora(Hora hora) {
		frame.cambiarPanel(new HoraModificacion(this, hora));
	}
	
	public void editarHora(Hora hora) {
		
			try {
				getHorasBO().editarHoras(hora);
				mostrarModal("Registro editado correctamente!");
				mostrarTablaHoras();
			} catch (SystemException e) {
				e.printStackTrace();
			} catch (HoraNotFoundException e) {
				mostrarModal(e.getMessage());
				e.printStackTrace();
			}
	}
	
	public void borrarHora(Integer idHora) {
		
		try {
			getHorasBO().eliminarHoras(idHora);
			mostrarModal("Registro borrado correctamente!");
			mostrarTablaHoras();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (HoraNotFoundException e) {
			mostrarModal(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void mostrarCostoProyecto() {
		frame.cambiarPanel(new ProyectoCosto(this));
	}
	
	public Double calcularCostoProyecto(int id) {
		Double costo = null;
		try {
			costo = proyectoBO.obtenerCostosById(id).getCosto();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return costo;
	}
	
	public void calcularCostoEmpleado(int legajo) {
		try {
			List<Integer> resultados = getHorasBO().obtenerHoras(legajo);
			mostrarModal("Al empleado se le deben " + Integer.toString(resultados.get(1)) + " correspondientes a " + Integer.toString(resultados.get(0)) + " horas.");
		} catch (SystemException e) {
			mostrarModal(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public EmpleadoBO getEmpleadoBO() {
		return empleadoBO;
	}

	public void setEmpleadoBO(EmpleadoBO empleadoBO) {
		this.empleadoBO = empleadoBO;
	}
	
	public TareaBO getTareaBO() {
		return tareaBO;
	}

	public void setTareaBO(TareaBO tareaBO) {
		this.tareaBO = tareaBO;
	}

	public HorasBO getHorasBO() {
		return horasBO;
	}

	public void setHorasBO(HorasBO horasBO) {
		this.horasBO = horasBO;
	}

	public ProyectoBO getProyectoBO() {
		return proyectoBO;
	}

	public void setProyectoBO(ProyectoBO proyectoBO) {
		this.proyectoBO = proyectoBO;
	}
	
	
}
