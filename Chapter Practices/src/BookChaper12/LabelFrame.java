package BookChaper12;

import javax.swing.*;
import java.awt.*;

public class LabelFrame extends JFrame {
    
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;
    
    public LabelFrame() {
        super("Testing JLabel");
        setLayout(new FlowLayout());
        
        //JLabel constructor with a string argument
        label1 = new JLabel("Label with text");
        label1.setToolTipText("This is label1");
        add(label1);
        
        //JLabel constructor with string, Icon and alignment arguments
        Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
        label2 = new JLabel("Label with text and icon", bug, SwingConstants
                .LEFT);
        label2.setToolTipText("This is label2");
        add(label2);
        
        //JLabel constructor with no arguments
        label3 = new JLabel();
        label3.setText("Label with icon and text at the bottom");
        label3.setIcon(bug);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);
        label3.setToolTipText("This is label3");
        add(label3);
    }
}
