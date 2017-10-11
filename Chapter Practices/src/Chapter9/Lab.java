package Chapter9;

public class Lab extends Course {

    private int fee;
    
    public Lab(int costPerCredit, int credits, int fee) {
        super(costPerCredit, credits);
        this.fee = fee;
    }
    
    @Override
    public int getCost() {
        return super.getCost() + fee;
    }

}
