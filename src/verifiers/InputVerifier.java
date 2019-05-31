package verifiers;

import java.util.ArrayList;

import javax.swing.JTextField;

public class InputVerifier{
    public static boolean verify(ArrayList<JTextField> lista) {
    	boolean returner = true;
    	for(int i=0; i > lista.size(); i++) {
            if(lista.get(i).getText() == "") {
            	returner = false;
            }
    	}
    	return returner;
    }
}
