package Lab4;

import javax.swing.*;
import java.awt.*;


/**
 * @Author: ...7569
 * Public Class: Lab 4
 * Last Date Modified: 11/2/2014
 */
public class Lab4 extends JFrame {
    
    /**
     * Creates a frame with only one component: ScreenSaver
     */
    public Lab4(){
        super("Lab 4");
        setSize(600,600);
        ScreenSaver saver = new ScreenSaver();
        setLayout(new BorderLayout());
        add(saver, BorderLayout.CENTER);
        
    }
    
    /**
     * Launches the application.
     * @param args
     */
    public static void main(String args[]){
        Lab4 lab4=new Lab4();
        lab4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        lab4.setSize( 600, 600 ); // set frame size
        lab4.setResizable(true);
        lab4.setVisible( true ); // display frame
        lab4.setLocationRelativeTo(null);
    }
}
