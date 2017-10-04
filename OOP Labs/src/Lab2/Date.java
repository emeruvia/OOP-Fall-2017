package Lab2;

import java.util.Scanner;

/**
 * Public class Date.
 */
public class Date {
    
    //Creates a scanner object that can only be accessed within this class.
    private final static Scanner scanner = new Scanner(System.in);
    
    private int year;
    private int month;
    private int day;
    
    /**
     * Date() constructor.
     */
    public Date() {
        readData();
    }
    
    /**
     * readData() method, asks the user to input the value and then stores it
     * on their respective variables.
     */
    private void readData() {
        System.out.print("\tPlease input the month: ");
        this.month = scanner.nextInt();
        System.out.print("\tPlease input the day: ");
        this.day = scanner.nextInt();
        System.out.print("\tPlease input the year: ");
        this.year = scanner.nextInt();
        
    }
    
    /**
     * Print() method, prints the users info to the console.
     */
    public void print() {
        System.out.printf("%d/%d/%d", this.month, this.day, this.year);
    }
}
