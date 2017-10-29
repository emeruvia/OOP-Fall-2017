package HW1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class JEightPuzzleFrame extends JFrame {
    
    //main method variables
    private static String windowTitle;
    private static String pathToImage;
    private static final Scanner scan = new Scanner(System.in);
    private static final Random rand = new Random();
    
    //Buttons array to store the different buffered images.
    private JButton buttons[];
    private JPanel panel = new JPanel();;
    
    //where to start extracting the icon in the image
    private static int startX;
    private static int startY;
    
    //the size of the icon
    private static int width = 55;
    private static int height = 55;
    
    private static int imageWidth;
    private static int imageHeight;
    
    //buffered image
    private static BufferedImage image;
    
    private Icon extractIcon(String path, int leftTopX, int leftTopY) {
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
      
	    Icon icon[] = new Icon[9];
	    buttons = new JButton[9];
	    
	    
	    //This code will only work for a 3x3 grid
        //if there is leftover time then fix
	    int multiplier = 0;
	    for (int i = 0; i < 9 -1; i++) {
            if (i == 0) {
                startX = 0;
                startY = 0;
	        } else if (i > 0 && i <3) {
                multiplier = i;
                startX = (image.getWidth()/3) * multiplier;
                startY = 0;
            } else if (i >= 3 && i <6) {
                multiplier = i - 3;
                startX = (image.getWidth()/3) * multiplier;
                startY = (image.getHeight()/3);
            } else if (i >= 6 && i < 9) {
                multiplier = i - 6;
                startX = (image.getWidth()/3) * multiplier;
                startY = (image.getHeight()/3) * 2;
            }
            icon[i] = extractIcon(imagePath, startX, startY); //finds the icon
	    }
        ////////////////////////////////////


        
        //initializes the array. Make it so this can be dynamic in the
        // future, so you can choose how big you want it to be.
        
        initialPuzzle(icon);
        
        
        //for loop that creates different buttons
//        for (int i = 0; i < 9 - 1; i++) {
//            buttons[i] = new JButton(icon[i]);
//            add(buttons[i]);
//        }
    
    }
    
    //This class sets the layout for the first time the program is run.
    private void initialPuzzle(Icon icon[]) {
        for (int i = 0; i < icon.length; i++) {
            if (i == 0) {
                add(panel);
            } else if (i == 3 || i == 4) {
                buttons[i] = new JButton(icon[i + 1]);
                add(buttons[i]);
            } else if (i == 5 || i == 6) {
                buttons[i] = new JButton(icon[i - 3]);
                add(buttons[i]);
            } else if (i == 1 || i == 2 || i == 7 || i == 8) {
                buttons[i] = new JButton(icon[i - 1]);
                add(buttons[i]);
            }
        }
    }
    
    private void randomizePuzzle(Icon icon[]) {
        
        int randomPosition = rand.nextInt(8) + 1;
        
        for (int i = 0; i < icon.length; i++) {
            if (i == 0) {
                add(panel);
            } else {
                buttons[i] = new JButton(icon[randomPosition]);
                add(buttons[i]);
            }
        }
    }
    
    
    public static void main(String[] args) {
        
        //windowTitle = scan.nextLine();
        //pathToImage = scan.nextLine();
        
        //Temporary
        ////////////////////////////////////
        windowTitle = "Something";
        pathToImage = "C:\\Users\\EMG\\OneDrive\\OOP-Fall-2017\\OOP " +
                "Labs\\src\\HW1\\FGCU_logo.png";
        ////////////////////////////////////
        
        JEightPuzzleFrame puzzle =
                new JEightPuzzleFrame(windowTitle, pathToImage);
        puzzle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //20 and 50 take into account the bar on top of the image.
        puzzle.setSize(image.getWidth() + 20, image.getHeight() + 50);
        //puzzle.setResizable(false);
        puzzle.setVisible(true);
    }
}
