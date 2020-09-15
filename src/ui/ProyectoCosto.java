package ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import empresa.Proyecto;

public class ProyectoCosto extends ProyectoBase {
	
	private static final long serialVersionUID = 1L;
	private Proyecto proyecto;
	private JLabel costo;
	private JLabel nombre;
	private JLabel nombreCostoLabel;
	
	public ProyectoCosto(Handler handler) {
		super(handler);
		setHandler(handler);
		agregarDatosProyecto();
		agregarBotones();
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
        JButton SalirBtn = new JButton("Volver");
        
        botonera.add(CalcularBtn);
        botonera.add(Box.createHorizontalGlue());
        
        botonera.add(SalirBtn);
        botonera.add(Box.createHorizontalGlue());
        
        SalirBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO pendiente
			}
		});
		
        CalcularBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
        		
				String proyecto = (String)getComboProyecto().getSelectedItem();
				costo.setText("$" + String.valueOf(getHandler().calcularCostoProyecto(Integer.parseInt(proyecto.split("-")[0]))));
			}
		});
		return botonera;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
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

	
}
