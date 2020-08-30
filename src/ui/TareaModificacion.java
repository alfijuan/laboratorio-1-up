package ui;

import handler.Handler;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

import empresa.Tarea;

public class TareaModificacion extends TareaBase {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5535114194045009918L;
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
		getComboProyecto().setSelectedItem(String.valueOf(getTarea().getIdProyecto()));
		
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
				String proyecto = (String)getComboProyecto().getSelectedItem();
        		current.setNombre(getNombre().getField().getText());
        		current.setDescripcion(getDescription().getField().getText());
        		current.setIdProyecto(Integer.parseInt(proyecto.split("-")[0]));
				getHandler().editarTarea(current);
			}
		});
		return botonera;
	}
	
	@Override
	protected String setTitulo() {
		return "Modificacion de tarea";
	}
	
	public Tarea getTarea() {
		return current;
	}
	
	public void setTarea(Tarea tarea) {
		this.current = tarea;
	}
}
