package Midterm;

/**
 * Question #5, Midterm OOP Fall 2017
 */
public class Height {
    
    private int feet;
    private int inches;
    
    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }
    
    public void growAnInch() {
        inches++;
        feet= feet + (inches/12);
        inches = inches%12;
        /*if (inches < 12) {
        *   inches++;
        *} else {
        *   feet++;
        *}*/
    }
    
    public String toString() {
        return (this.feet + "'" + this.inches + "\"");
    }
    
    
    
    
}
