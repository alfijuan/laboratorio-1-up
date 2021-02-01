package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import empresa.Proyecto;

public abstract class ProyectoBase extends Base {
	
	private static final long serialVersionUID = 8254079957857169917L;
	
	private JLabel comboProyectoLabel;
	private JComboBox<String> comboProyecto;
	private List<Proyecto> proyectos;
	
	public ProyectoBase(Handler handler){
		super(handler);
		initUI();
	}
	
	@Override
	public void initUI(){
		Box vertical = Box.createVerticalBox();
		Box inLineProyecto = Box.createHorizontalBox();
        
		proyectos = new ArrayList<Proyecto>();
		setProyectos(getHandler().obtenerProyectos());
		
		comboProyecto = new JComboBox<String>();
		comboProyecto.addItem("Seleccionar proyecto");
    	for(Proyecto proyecto : proyectos) {
    		comboProyecto.addItem(String.valueOf(proyecto.getIdProyecto() + "-" + proyecto.getNombre()));
    	}
		
    	comboProyectoLabel = new JLabel("Proyectos", JLabel.LEFT);
    	inLineProyecto.add(comboProyectoLabel);
    	inLineProyecto.add(comboProyecto);
    	vertical.add(inLineProyecto);
    	vertical.add(Box.createVerticalStrut(getHeightSpace()));
    	
        vertical.add(Box.createVerticalStrut(40));
        vertical.add(agregarBotones());
        
        add(vertical);
	}
	

	public JComboBox<String> getComboProyecto() {
		return comboProyecto;
	}

	public void setComboProyecto(JComboBox<String> comboProyecto) {
		this.comboProyecto = comboProyecto;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

}
