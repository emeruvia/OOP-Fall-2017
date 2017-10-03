package Lab2;

public class GradStudent extends Student {
    
    private String researchTopic;
    private String advisor;
    
    
    //Constructor with no parameter
    public GradStudent () {
        readData();
    }
    
    //reads data to assign to instance variables from the console window
    private void readData() {
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
    
    //prints the values of instance variables to the standard output
    public void print() {
        super.print();
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
