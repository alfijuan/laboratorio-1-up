package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import bo.EmpleadoBO;
import bo.TareaBO;
import dao.EmpleadoDaoImpl;
import dao.TareaDaoImpl;
import empresa.Empleado;
import empresa.Tarea;
import exceptions.SystemException;
import handler.Handler;
import ui.containers.InputContainer;

public abstract class HoraBase extends JPanel{
	
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
	private Handler handler;
	private List<Empleado> empleados;
	private List<Tarea> tareas;
	
	private JLabel comboTareaLabel;
	private JComboBox<String> comboTarea;
	private JLabel descripcionTareaLabel;
	private JLabel descripcionTarea;
	private JLabel proyectotareaLabel;
	private JDatePicker dateField;
	
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}


	public HoraBase(Handler handler){
		setHandler(handler);
		createUI();
	}
	
	
	private void createUI() {
		Box vertical = Box.createVerticalBox();
		Box inLineName = Box.createHorizontalBox();
		Box inLineLegajo = Box.createHorizontalBox();
		Box inLineTarea = Box.createHorizontalBox();
		Box inLineDescripcion = Box.createHorizontalBox();
		
		titulo = new JLabel("Carga de Horas", JLabel.LEFT);
		vertical.add(titulo);
		vertical.add(Box.createVerticalStrut(HEIGHT));
		
		empleados = new ArrayList<Empleado>();
		setEmpleados(getEmpleados());
		
    	comboLegajo = new JComboBox<String>();
    	comboLegajo.addItem("Seleccionar legajo");
    	for(Empleado empleado : empleados) {
    		comboLegajo.addItem(String.valueOf(empleado.getLegajo()));
    	}
		
    	comboLegajoLabel = new JLabel("Legajo", JLabel.LEFT);
    	inLineLegajo.add(comboLegajoLabel);
    	inLineLegajo.add(comboLegajo);
    	vertical.add(inLineLegajo);
		vertical.add(Box.createVerticalStrut(HEIGHT));
		
        nombreEmpleadoLabel = new JLabel("Nombre: ",JLabel.LEFT);
        nombreEmpleado = new JLabel("");
        comboLegajo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboLegajo = (JComboBox)e.getSource();
				nombreEmpleado.setText(getNombreEmpleadoByLegajo(empleados, Integer.parseInt((String)comboLegajo.getSelectedItem())));
			}
		});
        
        inLineName.add(nombreEmpleadoLabel);
        inLineName.add(nombreEmpleado);
        vertical.add(inLineName);
        vertical.add(Box.createVerticalStrut(HEIGHT));


        setTareas(obtenerTareas());
        comboTarea = new JComboBox<String>();
        comboTarea.addItem("Seleccionar una tarea");
    	for(Tarea tarea : tareas) {
    		comboTarea.addItem(String.valueOf(tarea.getId()));
    	}
		
    	comboTareaLabel = new JLabel("Tarea", JLabel.LEFT);
    	inLineTarea.add(comboTareaLabel);
    	inLineTarea.add(comboTarea);
    	vertical.add(inLineTarea);
		vertical.add(Box.createVerticalStrut(HEIGHT));
        
        
		descripcionTareaLabel = new JLabel("Descripcion: ",JLabel.LEFT);
		descripcionTarea = new JLabel("");
		comboTarea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboTarea = (JComboBox)e.getSource();
				descripcionTarea.setText(getDescripcionTareaById(tareas, Integer.parseInt((String)comboTarea.getSelectedItem())));
			}
		});
		inLineDescripcion.add(descripcionTareaLabel);
		inLineDescripcion.add(descripcionTarea);
        vertical.add(inLineDescripcion);
        vertical.add(Box.createVerticalStrut(HEIGHT));
		
        
        cantidad = new InputContainer("Cantidad", 8);
        vertical.add(cantidad.createHelperBox());
        vertical.add(Box.createVerticalStrut(HEIGHT));
        
         
        // TODO Ver las validaciones para ingreso de fecha.
        fecha = new InputContainer("Fecha(yyyyMMdd)", 30);
        vertical.add(fecha.createHelperBox());
        vertical.add(Box.createVerticalStrut(HEIGHT));
        
        vertical.add(Box.createVerticalStrut(40));
        vertical.add(agregarBotones());
        
        add(vertical);
	}
	
	public JLabel getTitulo() {
		return titulo;
	}


	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}


	protected abstract Box agregarBotones();
	 
	private List<Empleado> getEmpleados(){
		
		EmpleadoBO empleadoBO = new EmpleadoBO();
		empleadoBO.setEmpDao(new EmpleadoDaoImpl());
		List<Empleado> empleados = new ArrayList<Empleado>();
		try {
			 empleados = empleadoBO.obtenerEmpleados();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		return empleados;
	}
	
	private List<Tarea> obtenerTareas(){
		
		TareaBO tareaBO = new TareaBO();
		tareaBO.setTareaDAO(new TareaDaoImpl());
		List<Tarea> tareas = new ArrayList<Tarea>();
		try {
			 tareas = tareaBO.obtenerTareas();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		
		return tareas;
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

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
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
