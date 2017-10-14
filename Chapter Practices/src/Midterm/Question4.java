package Midterm;

/**
 * Question #4 on Midterm, OOP Fall 2017
 */
public class Question4 {
    public static void main(String[] args) {
        Car car = new HybridCar("abc123", "Ford") {
            //Error, start method was never initialized.
            @Override
            public void start() {
                System.out.println("Button Start.");
            }
        };
        car.start();
        car.power();
    }
}

//Error, class should be abstract
abstract class Car {
    private String vin;
    private String make;
    
    //getters for the instance variables so they can be accessed in the
    // subclasses
    public String getVin() {
        return vin;
    }
    public String getMake() {
        return make;
    }
    
    public Car(String vin, String make) {
        this.vin = vin;
        this.make = make;
    }
    
    public abstract void start();
    public abstract void power();
}

//Erros, because the superclass is abstract, the subclass should be abstract too
abstract class HybridCar extends Car {
    public HybridCar(String vin, String make) {
        super(vin, make);
    }
    
    public void power() {
        System.out.println("battery and gas.");
    }
    public String toString() {
        //getters for car instance variables.
        return String.format("Vin:: %s, make: %s, Hybrid", getVin(), getMake());
    }
}