package ui;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

import empresa.Tarea;

public class TareaModificacion extends TareaBase {

	private static final long serialVersionUID = 5535114194045009918L;
	private Tarea current;
	
	public TareaModificacion(Handler handler, Tarea tarea){
		super(handler);
		setTarea(tarea);
		objectToPanel(tarea);
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
				if(getComboProyecto().getSelectedIndex() != 0) {
					String proyecto = (String)getComboProyecto().getSelectedItem();
	        		current.setNombre(getNombre().getField().getText());
	        		current.setDescripcion(getDescription().getField().getText());
	        		current.setIdProyecto(Integer.parseInt(proyecto.split("-")[0]));
					getHandler().editarTarea(current);
				} else {
					getHandler().mostrarModal("Debe seleccionar un proyecto");
				}
				
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

	@Override
	protected void limpiarCampos() {
	}
}
