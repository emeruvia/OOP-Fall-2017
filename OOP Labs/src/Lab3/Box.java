package Lab3;

import java.util.Scanner;

public class Box implements Package {
	
	private double weight;
	
	@Override
	public double cost() {
		return weight * 1.2;
	}
	
	@Override
	public void input(Scanner scanner) {
		System.out.print("Please input the weight for the Box  (lbs)  : ");
		weight = scanner.nextDouble();
		
	}
}
