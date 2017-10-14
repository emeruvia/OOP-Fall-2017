package Lab3;

import java.util.Scanner;

/**
 * Public class: Letter
 * Implements: Package
 * Last date modified: 10/11/2017
 */
public class Letter implements Package {
	
	private int numOfPages;
    
    
    /**
     * Cost() method calculates the price of the letter shipment.
     * @return cost value by multiplying number of pages by 5 and then
     * dividing it by 100.
     */
	@Override
	public double cost() {
		return (numOfPages*5)/100;
	}
	
	/**
	 * Input() method asks and takes the value of the weight for the letter
     * package.
	 * @param scanner
	 */
	@Override
	public void input(Scanner scanner) {
		System.out.print("Please input the number of pages for the letter  " +
				"(pgs) :  ");
		numOfPages = scanner.nextInt();
	
	}
}
