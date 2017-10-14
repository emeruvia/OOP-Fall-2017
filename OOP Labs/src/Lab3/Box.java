package Lab3;

import java.util.Scanner;

/**
 * Public class: Box
 * Implements: Package
 * Last date modified: 10/11/2017
 */
public class Box implements Package {

	private double weight;
	
	/**
	 * Cost() method calculates the price of the box shipment.
	 * @return cost value by multiplying weight * 1.2.
	 */
	@Override
	public double cost() {
		return weight * 1.2;
	}
	
	/**
	 * Input() method asks and takes the value of the weight for the box.
	 * @param scanner
	 */
	@Override
	public void input(Scanner scanner) {
		System.out.print("Please input the weight for the Box  (lbs)  : ");
		weight = scanner.nextDouble();
	}
}
