package Lab3;

import java.util.Scanner;

public class Letter implements Package {
	
	private double numOfPages;
	
	@Override
	public double cost() {
		return (numOfPages*5)/100;
	}
	
	@Override
	public void input(Scanner scanner) {
		System.out.print("Please input the number of pages for the letter  " +
				"(pgs) :  ");
		numOfPages = scanner.nextDouble();
	
	}
}
