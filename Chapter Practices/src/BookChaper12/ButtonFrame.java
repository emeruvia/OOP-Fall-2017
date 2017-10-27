package BookChaper12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame extends JFrame {
    
    private final JButton plainJButton;
    private final JButton fancyJButton;
    
    public ButtonFrame() {
        super("Testing Buttons");
        setLayout(new FlowLayout());
        
        plainJButton = new JButton("Plain Button");
        add(plainJButton);
        
        Icon bug1 = new ImageIcon(getClass().getResource("bug1.gif"));
        Icon bug2 = new ImageIcon(getClass().getResource("bug2.gif"));
        fancyJButton = new JButton("Fancy Button", bug1);
        fancyJButton.setRolloverIcon(bug2);
        add(fancyJButton);
        
        //create new ButtonHandler for button event handling
        ButtonHandler handler = new ButtonHandler();
        fancyJButton.addActionListener(handler);
        plainJButton.addActionListener(handler);
    }
    
    //inner class for button event handling
    private class ButtonHandler implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(ButtonFrame.this, String.format
                    ("You pressed: %s", e.getActionCommand()));
        }
    }
    
}
