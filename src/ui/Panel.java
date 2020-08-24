package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import handler.Handler;

public abstract class Panel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4214911867421930253L;
	private Handler handler;
	public static final int HEIGHT = 20;
	
	public void altaPanel() {
		Box verticalBox = Box.createVerticalBox();
		completarCampos(verticalBox, Boolean.FALSE);
		verticalBox.add(getBotonera(Boolean.FALSE));
        verticalBox.add(Box.createVerticalStrut(30));
        add(verticalBox);
	}
	
	public void modificarPanel() {
		Box verticalBox = Box.createVerticalBox();
		completarCampos(verticalBox, Boolean.TRUE);
        verticalBox.add(getBotonera(Boolean.TRUE));
        verticalBox.add(Box.createVerticalStrut(30));
        add(verticalBox);
	}
	
	public Box getBotonera(Boolean esEdicion) {
		Box botonera = Box.createHorizontalBox();
        botonera.add(Box.createHorizontalGlue());
        
        JButton OKBtn = new JButton("OK");
        OKBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	        		if(esEdicion) {
	        			modificar();
	        		}else {
	        			agregar();
	        		}
			}
		});
        
        JButton SalirBtn = new JButton("Volver");
        SalirBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.mostrarTablaEmpleado();
			}
		});
        
        botonera.add(OKBtn);
        botonera.add(Box.createHorizontalGlue());
        
        botonera.add(SalirBtn);
        botonera.add(Box.createHorizontalGlue());
        
        return botonera;
	}
	
	public abstract Box completarCampos(Box vertical, Boolean esEdicion);
	public abstract void agregar();
	public abstract void modificar();

}
