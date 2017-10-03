package Lab2;

import java.util.Scanner;

public class Date {
    
    public final static Scanner scanner = new Scanner(System.in);
    
    private int year;
    private int month;
    private int day;
    
    public Date() {
        readData();
    }
    
    //Reads data to assign to instance variables from the console window
    private void readData() {
        System.out.print("\tPlease input the month: ");
        this.month = scanner.nextInt();
        System.out.print("\tPlease input the day: ");
        this.day = scanner.nextInt();
        System.out.print("\tPlease input the year: ");
        this.year = scanner.nextInt();
        
    }
    
    //prints the values of instance variables to the standard output
    public void print() {
        System.out.printf("%d/%d/%d", this.month, this.day, this.year);
    }
}
