package ui.containers;

import javax.swing.*;

public class InputContainer {
	
	public static Box createHelperBox(String textoLabel) {
		return createHelperBox(textoLabel, null, false);
	}
	
	public static Box createHelperBox(String textoLabel, String textoInput) {
		return createHelperBox(textoLabel, textoInput, false);
	}

	public static Box createHelperBox(String textoLabel, String textoInput, Boolean disable) {
	    Box row = Box.createHorizontalBox();
	    JLabel label = new JLabel(textoLabel);
	    row.add(label);
	    row.add(Box.createHorizontalStrut(10));
	    JTextField field = new JTextField(30);
	    if(textoInput != null) {
	    	field.setText(textoInput);
	    	field.setEditable(!disable);
	    }
	    row.add(field);
	    return row;
	                       
	}

}
