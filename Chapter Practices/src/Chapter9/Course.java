package Chapter9;

public class Course {
    
    private int costPerCredit;
    private int credits;
    
    public Course(int costPerCredit, int credits) {
        this.costPerCredit = costPerCredit;
        this.credits = credits;
    }
    
    public int getCost() {
        return costPerCredit * credits;
    }
}
