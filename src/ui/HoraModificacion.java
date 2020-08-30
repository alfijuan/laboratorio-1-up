package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;

import empresa.Hora;
import handler.Handler;
import utils.formatUtils;

public class HoraModificacion extends HoraBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 623742814211179061L;
	private Hora horaSeleccionada;
	
	public HoraModificacion(Handler handler, Hora hora){
		super(handler);
		setHandler(handler);
		setHoraSeleccionada(hora);
		agregarDatosHora();
		agregarBotones();
	}
	
	private void agregarDatosHora(){
		getComboLegajo().setSelectedItem(String.valueOf(horaSeleccionada.getLegajoEmpleado()));
		getComboTarea().setSelectedItem((String.valueOf(horaSeleccionada.getIdTarea())));
		getCantidad().getField().setText(String.valueOf((horaSeleccionada.getCantidad())));
		getFecha().getField().setText(String.valueOf(horaSeleccionada.getFecha()));
		
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
				
        		horaSeleccionada.setLegajoEmpleado(Integer.parseInt((String)getComboLegajo().getSelectedItem()));
        		horaSeleccionada.setIdTarea((Integer.parseInt((String)getComboTarea().getSelectedItem())));
        		horaSeleccionada.setCantidad(Integer.parseInt(getCantidad().getField().getText()));
        		horaSeleccionada.setFecha(formatUtils.formatDate(getFecha().getField().getText()));
				getHandler().editarHora(horaSeleccionada);
        		
        		System.out.println(horaSeleccionada);
			}
		});
		return botonera;
	}
	
	
	public Hora getHoraSeleccionada() {
		return horaSeleccionada;
	}
	public void setHoraSeleccionada(Hora horaSeleccionada) {
		this.horaSeleccionada = horaSeleccionada;
	}

	@Override
	protected String setTitulo() {
		return "Modificacion de horas";
	}
}
