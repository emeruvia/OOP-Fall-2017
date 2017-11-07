import oracle.jrockit.jfr.JFR;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class JEightPuzzle extends JFrame implements ActionListener {
    
    private BufferedImage image;
    private int width;
    private int height;
    private int startX;
    private int startY;
    private String path;
    
    private JPanel mainPanel;
    private JPanel emptyButton = new JPanel();
    private ArrayList number = new ArrayList();
    private JButton[] buttons = new JButton[8];
    private Icon icons[] = new Icon[8];
    private int initPosition[] = {0, 1, 4, 5, 2, 3, 6, 7};
    private int indexPosition[] = new int[9];
    
    
    public static void main(String[] args) {
        JEightPuzzle puzzle =
                new JEightPuzzle("JEightPuzzle", "FGCU_logo.png");
    }
    
    private JEightPuzzle(String title, String path) {
        super(title);
        this.path = path;
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 3));
        
        for (int i = 0; i < 9; i++) {
            System.out.println("Position: " + indexPosition[i]);
        }
        
        iconImage();
        
        initPuzzle(icons);
//        randomizePuzzle(icons);
        
        System.out.println();
        
        for (int i = 0; i < 9; i++) {
            System.out.println("Position: " + indexPosition[i]);
        }
        
        add(mainPanel);
        setSize(image.getWidth() + 20, image.getHeight() + 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        setResizable(false);
        setVisible(true);
    }
    
    private Icon extractIcon(int leftTopX, int leftTopY) {
        image = null;
        try {
            image = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            System.err.println("Image not found");
            System.exit(1);
        }
        width = image.getWidth() / 3;
        height = image.getHeight() / 3;
        BufferedImage part = new BufferedImage(
                width, height, BufferedImage.TYPE_4BYTE_ABGR
        );
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                part.setRGB(x, y, image.getRGB(x + leftTopX, y + leftTopY));
            }
        }
        
        ImageIcon icon = new ImageIcon();
        icon.setImage(part);
        return icon;
    }
    
    private void iconImage() {
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
            icons[i] = extractIcon(startX, startY); //finds the icon
            
        }
    }
    
    private void initPuzzle(Icon icon[]) {
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 2) {
                
                } else {
                    buttons[i*3 + j] = new JButton()
                }
            }
        }
        
        
//        mainPanel.add(emptyButton);
//        indexPosition[0] = 9;
//        for (int i = 0; i < 8; i++) {
//            buttons[i] = new JButton(icon[initPosition[i]]);
//            mainPanel.add(buttons[i]);
//            buttons[i].addActionListener(this);
//            buttons[i].setName(String.valueOf(i));
//            indexPosition[i + 1] = initPosition[i];
//        }
    }
    
    private void randomizePuzzle(Icon icon[]) {
        mainPanel.add(emptyButton);
        indexPosition[0] = 9;
        for (int i = 0; i < 8; i++) {
            number.add(i);
        }
        Collections.shuffle(number);
        for (int i = 0; i < 8; i++) {
            buttons[i] = new JButton(icon[(int) number.get(i)]);
            mainPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
            indexPosition[i + 1] = (int) number.get(i);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        //System.out.println(button);
        int emptyPosition = 0;
        int buttonClicked = Integer.valueOf(button.getName());
        for (int i = 0; i < 9; i++) {
            if (indexPosition[i] == 9) {
                emptyPosition = i;
            }
        }
        switch (emptyPosition) {
            case 0:
                if (buttonClicked == emptyPosition) {
                    mainPanel.removeAll();
                    for (int i = 0; i < 8; i++) {
                        if (i != buttonClicked) {
                            mainPanel.add(buttons[i]);
                        } else {
                            mainPanel.add(buttons[buttonClicked]);
                            mainPanel.add(emptyButton);
                            indexPosition[emptyPosition] = 1;
                        }
                    }
                    mainPanel.setVisible(false);
                    break;
                } else if (buttonClicked == emptyPosition + 2) {
                    mainPanel.removeAll();
                    for (int i = 0; i < 8; i++) {
                        if (i != buttonClicked) {
                            mainPanel.add(buttons[i]);
                        } else {
                            mainPanel.add(buttons[buttonClicked]);
                            mainPanel.add(emptyButton);
                        }
                    }
                    mainPanel.setVisible(false);
                    break;
                }
                
            default:
                break;
        }
        mainPanel.setVisible(true);
        mainPanel.validate();
//        for (int i = 0; i < 9; i++) {
//            if (emptyPosition == 0) {
//                for (int j = 0;j < 8; j++) {
//
//                    if (indexPosition[emptyPosition+1]) {
//
//                    }
//                }
//            }
//        }
    
    
    }
}
