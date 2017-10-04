package Lab2;

/**
 * Public Class: Student
 * Date last modified: 10/3/2017
 */

/**
 * Public class GradStudent, inherits instance variables and methods from
 * Student class.
 */
public class GradStudent extends Student {
    
    private String researchTopic;   //"Object Oriented Programming"
    private String advisor;         //Name of user's advisor.
    
    /**
     * GradStudent() constructor, super constructor is called in the background,
     * then it calls readData() method.
     */
    public GradStudent() {
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
        
        System.out.printf("Please input %s research topic: ", genderPronoun);
        this.researchTopic = scanner.nextLine();
        System.out.printf("Please input %s research advisor: ", genderPronoun);
        this.advisor = scanner.nextLine();
        
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
        
        System.out.printf("%n%s research topic is %s%n" +
                "%s advisor is %s%n", genderPronoun, this.researchTopic,
                genderPronoun, this.advisor);
    }
}
