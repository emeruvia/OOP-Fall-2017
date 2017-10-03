package Lab2;

import java.util.Scanner;

public class Student {
    
    public final static Scanner scanner = new Scanner(System.in);
    
    
    private String name;
    private int ssn;
    private int numOfCourses;
    private Date birthDate;
    protected char gender;
    protected String genderPronoun;
    
    
    //Constructor with no parameter
    public Student () {
        readData();
    }
    
    //reads data to assign to instance variables from the console window
    private void readData() {
        System.out.print("Please input the name: ");
        this.name = scanner.nextLine();
        System.out.print("Please input the ssn: ");
        this.ssn = scanner.nextInt();
        System.out.print("Male/Female (m/f): ");
        this.gender = scanner.next().charAt(0);
        if (this.gender == 'm') {
            genderPronoun = "he";
        } else if (this.gender == 'f') {
            genderPronoun = "she";
        }
        System.out.printf("How many courses %s is taking: ", genderPronoun);
        this.numOfCourses = scanner.nextInt();
        scanner.nextLine();
        birthDate = new Date();
    }

    //prints the values of instance variables to the standard output
    public void print() {
        if (this.gender == 'm') {
            genderPronoun = "He";
        } else if (this.gender == 'f') {
            genderPronoun = "She";
        }
        System.out.printf("%nThe information you input was %n" +
                "%s's ssn is %d%n" +
                "%s is taking %d courses.%n", this.name, this.ssn,
                genderPronoun, this.numOfCourses);
        if (this.gender == 'm') {
            genderPronoun = "His";
        } else if (this.gender == 'f') {
            genderPronoun = "Her";
        }
        System.out.printf( "%s birth date is ", genderPronoun);
        birthDate.print();
    }
}
