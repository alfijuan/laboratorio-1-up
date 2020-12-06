package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import empresa.Empleado;
import empresa.Hora;
import empresa.Tarea;
import ui.containers.InputContainer;
import utils.formatUtils;

public abstract class HoraBase extends Base {
	
	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 20; 
	private JLabel titulo;
	private JLabel comboLegajoLabel;
	private JComboBox<String> comboLegajo;
	private JLabel nombreEmpleadoLabel;
	private JLabel nombreEmpleado;
	private InputContainer idTarea;
	private InputContainer cantidad;
	private InputContainer fecha;
	private List<Empleado> empleados;
	private List<Tarea> tareas;
	private JLabel comboTareaLabel;
	private JComboBox<String> comboTarea;
	private JLabel descripcionTareaLabel;
	private JLabel descripcionTarea;
	private JLabel proyectotareaLabel;
	

	public HoraBase(Handler handler){
		super(handler);
	}
	
	public void initUI(){
		Box vertical = Box.createVerticalBox();
		Box inLineName = Box.createHorizontalBox();
		Box inLineLegajo = Box.createHorizontalBox();
		Box inLineTarea = Box.createHorizontalBox();
		Box inLineDescripcion = Box.createHorizontalBox();
		
		titulo = new JLabel(setTitulo(), JLabel.LEFT);
		
		empleados = new ArrayList<Empleado>();
		setEmpleados(getHandler().obtenerEmpleados());
		
    	comboLegajo = new JComboBox<String>();
    	comboLegajo.addItem("Seleccionar legajo");
    	for(Empleado empleado : empleados) {
    		comboLegajo.addItem(String.valueOf(empleado.getLegajo()));
    	}
		
    	comboLegajoLabel = new JLabel("Legajo", JLabel.LEFT);
		
        nombreEmpleadoLabel = new JLabel("Nombre: ",JLabel.LEFT);
        nombreEmpleado = new JLabel("");
        comboLegajo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboLegajo = (JComboBox)e.getSource();
				nombreEmpleado.setText(getNombreEmpleadoByLegajo(empleados, Integer.parseInt((String)comboLegajo.getSelectedItem())));
			}
		});
        

        setTareas(getHandler().obtenerTareas());
        comboTarea = new JComboBox<String>();
        comboTarea.addItem("Seleccionar una tarea");
    	for(Tarea tarea : tareas) {
    		comboTarea.addItem(String.valueOf(tarea.getId()));
    	}
		
    	comboTareaLabel = new JLabel("Tarea", JLabel.LEFT);
    	
		descripcionTareaLabel = new JLabel("Descripcion: ",JLabel.LEFT);
		descripcionTarea = new JLabel("");
		comboTarea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboTarea = (JComboBox)e.getSource();
				descripcionTarea.setText(getDescripcionTareaById(tareas, Integer.parseInt((String)comboTarea.getSelectedItem())));
			}
		});
        
        cantidad = new InputContainer("Cantidad", 8);
        
        // TODO Ver las validaciones para ingreso de fecha.
        fecha = new InputContainer("Fecha(yyyyMMdd)", 30);
        
        
        vertical.add(titulo);
		vertical.add(Box.createVerticalStrut(HEIGHT));
        
        inLineLegajo.add(comboLegajoLabel);
    	inLineLegajo.add(comboLegajo);
    	vertical.add(inLineLegajo);
		vertical.add(Box.createVerticalStrut(HEIGHT));
        
        inLineName.add(nombreEmpleadoLabel);
        inLineName.add(nombreEmpleado);
        vertical.add(inLineName);
        vertical.add(Box.createVerticalStrut(HEIGHT));
        
        inLineTarea.add(comboTareaLabel);
    	inLineTarea.add(comboTarea);
    	vertical.add(inLineTarea);
		vertical.add(Box.createVerticalStrut(HEIGHT));
        
        inLineDescripcion.add(descripcionTareaLabel);
		inLineDescripcion.add(descripcionTarea);
        vertical.add(inLineDescripcion);
        vertical.add(Box.createVerticalStrut(HEIGHT));
        
        vertical.add(cantidad.createHelperBox());
        vertical.add(Box.createVerticalStrut(HEIGHT));
        
        vertical.add(fecha.createHelperBox());
        vertical.add(Box.createVerticalStrut(HEIGHT));
        
        vertical.add(Box.createVerticalStrut(40));
        vertical.add(agregarBotones());
        
        add(vertical);
	}
	
	@Override
	public Hora panelToObject() {
		Hora hora = new Hora();
		hora.setLegajoEmpleado((Integer.parseInt((String)getComboLegajo().getSelectedItem())));
		hora.setIdTarea((Integer.parseInt((String)getComboTarea().getSelectedItem())));
		hora.setCantidad(Integer.parseInt(getCantidad().getField().getText()));
		hora.setFecha(formatUtils.formatDate(getFecha().getField().getText()));
		return hora;
	}
	
	@Override
	public void objectToPanel(Object data) { 
		Hora hora = (Hora) data;
		getComboLegajo().setSelectedItem(String.valueOf(hora.getLegajoEmpleado()));
		getComboTarea().setSelectedItem((String.valueOf(hora.getIdTarea())));
		getCantidad().getField().setText(String.valueOf(hora.getCantidad()));
		getFecha().getField().setText(String.valueOf(hora.getFecha()).replace("-", ""));
	}
	
	private String getNombreEmpleadoByLegajo(List<Empleado> empleados, Integer legajo) {
		String nombre = "";
		for(Empleado empleado : empleados)
			if(empleado.getLegajo() == legajo) {
				nombre = empleado.getNombre() + " " + empleado.getApellido();
			}
			
		return nombre;
	}
	
	private String getDescripcionTareaById(List<Tarea> tareas, Integer id) {
		String descripcion = "";
		
		for(Tarea tarea : tareas)
			if(tarea.getId().equals(id)) {
				descripcion = tarea.getDescripcion();
			}
		
		return descripcion;
	}
	
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JLabel getNombreEmpleadoLabel() {
		return nombreEmpleadoLabel;
	}

	public void setNombreEmpleadoLabel(JLabel nombreEmpleadoLabel) {
		this.nombreEmpleadoLabel = nombreEmpleadoLabel;
	}
	
	public JLabel getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(JLabel nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public InputContainer getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(InputContainer idTarea) {
		this.idTarea = idTarea;
	}

	public InputContainer getCantidad() {
		return cantidad;
	}

	public void setCantidad(InputContainer cantidad) {
		this.cantidad = cantidad;
	}

	public InputContainer getFecha() {
		return fecha;
	}

	public void setFecha(InputContainer fecha) {
		this.fecha = fecha;
	}

	public JLabel getComboLegajoLabel() {
		return comboLegajoLabel;
	}

	public void setComboLegajoLabel(JLabel comboLegajoLabel) {
		this.comboLegajoLabel = comboLegajoLabel;
	}

	public JComboBox<String> getComboLegajo() {
		return comboLegajo;
	}

	public void setComboLegajo(JComboBox<String> comboLegajo) {
		this.comboLegajo = comboLegajo;
	}

	public JLabel getComboTareaLabel() {
		return comboTareaLabel;
	}

	public void setComboTareaLabel(JLabel comboTareaLabel) {
		this.comboTareaLabel = comboTareaLabel;
	}

	public JComboBox<String> getComboTarea() {
		return comboTarea;
	}

	public void setComboTarea(JComboBox<String> comboTarea) {
		this.comboTarea = comboTarea;
	}

	public JLabel getDescripcionTareaLabel() {
		return descripcionTareaLabel;
	}

	public void setDescripcionTareaLabel(JLabel descripcionTareaLabel) {
		this.descripcionTareaLabel = descripcionTareaLabel;
	}

	public JLabel getProyectotareaLabel() {
		return proyectotareaLabel;
	}

	public void setProyectotareaLabel(JLabel proyectotareaLabel) {
		this.proyectotareaLabel = proyectotareaLabel;
	}
	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
	public JLabel getDescripcionTarea() {
		return descripcionTarea;
	}

	public void setDescripcionTarea(JLabel descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}

}
