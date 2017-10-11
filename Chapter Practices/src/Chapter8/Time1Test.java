package Chapter8;

public class Time1Test {
    
    public static void main(String[] args) {
        Time1 time1 = new Time1();
        Time2 time2 = new Time2(12,3, 57);
        time1.setTime(7,45,23);;
        
        System.out.println(time1);
        System.out.println(time2);
        time2 = new Time2();
        System.out.println(time2);

    }
    
}
