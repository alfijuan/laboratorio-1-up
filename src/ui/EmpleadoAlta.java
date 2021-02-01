package ui;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

public class EmpleadoAlta extends EmpleadoBase {
	
	private static final long serialVersionUID = 1L;
	
	public EmpleadoAlta(Handler handler) {
		super(handler);
	}
	
	@Override
	protected Box agregarBotones() {
		Box botonera = Box.createHorizontalBox();
		JButton OKBtn = new JButton("OK");
        JButton SalirBtn = new JButton("Volver");
        JButton limpiarCamposBtn = new JButton("Limpiar campos");
        
        botonera.add(OKBtn);
        botonera.add(Box.createHorizontalGlue());
        
        botonera.add(SalirBtn);
        botonera.add(Box.createHorizontalGlue());
        
        botonera.add(limpiarCamposBtn);
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
				getHandler().agregarEmpleado(panelToObject());
				limpiarCampos();
			}
		});
		
		limpiarCamposBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		return botonera;
	}

	@Override
	protected String setTitulo() {
		return "Alta de empleado";
	}

	@Override
	protected void limpiarCampos() {
		getNombre().cleanTextField();
		getApellido().cleanTextField();
		getDni().cleanTextField();
		getDireccion().cleanTextField();
		getHonorarios().cleanTextField();
	}

}
