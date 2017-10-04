package Lab2;

import java.util.Scanner;

/**
 * Public Class: Student
 * Date last modified: 10/3/2017
 */

/**
 * Public class Student
 */
public class Student {
    
    //Global scanner object, it is inherited by all sub-classes.
    final static Scanner scanner = new Scanner(System.in);
    
    private String name;            //"first name and last name"
    private int ssn;                //Social security number
    private int numOfCourses;       //Number of courses
    private Date birthDate;         //Date object called birthDate
    protected char gender;          //"male or female"
    protected String genderPronoun; //"He, his, She, her"
    
    /**
     * Class constructor, calls readData() method.
     */
    public Student () {
        readData();
    }
    
    /**
     * readData() method, asks the user to input the value and then stores it
     * on their respective variables.
     */
    private void readData() {
        System.out.print("Please input the name: ");
        this.name = scanner.nextLine();
        System.out.print("Please input the ssn: ");
        this.ssn = scanner.nextInt();
        System.out.print("Male/Female (m/f): ");
        this.gender = scanner.next().charAt(0);
        
        /*If-else statement verifies the users gender and assigns the respective
        value to it.*/
        if (this.gender == 'm') {
            genderPronoun = "he";
        } else if (this.gender == 'f') {
            genderPronoun = "she";
        }
        
        System.out.printf("How many courses %s is taking: ", genderPronoun);
        this.numOfCourses = scanner.nextInt();
        scanner.nextLine();
        
        //Date object birthDate is initialized.
        birthDate = new Date();
    }
    
    /**
     * Print() method, prints the users info to the console.
     */
    public void print() {
        
        /*If-else statement verifies the users gender and assigns the respective
        value to it.*/
        if (this.gender == 'm') {
            genderPronoun = "He";
        } else if (this.gender == 'f') {
            genderPronoun = "She";
        }
        
        System.out.printf("%nThe information you input was %n" +
                "%s's ssn is %d%n" +
                "%s is taking %d courses.%n", this.name, this.ssn,
                genderPronoun, this.numOfCourses);
        
        /*If-else statement verifies the users gender and assigns the respective
        value to it.*/
        if (this.gender == 'm') {
            genderPronoun = "His";
        } else if (this.gender == 'f') {
            genderPronoun = "Her";
        }
        
        System.out.printf( "%s birth date is ", genderPronoun);
        birthDate.print();
    }
}
