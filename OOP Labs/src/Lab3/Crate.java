package Lab3;

import java.util.Scanner;

/**
 * Abstract class: Crate
 * Implements: Package
 * Last date modified: 10/11/2017
 */
abstract class Crate implements Package {
	
	private double weight;
    
    /**
     * Cost() method calculates the price of the Crate shipment.
     * @return cost value by multiplying number of pages by 5 and then
     * dividing it by 100.
     */
	@Override
	public double cost() {
		if (getClass().getSimpleName().equals("MetalCrate")) {
			return weight * 1.3;
		} else {
			return weight * 1.4;
		}
	}
	
	/**
	 * Input() method asks and takes the value of the weight for the box.
	 * @param scanner
	 */
	@Override
	public void input(Scanner scanner) {
		System.out.print("Please input the weight for the " + getClass()
				.getSimpleName() + "  (lbs) :  ");
		weight = scanner.nextDouble();
	}
}
