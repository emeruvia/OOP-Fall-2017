package BookChaper12;

import javax.swing.*;
import java.awt.*;

public class ListFrame extends JFrame{
    
    private final JList<String> colorJList;
    private static final String[] colorNames = {"Black", "Blue", "Cyan",
            "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange",
            "Pink", "Red", "White", "Yellow"};
    private static final Color[] colors = {Color.BLACK, Color.BLUE,
            Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
            Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
            Color.RED, Color.WHITE, Color.YELLOW};

    public ListFrame() {
    
        super("List Test");
        setLayout(new FlowLayout());
        
        colorJList = new JList<>(colorNames);
        colorJList.setVisibleRowCount(5);
        
        //do not allow mulitple screens selections
        colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
    }

}
