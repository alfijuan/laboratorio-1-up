package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import bo.EmpleadoBO;
import dao.EmpleadoDaoImpl;
import empresa.Empleado;
import empresa.Hora;
import exceptions.SystemException;
import handler.Handler;
import ui.containers.InputContainer;
@Deprecated
public class HorasPanel extends JPanel {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = -148160877678011111L;
	private static final int HEIGHT = 20; 
	private Handler handler;
    private Hora currentHora;
    private EmpleadoBO empleadoBO;
    
	public HorasPanel(Handler handler, String titulo) {
    	this.setHandler(handler);
		initUI(titulo);
    }
	
	public HorasPanel(Handler handler, String titulo, Hora hora) {
    	this.setHandler(handler);
    	this.setHora(hora);
		initUI(titulo);
    }
    
    private void initUI(String titulo) {
    	empleadoBO = new EmpleadoBO();
		empleadoBO.setEmpDao(new EmpleadoDaoImpl());
		List<String> legajos = new ArrayList<String>();
		
		try {
			List<Empleado> empleados = this.getEmpleadoBO().obtenerEmpleados();
			
			for(Empleado empleado : empleados) {
				legajos.add(Integer.toString(empleado.getLegajo()) + " - " + empleado.getNombre());
			}
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
    	Box vertical = Box.createVerticalBox();
    	JComboBox<String> combo = new JComboBox<String>();
    	
    	for(String leg : legajos) {
    		combo.addItem(leg);
    	}
    	
    	
    	
    	InputContainer legajoField = new InputContainer("Legajo", 15);
    	InputContainer idTareaField = new InputContainer("Id tarea", 15);
    	InputContainer cantidadField = new InputContainer("Cantidad", 6);
    	InputContainer fechaField = new InputContainer("Fecha", 15);
    	
    	if(this.getHora() != null) {
            vertical.add(cantidadField.createHelperBox(Integer.toString(this.getHora().getCantidad()), false));
            vertical.add(Box.createVerticalStrut(HEIGHT));
//            vertical.add(fechaField.createHelperBox(this.getHora().getFecha(), true));
//            vertical.add(Box.createVerticalStrut(HEIGHT));
    	} else {
    		vertical.add(combo);
            vertical.add(Box.createVerticalStrut(HEIGHT));
    		vertical.add(idTareaField.createHelperBox());
            vertical.add(Box.createVerticalStrut(HEIGHT));
            vertical.add(cantidadField.createHelperBox());
            vertical.add(Box.createVerticalStrut(HEIGHT));
            vertical.add(fechaField.createHelperBox());
            vertical.add(Box.createVerticalStrut(HEIGHT));
    	}
        
        Box botonera = Box.createHorizontalBox();
        botonera.add(Box.createHorizontalGlue());
        JButton OKBtn = new JButton("OK");
        OKBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	        	if(currentHora != null) {
//	        		currentHora.setCantidad(cantidadField.getField().getText());
//	        		currentHora.setHonorarios(Float.parseFloat(honorariosField.getField().getText()));
	        		
	        		// IMPLEMENTAR
	        		
//	        		handler.editarHora(currentHora);
	        	} else {
	        		Hora hora= new Hora();
	        		hora.setLegajoEmpleado(Integer.parseInt(legajoField.getField().getText()));
	        		hora.setIdTarea(Integer.parseInt(idTareaField.getField().getText()));
	        		hora.setCantidad(Integer.parseInt(cantidadField.getField().getText()));
//	        		hora.setDireccion(fechaField.getField().getText());
    				
	        		//IMPLE
	        		
//    				handler.cargarHoras(hora);
	        	}
			}
		});
        
        JButton SalirBtn = new JButton("Volver");
        SalirBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarTablaHoras();
			}
		});
        
        botonera.add(OKBtn);
        botonera.add(Box.createHorizontalGlue());
        
        botonera.add(SalirBtn);
        botonera.add(Box.createHorizontalGlue());
        vertical.add(botonera);
        vertical.add(Box.createVerticalStrut(30));
        
        add(vertical);
    }

	public Hora getCurrentHora() {
		return currentHora;
	}

	public void setCurrentHora(Hora currentHora) {
		this.currentHora = currentHora;
	}

	public EmpleadoBO getEmpleadoBO() {
		return empleadoBO;
	}

	public void setEmpleadoBO(EmpleadoBO empleadoBO) {
		this.empleadoBO = empleadoBO;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	public Hora getHora() {
		return currentHora;
	}

	public void setHora(Hora hora) {
		this.currentHora = hora;
	}
    
   
}
