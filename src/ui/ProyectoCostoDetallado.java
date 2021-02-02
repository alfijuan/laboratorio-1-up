package ui;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;

public class ProyectoCostoDetallado extends ProyectoBase {
	
	private static final long serialVersionUID = 1L;
	
	public ProyectoCostoDetallado(Handler handler) {
		super(handler);
	}
	
	protected Box agregarBotones() {
		Box botonera = Box.createHorizontalBox();
		JButton CalcularBtn = new JButton("Calcular");
        
        botonera.add(CalcularBtn);
        botonera.add(Box.createHorizontalGlue());
        
        botonera.add(Box.createHorizontalGlue());
        
        CalcularBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getComboProyecto().getSelectedIndex() != 0) {
					String proyecto = (String)getComboProyecto().getSelectedItem();
					getHandler().mostrarCostoProyectoDetallado(Integer.parseInt(proyecto.split("-")[0]));
				}
				else {
					getHandler().mostrarModal("Debe seleccionar una proyecto");
				}
				
			}
		});
		return botonera;
	}

	@Override
	public Object panelToObject() {
		return null;
	}

	@Override
	public void objectToPanel(Object data) {
	}

	@Override
	protected String setTitulo() {
		return "Calculo de costo detallado por proyecto";
	}

	@Override
	protected void limpiarCampos() {
	}

}
