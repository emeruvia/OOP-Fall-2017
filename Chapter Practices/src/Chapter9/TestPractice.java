package Chapter9;

public class TestPractice {
    public static void main(String[] args) {
        Test2 test2 = new Test2(10);
        Test1 test1 = new Test1(test2);
        Test2 temp = test1.getInput();
        temp.setX(20);
        System.out.println("test2.x = " + test2.getX());
        test1.change(30);
        System.out.println("temp.x = " + temp.getX());
        
    }
}

class Test2 {
    private int x;
    
    public Test2(int x) {
        this.x = x;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
}

class Test1 {
    private Test2 input;
    
    public Test1(Test2 input) {
        this.input = input;
    }
    public void change(int x) {
        input.setX(x);
    }
    public Test2 getInput() {
        return input;
    }
}