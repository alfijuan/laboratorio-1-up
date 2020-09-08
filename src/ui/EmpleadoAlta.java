package ui;

import handler.Handler;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

import empresa.Empleado;

public class EmpleadoAlta extends EmpleadoBase {
	
	private static final long serialVersionUID = 1L;
	
	public EmpleadoAlta(Handler handler) {
		super(handler);
		setHandler(handler);
		agregarBotones();
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
        		Empleado empleado = new Empleado();
        		empleado.setDni(Integer.parseInt(getDni().getField().getText()));
				empleado.setNombre(getNombre().getField().getText());
				empleado.setApellido(getApellido().getField().getText());
				empleado.setHonorarios(Float.parseFloat(getHonorarios().getField().getText()));
				getHandler().agregarEmpleado(empleado);
			}
		});
		return botonera;
	}

	@Override
	protected String setTitulo() {
		return "Alta de empleado";
	}

}
