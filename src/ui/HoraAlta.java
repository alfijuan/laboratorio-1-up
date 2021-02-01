package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;

public class HoraAlta extends HoraBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -763553510251703246L;
	
	public HoraAlta(Handler handler) {
		super(handler);
	}
	
	
	@Override
	protected Box agregarBotones() {
		Box botonera = Box.createHorizontalBox();
		JButton OKBtn = new JButton("OK");
        JButton VolverBtn = new JButton("Volver");
        
        botonera.add(OKBtn);
        botonera.add(Box.createHorizontalGlue());
        
        botonera.add(VolverBtn);
        botonera.add(Box.createHorizontalGlue());
        
        VolverBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getHandler().mostrarTablaHoras();
			}
		});
		
		OKBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getComboLegajo().getSelectedIndex() != 0) {
					if(getComboTarea().getSelectedIndex() != 0) {
						getHandler().agregarHora(panelToObject());
						limpiarCampos();
					} else {
						getHandler().mostrarModal("Debe seleccionar una tarea");
					}
				} else {
					getHandler().mostrarModal("Debe seleccionar un legajo");
				}
					
			}
		});
		return botonera;
	}


	@Override
	protected String setTitulo() {
		return "Carga de Horas";
	}


	@Override
	protected void limpiarCampos() {
		getCantidad().cleanTextField();
		getFecha().cleanTextField();
	}

}
