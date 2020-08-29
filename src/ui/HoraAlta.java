package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import empresa.Hora;
import handler.Handler;
import utils.formatUtils;

public class HoraAlta extends HoraBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -763553510251703246L;
	
	public HoraAlta(Handler handler) {
		super(handler);
		setHandler(handler);
		agregarBotones();
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
				Hora hora= new Hora();
        		hora.setLegajoEmpleado((Integer.parseInt((String)getComboLegajo().getSelectedItem())));
        		hora.setIdTarea((Integer.parseInt((String)getComboTarea().getSelectedItem())));
        		hora.setCantidad(Integer.parseInt(getCantidad().getField().getText()));
        		hora.setFecha(formatUtils.formatDate(getFecha().getField().getText()));
        		System.out.println(hora);
        		
				getHandler().agregarHora(hora);
				
			}
		});
		return botonera;
	}
	
	
}
