package ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;

public class ProyectoCosto extends ProyectoBase {
	
	private static final long serialVersionUID = 1L;
	private JLabel costo;
	private JLabel nombreCostoLabel;
	
	public ProyectoCosto(Handler handler) {
		super(handler);
		agregarDatosProyecto();
	}
	
	private void agregarDatosProyecto(){
		Box vertical = Box.createVerticalBox();
		Box inLineName = Box.createHorizontalBox();
		
		nombreCostoLabel = new JLabel("Costo total: ",JLabel.LEFT);
		costo = new JLabel("",JLabel.LEFT);
		
		inLineName.add(nombreCostoLabel);
		inLineName.add(costo);
		vertical.add(inLineName);
		
		add(vertical);
		
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
					costo.setText("$" + String.valueOf(getHandler().calcularCostoProyecto(Integer.parseInt(proyecto.split("-")[0]))));
				}
				else {
					getHandler().mostrarModal("Debe seleccionar una proyecto");
				}
				
			}
		});
		return botonera;
	}

	public JLabel getCosto() {
		return costo;
	}

	public void setCosto(JLabel costo) {
		this.costo = costo;
	}

	public JLabel getNombreCostoLabel() {
		return nombreCostoLabel;
	}

	public void setNombreCostoLabel(JLabel nombreCostoLabel) {
		this.nombreCostoLabel = nombreCostoLabel;
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
		return "Calculo del costo del proyecto";
	}

	@Override
	protected void limpiarCampos() {
	}

	@Override
	public void agregarDatosExtras() {
	}

	
}
