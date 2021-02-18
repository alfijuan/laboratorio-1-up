package ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;

public class ProyectoCostoDetallado extends ProyectoBase {
	
	private static final long serialVersionUID = 1L;
	private JLabel comboMesLabel;
	private JLabel comboAnioLabel;
	private JComboBox<Integer> comboMes;
	private JComboBox<Integer> comboAnio;
	
	public ProyectoCostoDetallado(Handler handler) {
		super(handler);
	}
	
	@Override
	public void agregarDatosExtras() {
		Box inLineMes = Box.createHorizontalBox();
		Box inLineAnio = Box.createHorizontalBox();
		
		comboMes = new JComboBox<Integer>();
    	for(int i=1; i <= 12; i++) {
    		comboMes.addItem(i);
    	}
        
        comboMesLabel = new JLabel("Mes", JLabel.LEFT);
        inLineMes.add(comboMesLabel);
        inLineMes.add(comboMes);
        getVertical().add(inLineMes);
        getVertical().add(Box.createVerticalStrut(getHeightSpace()));
		
    	comboAnio = new JComboBox<Integer>();
     	for(int i=2000; i <= 2025; i++) {
     		comboAnio.addItem(i);
     	}
    	
    	comboAnioLabel = new JLabel("Año", JLabel.LEFT);
    	inLineAnio.add(comboAnioLabel);
    	inLineAnio.add(comboAnio);
    	getVertical().add(inLineAnio);
    	getVertical().add(Box.createVerticalStrut(getHeightSpace()));
    	
    	
		
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
					Integer mes = (Integer)getComboMes().getSelectedItem();
					Integer anio = (Integer)getComboAnio().getSelectedItem();
					getHandler().mostrarCostoProyectoDetallado(Integer.parseInt(proyecto.split("-")[0]), mes, anio);
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

	public JComboBox<Integer> getComboMes() {
		return comboMes;
	}

	public void setComboMes(JComboBox<Integer> comboMes) {
		this.comboMes = comboMes;
	}

	public JComboBox<Integer> getComboAnio() {
		return comboAnio;
	}

	public void setComboAnio(JComboBox<Integer> comboAnio) {
		this.comboAnio = comboAnio;
	}

}
