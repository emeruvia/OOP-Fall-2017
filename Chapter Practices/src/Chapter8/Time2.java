package Chapter8;

public class Time2 {
    private int hour;
    private int minute;
    private int second;
    
    public Time2() {
        this(0, 0, 0);  //Calls the constructor
    }
    
    public Time2(int h, int m, int s) {
        setTime(h, m, s);
    }
    
    public void setTime(int h, int m, int s) {
        hour = ((h>=0 && h <= 24) ? h:hour);
        minute = ((m>=0 && m <= 60) ? m:minute);
        second = ((s>=0 && s <= 60) ? s:second);
    }
    
    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((hour==0|| hour==12)?12:hour%12),
                minute,
                second,
                (hour<12?"AM":"PM"));
    }
}
