package ui.containers;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputContainer {
	
	private JLabel label; 
	private JTextField field;
	
	public InputContainer(String textoLabel, int length) {
		this.label = new JLabel(textoLabel);
		this.field = new JTextField(length);
	}

	public Box createHelperBox() {
		return createHelperBox(null, false);
	}
	
	public Box createHelperBox(Boolean disable) {
		return createHelperBox(null, disable);
	}
	
	public Box createHelperBox(String textoInput, Boolean disable) {
	    Box row = Box.createHorizontalBox();
	    row.add(this.getLabel());
	    row.add(Box.createHorizontalStrut(10));
	    if(textoInput != null) {
	    	this.getField().setText(textoInput);
	    	this.getField().setEditable(!disable);
	    }
	    row.add(this.getField());
	    return row;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JTextField getField() {
		return field;
	}

	public void setField(JTextField field) {
		this.field = field;
	}

}
