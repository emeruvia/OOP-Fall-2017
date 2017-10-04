package Lab2;

/**
 * Public Class: Student
 * Date last modified: 10/3/2017
 */

/**
 * Public class GradTA, inherits instance variables and methods from
 * GradStudent class.
 */
public class GradTA extends GradStudent {
    
    private String taCourse;     //Course the user TA's for.
    private String taInstructor; //Name of the Instructor who user TA's for.
    private Date hireDate;       //Date object called hireDate.
    
    /**
     * GradTa() constructor, super constructor is called in the background,
     * then it calls readData().
     */
    public GradTA() {
        readData();
    }
    
    /**
     * readData() method, asks the user to input the value and then stores it
     * on their respective variables.
     */
    private void readData() {
        
        /*If-else statement verifies the users gender and assigns the respective
        value to it.*/
        if (gender == 'm') {
            genderPronoun = "his";
        } else if (gender == 'f') {
            genderPronoun = "her";
        }
        
        System.out.printf("Please input %s TA course: ", genderPronoun);
        this.taCourse = scanner.nextLine();
        System.out.printf("Please input %s TA instructor: ", genderPronoun);
        this.taInstructor = scanner.nextLine();
        System.out.printf("Please input %s hire date:%n", genderPronoun);
        
        //Date object hireDate is initialized.
        hireDate = new Date();
        
        
    }
    
    /**
     * Print() method, calls the superclass print method and then it prints
     * the new variables to the console.
     */
    public void print() {
    
        //Calls superclass method print().
        super.print();
        
        /*If-else statement verifies the users gender and assigns the respective
        value to it.*/
        if (gender == 'm') {
            genderPronoun = "His";
        } else if (gender == 'f') {
            genderPronoun = "Her";
        }
        
        System.out.printf("%s TA course is %s.%n" +
                        "%s TA instructor is %s.%n" +
                        "%s hire date is: ", genderPronoun, this.taCourse,
                genderPronoun, this.taInstructor, genderPronoun);
        hireDate.print();
    }
}
