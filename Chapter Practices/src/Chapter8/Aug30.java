package Chapter8;

class Test2{
  private int x;
  
  public Test2(int x){
    this.x = x;
  }
  
  public int getX() {
    return x;
  }
  
  public void setX(int x){
    this.x = x;
  }
}

class Test1{
  private Test2 input;
  public Test1(Test2 input){
    this.input = input;
  }
  
  public void change(int x){
    input.setX(x);
  }
  
  public  Test2 getInput(){
    return input;
  }
}

public class Aug30 {
  public static void main(String[] args) {
    Test2 test2 = new Test2(10);
    Test1 test1 = new Test1(test2);
    //Here test2 x is assigned the value of 10.
    //System.out.println(test2.getX());
    Test2  temp = test1.getInput();
    //Here temp is also assigned a 10, because it was created from
    //the previous test2 x value
    //System.out.println(temp.getX());
    //Here temp is set to 20
    temp.setX(20);
    System.out.println("Test2.x = " + test2.getX());
    test1.change(30);
    System.out.println("Temp.x = " + temp.getX());
    //This is going to print 30 as well, because it uses the getX
    //and this one uses this.x it changes the value of the
    //private int x in the Test2 class.
    //System.out.println(test2.getX());
  }
}
