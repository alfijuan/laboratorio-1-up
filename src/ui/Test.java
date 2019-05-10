package ui;
 
import javax.swing.*;
 
public class Test {
 
        public static void main(String[] args) {
            JFrame frame = new MiFrame("Test v1.0");
            frame.getContentPane().add(new EmpleadoPanel("Panel"));
            frame.setVisible(true);
        }
 
}
 