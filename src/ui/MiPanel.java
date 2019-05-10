package ui;
 
import javax.swing.*;

import ui.containers.InputContainer;

public class MiPanel extends JPanel {
 
        public MiPanel(String titulo) {
        	initUI(titulo);
        }
 
        private void initUI(String titulo) {
        	Box vertical = Box.createVerticalBox();
        	
            vertical.add(InputContainer.createHelperBox("Nombre", null, false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(InputContainer.createHelperBox("Apellido", "Alfieri 2", false));
            vertical.add(Box.createVerticalStrut(20));
            vertical.add(InputContainer.createHelperBox("Apellido", "Disabled text", true));
            
            add(vertical);
        }
       
}
 