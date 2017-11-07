import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JEightPuzzleFrame extends JFrame implements ActionListener {
    //Makes a 3x3 grid for the buttons
    private JComponent layout[][] = new JComponent[3][3];
    //Buttons to be used with the icons
    private JButton button[] = new JButton[8];
    //The empty Blank in the puzzle
    private JComponent Blank = new JLabel();
    //Id for the buttons
    private int ID[] = new int[9];
    BufferedImage image=null;
    
    // Starts on top left corner to extract image
    private static final int leftTopX = 0;
    private static final int leftTopY = 0;
    
    // Icon Size
    private final int width;
    private final int height;
    
    private String path;
    
    public int getIconWidth() {
        return width;
    }
    
    public int getIconHeight() {
        return height;
    }
    
    //Constructor
    JEightPuzzleFrame(String title, String path) {
        super(title);
        this.path = path;
        setLayout(new GridLayout(3, 3));
        setIcon();
        
        
        //Inputs the image into the buffer
        
        this.width = image.getWidth() / 3;
        this.height = image.getHeight() / 3;
        
        //Blank Blank
        Blank.setPreferredSize(new Dimension(this.width, this.height));
        
        //Create each button using i and j

        Board(false);
    }
    
    private void setIcon() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 2) {
                    //Do Nothing
                } else {
                    //Create a full image using extract icon
                    Icon icon = extractIcon(leftTopX + this.width * j, leftTopY + this.height * i);
                    button[i*3+j] = new JButton(icon); 		//Slaps a button with a icon
                    //Makes the size for each button
                    button[i*3+j].setPreferredSize(new Dimension(this.width, this.height));
                    button[i*3+j].addActionListener(this);
                
                    //Makes a name for each button to see which was called
                    button[i*3+j].setActionCommand("Button "+(i*3+j));
                }
            }
        }
    }
    
    //Creates a slice of the image to use as the button icon
    private Icon extractIcon(int leftTopX, int leftTopY){
        image = null;
        try {
            image = ImageIO.read(getClass().getResource(path));
        } catch(IOException e) {
            System.err.println("Image not found");
            System.exit(1);
        }
        //Makes a copy of an buffered image
        BufferedImage part = new BufferedImage(
                image.getWidth()/3, image.getHeight()/3, BufferedImage
                .TYPE_4BYTE_ABGR
        );
        
        //Copies the data from "image" to "part"
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                part.setRGB(x,y, image.getRGB(x+leftTopX, y+leftTopY));
            }
        }
        
        //Creates an icon whose content is already in "part"
        ImageIcon icon = new ImageIcon();
        icon.setImage(part);
        
        //Returns the icon to the caller
        return icon;
    }
    
    //Handles the button click events
    public void actionPerformed(ActionEvent event) {
        int row = 0;
        int col = 0;
        
        //Finds which button was clicked
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ID[i*3+j] == Integer.parseInt((event.getActionCommand().substring(7)))) {
                    row = i;
                    col = j;
                    i = 3;
                    j = 3;
                    break;
                }
            }
        }
        
        //Finds the Blank to and once found swaps the button and the Blank
        if ((row == 0 || row == 1) && layout[row + 1][col] instanceof JLabel) {
            Blank = layout[row + 1][col];
            layout[row + 1][col] = layout[row][col];
            layout[row][col] = Blank;
            
            ID[row*3+col] = 8;
            row++;
            ID[row*3+col] = Integer.parseInt((event.getActionCommand().substring(7)));
        } else if ((row == 1 || row == 2) && layout[row - 1][col] instanceof JLabel) {
            Blank = layout[row - 1][col];
            layout[row - 1][col] = layout[row][col];
            layout[row][col] = Blank;
            
            ID[row*3+col] = 8;
            row--;
            ID[row*3+col] = Integer.parseInt((event.getActionCommand().substring(7)));
        }
        
        if ((col == 0 || col == 1) && layout[row][col + 1] instanceof JLabel) {
            Blank = layout[row][col + 1];
            layout[row][col + 1] = layout[row][col];
            layout[row][col] = Blank;
            
            ID[row*3+col] = 8;
            col++;
            ID[row*3+col] = Integer.parseInt((event.getActionCommand().substring(7)));
        } else if ((col == 1 || col == 2) && layout[row][col - 1] instanceof JLabel) {
            Blank = layout[row][col - 1];
            layout[row][col - 1] = layout[row][col];
            layout[row][col] = Blank;
            
            ID[row*3+col] = 8;
            col--;
            ID[row*3+col] = Integer.parseInt((event.getActionCommand().substring(7)));
        }
        
        //remove then updates next order
        remove(layout[row][col]);
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(layout[i][j]);
            }
        }
        getContentPane().validate();
        
        //checks to see if in proper after each update
        Winner();
    }
    
    //Wins if in proper order
    private void Winner() {
        boolean win = false;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 2 && ID[8] != 8) {
                    win = false;
                    i = 3;
                    j = 3;
                    break;
                    //No Victory if not in the right order
                } else if (ID[i*3+j] != i*3+j) {
                    win = false;
                    i = 3;
                    j = 3;
                    break;
                } else
                    win = true;
            }
        }
        
        //Display Win and randomizes for another round
        if (win) {
            JOptionPane.showMessageDialog(null, "Congratulations. You Win", "Winner", JOptionPane.INFORMATION_MESSAGE);
            
            Board(true);
        }
    }
    
    //Layout to be displayed
    private void Board(boolean rand) {
        if (!rand) {
            layout[0][0] = Blank;
            ID[0] = 8;
            
            layout[0][1] = button[0];
            ID[1] = 0;
            
            layout[0][2] = button[1];
            ID[2] = 1;
            
            layout[1][0] = button[4];
            ID[3] = 4;
            
            layout[1][1] = button[5];
            ID[4] = 5;
            
            layout[1][2] = button[2];
            ID[5] = 2;
            
            layout[2][0] = button[3];
            ID[6] = 3;
            
            layout[2][1] = button[6];
            ID[7] = 6;
            
            layout[2][2] = button[7];
            ID[8] = 7;
        } else {
            //code to reset button order
            for (int i = 0; i < 9; i++)
                ID[i] = 10;
            
            do {
                int randomNum = ThreadLocalRandom.current().nextInt(9);
                
                //Randomizes number until all have been used
                for (int i = 0; i < 9; i++) {
                    if (ID[i] == 10) {
                        ID[i] = randomNum;
                        i = 10;
                    } else if (ID[i] == randomNum) {
                        i = 10;
                    }
                }
            } while (ID[8] == 10);	//ends loop at the end
        }
        
        //Removes buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                remove(layout[i][j]);
            }
        }
        
        //then re add in the new place
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ID[i*3+j] == 8) {
                    layout[i][j] = Blank;
                }
                else
                    layout[i][j] = button[ID[i*3+j]];
                add(layout[i][j]); //then finish up by adding the buttons
            }
        }
        getContentPane().validate();
    }
}
