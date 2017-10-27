package BookChaper12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldFrame extends JFrame {
    
    private final JTextField textField1;
    private final JTextField textField2;
    private final JTextField textField3;
    private final JPasswordField passwordField;
    
    public TextFieldFrame() {
        super("Testing JTextField and JPasswordField");
        setLayout(new FlowLayout());
        
        //construct textfield with 10 columns
        textField1 = new JTextField(10);
        add(textField1);
        
        //Construct textfield with default text
        textField2 = new JTextField("Enter Text Here");
        add(textField2);
        
        //Construct textfield with default text and 21 columns
        textField3 = new JTextField("Uneditable text field", 21);
        textField3.setEditable(false);
        add(textField3);
        
        //Construct passwordfield with default text
        passwordField = new JPasswordField("Hidden Text");
        add(passwordField);
        
        //register event handlers
        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);
    }
    
    private class TextFieldHandler implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent e) {
            String string = "";
            //user pressed Enter in JTextField textField1
            if(e.getSource() == textField1) {
                string = String.format("textField1: %s", e.getActionCommand());
            } else if (e.getSource() == textField2) {
                string = String.format("textField2: %s", e.getActionCommand());
            } else if (e.getSource() == textField3) {
                string = String.format("textField3: %s", e.getActionCommand());
            } else if (e.getSource() == passwordField) {
                string = String.format("passwordField: %s", e
                        .getActionCommand());
            }
            
            //Display JTextField content
            JOptionPane.showMessageDialog(null, string);
        }
    }
    
    
}
