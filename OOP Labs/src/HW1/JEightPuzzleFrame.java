package HW1;

import Test.IconButtonFrame;
import oracle.jrockit.jfr.JFR;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JEightPuzzleFrame extends JFrame {
    
    //main method variables
    private static String windowTitle;
    private static String pathToImage;
    private static final Scanner scan = new Scanner(System.in);
    
    //Buttons array to store the different buffered images.
    private JButton buttons[];
    
    //where to start extracting the icon in the image
    private static final int leftTopX = 0;
    private static final int leftTopY = 0;
    
    //the size of the icon
    private static final int width = 0;
    private static final int height = 0;
    
    //buffered image
    private static BufferedImage image;
    
    private Icon extractIcon(String path) {
        image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.err.println("Image not found");
            System.exit(1);
        }
        BufferedImage part = new BufferedImage(
                width, height, BufferedImage.TYPE_4BYTE_ABGR
        );
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                part.setRGB(x, y, image.getRGB(x+leftTopX, y+leftTopY));
            }
        }
        
        ImageIcon icon = new ImageIcon();
        icon.setImage(part);
        return icon;
    }
    
    //Constructor requires the title and the path tto an existing image file.
    public JEightPuzzleFrame(String title, String imagePath) {
        super(title); //set the title
        setLayout(new GridLayout(3,3)); //set frame layout
        
        
        Icon icon = extractIcon(imagePath); //finds the icon
        
        //initializes the array. Make it so this can be dynamic in the
        // future, so you can choose how big you want it to be.
        buttons = new JButton[9];
        
        //for loop that creates different buttons
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton(icon);
            add(buttons[i]);
        }
        
        
    }
    
    
    public static void main(String[] args) {
        
        windowTitle = scan.nextLine();
        pathToImage = scan.nextLine();
        
        JEightPuzzleFrame puzzle =
                new JEightPuzzleFrame(windowTitle, pathToImage);
        puzzle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        puzzle.setSize(image.getWidth(), image.getHeight());
        puzzle.setVisible(true);
    }
    
}
