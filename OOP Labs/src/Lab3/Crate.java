package Lab3;

import java.util.Scanner;

abstract class Crate implements Package {
	
	private double weight;
	
	@Override
	public double cost() {
		if (getClass().getSimpleName().equals("MetalCrate")) {
			return weight * 1.3;
		} else {
			return weight * 1.4;
		}
	}
	
	@Override
	public void input(Scanner scanner) {
		System.out.print("Please input the weight for the " + getClass()
				.getSimpleName() + "  (lbs) :  ");
		weight = scanner.nextDouble();
	}
}
