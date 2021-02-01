package ui;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

public class TareaAlta extends TareaBase {
	
	private static final long serialVersionUID = 1L;
	
	public TareaAlta(Handler handler) {
		super(handler);
	}
	
	protected Box agregarBotones() {
		Box botonera = Box.createHorizontalBox();
		JButton OKBtn = new JButton("OK");
        JButton SalirBtn = new JButton("Volver");
        
        botonera.add(OKBtn);
        botonera.add(Box.createHorizontalGlue());
        
        botonera.add(SalirBtn);
        botonera.add(Box.createHorizontalGlue());
		
		OKBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String proyecto = (String)getComboProyecto().getSelectedItem();
				setProject(proyecto);
        		getHandler().agregarTarea(panelToObject());
        		limpiarCampos();
			}
		});
        
        SalirBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getHandler().mostrarTablaTarea();
			}
		});
		
		return botonera;
	}

	@Override
	protected String setTitulo() {
		return "Carga de tareas";
	}

	@Override
	protected void limpiarCampos() {
		getId().cleanTextField();
		getNombre().cleanTextField();
		getDescription().cleanTextField();
	}
	
}
