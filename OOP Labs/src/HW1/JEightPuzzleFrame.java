import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;


/**
 * Public class name: JEightPuzzleFrame
 * Last date modified: 10/01/2017
 */
public class JEightPuzzleFrame extends JFrame implements ActionListener {
    
    private JButton buttons[] = new JButton[8]; //buttons arrays
    private Icon icon[] = new Icon[9];  //Icons array
    private JPanel emptyButton = new JPanel();  //empty button panel
    private int indexPosition[] = new int[9];
    
    //ArrayList that will hold the position number
    private ArrayList positionNumber = new ArrayList();
    
    //2-D array with the grid values
    private int[][] grid = {{0, 1, 2},
            {3, 4, 5},
            {6, 7, 8}};
    
    //index position for the the initial puzzle right answer
    private int[] rightAnswer = {1, 2, 3, 4, 5, 6, 7, 8, 0};
    
    //index position for the random puzzle right answer
    private int[] rightAnswerRandom = {1, 2, 3, 4, 5, 6, 7, 8, 1};
    
    //initial window position
    private int[] initWindow = {0, 1, 4, 5, 2, 3, 6, 7};
    private JPanel mainPanel;   //Main panel that holds all the buttons
    private String path;    //global path for the image file
    private static BufferedImage image; //image instance variable
    
    /**
     * Main method: creates an JEightPuzzleFrame object with the title and
     * file path as parameters, also set the size of the window.
     *
     * @param args
     */
    public static void main(String[] args) {
        JEightPuzzleFrame puzzle =
                new JEightPuzzleFrame("JEightPuzzleFrame", "FGCU_logo.png");
        puzzle.setSize(image.getWidth() + 20, image.getHeight() + 50);
    }
    
    /**
     * Constructor class, sets the main panel, the image path, and default
     * settings for the window frame
     *
     * @param title sets the window title
     * @param path  sets the image path
     */
    private JEightPuzzleFrame(String title, String path) {
        super(title); //set the title
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 3)); //set frame layout
        this.path = path;
        add(mainPanel); //add the main panel to the frame window
        iconButtons();  //initializes the icons array
        initialPuzzle();    //initializes the puzzle layout
        
        //loop for checking the index position value of the buttons in the
        // console.
        for (int i = 0; i < 9; i++) {
            System.out.println("position: " + indexPosition[i]);
        }
        
        //default window settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * This class reads the image from the image path and creates an icon
     * according to the starting position.
     *
     * @param startX, starting X position for the image
     * @param startY, starting Y position for the image
     * @return the icon image
     */
    private Icon extractIcon(int startX, int startY) {
        image = null;
        try {
            image = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            System.err.println("Image not found");
            System.exit(1);
        }
        
        int width = image.getWidth() / 3;
        int height = image.getHeight() / 3;
        BufferedImage part = new BufferedImage(
                width, height, BufferedImage.TYPE_4BYTE_ABGR);
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                part.setRGB(x, y, image.getRGB(x + startX, y + startY));
            }
        }
        
        ImageIcon icon = new ImageIcon();
        icon.setImage(part);
        return icon;
    }
    
    /**
     * iconButtons method creates an array of icons through a loop that
     * changes the X and Y starting position for the extractIcon method.
     */
    private void iconButtons() {
        int startX;
        int startY;
        int multiplier = 0;
        for (int i = 0; i < 9 - 1; i++) {
            if (i == 0) {
                startX = 0;
                startY = 0;
            } else if (i < 3) {
                multiplier = i;
                startX = (image.getWidth() / 3) * multiplier;
                startY = 0;
            } else if (i < 6) {
                multiplier = i - 3;
                startX = (image.getWidth() / 3) * multiplier;
                startY = (image.getHeight() / 3);
            } else {
                multiplier = i - 6;
                startX = (image.getWidth() / 3) * multiplier;
                startY = (image.getHeight() / 3) * 2;
            }
            icon[i] = extractIcon(startX, startY); //finds the icon
        }
    }
    
    /**
     * initialPuzzle method creates the default layout for the puzzle game
     */
    private void initialPuzzle() {
        mainPanel.add(emptyButton);
        
        for (int i = 0; i < 8; i++) {
            buttons[i] = new JButton(icon[initWindow[i]]);
            mainPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
            indexPosition[i + 1] = initWindow[i] + 1;
        }
    }
    
    /**
     * randomizePuzzle method initializes an Array List and stores values
     * from 0-8, it then shuffles the number list using collections and gets
     * the position value in order to set the button icon.
     */
    private void randomizePuzzle() {
        mainPanel.add(emptyButton);
        for (int i = 0; i < 8; i++) {
            positionNumber.add(i);
        }
        
        Collections.shuffle(positionNumber);
        
        for (int i = 0; i < 8; i++) {
            buttons[i] = new JButton(icon[(int) positionNumber.get(i)]);
            mainPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
            indexPosition[i + 1] = (int) positionNumber.get(i) + 1;
        }
    }
    
    /**
     * actionPerformed takes the position of the button and then verifies the
     * position of the empty button then swaps them around.
     *
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        Dimension size = button.getSize();  //gets the size of the button
        int a;
        int emptyX = emptyButton.getX(); //gets emptybutton X position
        int emptyY = emptyButton.getY(); //gets emptybutton Y position
        int buttonX = button.getX(); //button clicked X position
        int buttonY = button.getY(); //button clicked Y position
        int buttonXPosition = buttonX / size.width;
        int buttonYPosition = buttonY / size.height;
        int buttonIndexPosition = grid[buttonYPosition][buttonXPosition];
        
        if (emptyX == buttonX && (emptyY - buttonY) ==
                size.height) {
            int labelIndex = buttonIndexPosition + 3;
            mainPanel.remove(buttonIndexPosition);
            mainPanel.add(emptyButton, buttonIndexPosition);
            mainPanel.add(button, labelIndex);
            mainPanel.validate();
            a = indexPosition[buttonIndexPosition];
            indexPosition[buttonIndexPosition] = indexPosition[labelIndex];
            indexPosition[labelIndex] = a;
        }
        
        if (emptyX == buttonX && (emptyY - buttonY) == -
                size.height) {
            int labelIndex = buttonIndexPosition - 3;
            mainPanel.remove(labelIndex);
            mainPanel.add(button, labelIndex);
            mainPanel.add(emptyButton, buttonIndexPosition);
            mainPanel.validate();
            a = indexPosition[buttonIndexPosition];
            indexPosition[buttonIndexPosition] = indexPosition[labelIndex];
            indexPosition[labelIndex] = a;
        }
        
        if (emptyY == buttonY && (emptyX - buttonX) ==
                size.width) {
            int labelIndex = buttonIndexPosition + 1;
            mainPanel.remove(buttonIndexPosition);
            mainPanel.add(emptyButton, buttonIndexPosition);
            mainPanel.add(button, labelIndex);
            mainPanel.validate();
            a = indexPosition[buttonIndexPosition];
            indexPosition[buttonIndexPosition] = indexPosition[labelIndex];
            indexPosition[labelIndex] = a;
        }
        
        if (emptyY == buttonY && (emptyX - buttonX) == -
                size.width) {
            int labelIndex = buttonIndexPosition - 1;
            mainPanel.remove(buttonIndexPosition);
            mainPanel.add(emptyButton, labelIndex);
            mainPanel.add(button, labelIndex);
            mainPanel.validate();
            a = indexPosition[buttonIndexPosition];
            indexPosition[buttonIndexPosition] = indexPosition[labelIndex];
            indexPosition[labelIndex] = a;
        }
        
        System.out.println();
        
        //Creates a for loop that prints the index position of the buttons to
        // the console, this is done for testing purposes.
        for (int i = 0; i < 9; i++) {
            System.out.println("position:" + indexPosition[i]);
        }
        
        //compares 2 arrays, if the values are equal the pop a window and ask
        // the user if he wants to play again.
        if (Arrays.equals(indexPosition, rightAnswer) || Arrays.equals
                (indexPosition, rightAnswerRandom)) {
            JOptionPane.showMessageDialog(this,
                    "Congratulations! Hit Ok to play again");
            
            //clears the Panel in order to add the buttons again
            mainPanel.removeAll();
            randomizePuzzle();
            mainPanel.validate();   //updates the window with the new buttons
        }
    }
}
