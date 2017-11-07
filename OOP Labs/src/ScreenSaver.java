import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ScreenSaver extends JPanel
        implements ActionListener, MouseWheelListener {
    
    private int x[] = new int[60]; // x coordinates of edges
    private int y[] = new int[60]; // y coordinates of edges
    private int numOfPoints = 0; // how many end points have been
    // created for spiral
    private int radius = 10; // distance between the next end point
    // and the center
    private int delay = 1000; // how fast end points are added
    private Timer timer = null; // used to control drawing spiral
    private double centerX = -1;
    private double centerY = -1;
    
    /**
     * Creates timer and register mouse wheel event handlers.
     */
    public ScreenSaver() {
        this.addMouseWheelListener(this);
        timer = new Timer(delay, this);
        timer.start();
    }
    
    /**
     * Responds to mouse wheel scrolls.
     * Scrolling up the wheel will make it fast to draw the spiral.
     * Otherwise, it will be slower.
     */
    public void mouseWheelMoved(MouseWheelEvent e) {
        
        int wheelRotation = e.getWheelRotation();

        if (wheelRotation < 0) {
            delay += 10;
        } else {
            delay -= 10;
        }
        
        timer.setDelay(delay);
        timer.restart();
    }
    
    /**
     * Responds to the timer by adding an end point on the spiral.
     */
    public void actionPerformed(ActionEvent e) {
        
        addAPoint();
        
        if (numOfPoints == 59) {
            radius = 10;
        } else {
            radius += 5;
        }
        
        numOfPoints = (numOfPoints + 1) % 60;
        repaint();  //updates the panel
    }
    
    /**
     * Adds a point to the spiral.
     * The coordinates will be saved in the instance array variables:
     * x and y
     */
    private void addAPoint() {
        
        // getting the center of the screen
        if (centerX < 0) {
            centerX = getSize().getWidth() / 2;
        }
        
        if (centerY < 0) {
            centerY = getSize().getHeight() / 2;
        }
        
        // finding the coordinates of the new point
        double x = centerX + Math.cos(numOfPoints * Math.PI / 3) * radius;
        double y = centerY + Math.sin(numOfPoints * Math.PI / 3) * radius;
        
        // saving the point for display
        this.x[numOfPoints] = (int) x;
        this.y[numOfPoints] = (int) y;
    }
    
    /**
     * Draws the spiral in the x and y arrays
     */
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, (int) getSize().getWidth()
                , (int) getSize().getHeight());
        g.drawPolyline(x, y, numOfPoints);
    }
}
