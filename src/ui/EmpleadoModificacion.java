package ui;

import handler.Handler;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

import empresa.Empleado;

public class EmpleadoModificacion extends EmpleadoBase {
	
	private static final long serialVersionUID = 1L;
	private Empleado current;
	
	public EmpleadoModificacion(Handler handler, Empleado emp){
		super(handler);
		setHandler(handler);
		setEmpleado(emp);
		agregarDatosEmpleado();
		agregarBotones();
	}
	
	private void agregarDatosEmpleado(){
		getNombre().getField().setText(getEmpleado().getNombre());
		getDni().getField().setText(Integer.toString(getEmpleado().getDni()));
		getDni().getField().setEnabled(false);
		getHonorarios().getField().setText(Float.toString(getEmpleado().getHonorarios()));
	}
	
	protected Box agregarBotones() {
		Box botonera = Box.createHorizontalBox();
		JButton OKBtn = new JButton("OK");
        JButton SalirBtn = new JButton("Volver");
        
        botonera.add(OKBtn);
        botonera.add(Box.createHorizontalGlue());
        
        botonera.add(SalirBtn);
        botonera.add(Box.createHorizontalGlue());
        
        SalirBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getHandler().mostrarTablaEmpleado();
			}
		});
		
		OKBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
        		current.setNombre(getNombre().getField().getText());
        		current.setHonorarios(Float.parseFloat(getHonorarios().getField().getText()));
				getHandler().editarEmpleado(current);
			}
		});
		return botonera;
	}
	
	@Override
	protected String setTitulo() {
		return "Modificacion de empleado";
	}
	
	public Empleado getEmpleado() {
		return current;
	}
	
	public void setEmpleado(Empleado emp) {
		this.current = emp;
	}

}
