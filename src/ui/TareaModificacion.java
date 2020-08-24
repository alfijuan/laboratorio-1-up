package ui;

import handler.Handler;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

import empresa.Tarea;

public class TareaModificacion extends TareaBase {

	private static final long serialVersionUID = 1L;
	private Tarea current;
	
	public TareaModificacion(Handler handler, Tarea tarea){
		super(handler);
		setHandler(handler);
		setTarea(tarea);
		agregarDatosTarea();
		agregarBotones();
	}
	
	private void agregarDatosTarea(){
		getNombre().getField().setText(getTarea().getNombre());
		getId().getField().setText(Integer.toString(getTarea().getId()));
		getId().getField().setEnabled(false);
		getDescription().getField().setText(getTarea().getDescripcion());
		
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
				getHandler().mostrarTablaTarea();
			}
		});
		
		OKBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
        		current.setNombre(getNombre().getField().getText());
        		current.setDescripcion(getDescription().getField().getText());
				getHandler().editarTarea(current);
			}
		});
		return botonera;
	}
	
	public Tarea getTarea() {
		return current;
	}
	
	public void setTarea(Tarea tarea) {
		this.current = tarea;
	}
}
