package ui.containers;

import java.awt.event.*;

import javax.swing.JOptionPane;


public class SalirListener implements ActionListener{
		
	@Override
	public void actionPerformed(ActionEvent e) {
		int input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que desea salir?", "",
				JOptionPane.OK_CANCEL_OPTION);
		if (input == 0) {
			System.exit(0);
		
	}
}
}
