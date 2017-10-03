package Lab2;

import com.sun.org.apache.xpath.internal.SourceTree;

public class GradTA extends GradStudent {
    
    private String taCourse;
    private String taInstructor;
    private Date hireDate;
    
    //Constructor with no parameter
    public GradTA () {
        readData();
    }
    
    //reads data to assign to instance variables from the console window
    private void readData() {
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
        hireDate = new Date();
        
    
    }
    
    //prints the values of instance variables to the standard output
    public void print() {
        super.print();
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
