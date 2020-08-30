package ui;

import handler.Handler;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

import empresa.Tarea;

public class TareaAlta extends TareaBase {
	
	private static final long serialVersionUID = 1L;
	
	public TareaAlta(Handler handler) {
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
		
		OKBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String proyecto = (String)getComboProyecto().getSelectedItem();
        		Tarea tarea = new Tarea(
        			Integer.parseInt(getId().getField().getText()),	
        			getNombre().getField().getText(),
        			getDescription().getField().getText(),
        			Integer.parseInt(proyecto.split("-")[0])
				);
        		getHandler().agregarTarea(tarea);
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
	
}
