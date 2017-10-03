package Chapter10; /**
 * FileName:PolymorphismEx.java 
 * Author: Dahai Guo
 * Created: September 1, 2008
 * Last Modified: September 8, 2016
 * 
 * Included class:
 * <li>
 * <ol> TwoDShape
 * <ol> Circle
 * <ol> Rectangle
 * <ol> Triangle
 * </li>
 */

import java.util.*;

import java.lang.*;
/**
 * Is an abstract class with one abstract method: draw.
 * 
 * @author Dahai Guo
 */
abstract class TwoDShape {
	
	/**
	 * Undefined in this class.
	 */
	public abstract void draw();
}

/**
 * Extends TwoDShape and is incomplete.
 * 
 * This class declares x and y coordinates
 * 
 * @author Dahai Guo
 *
 */
abstract class Trapezoid extends TwoDShape{
	protected double x[] = new double[4];// x coordinates of end points
	protected double y[] = new double[4];// y coordinates of end points	

	/**
	 * Copies input to the instance variables: x and y.
	 * 
	 * Assumes points are in counter clockwise order
	 * 
	 * @param x input x coordinates
	 * @param y input y coordinates
	 */
	Trapezoid(double x[], double y[]) {
		for (int i = 0; i < 4; i++) {
			this.x[i] = x[i];
			this.y[i] = y[i];
		}
	}
}

/**
 * Extends Trapezoid and requires that each angle is a right angle.
 * 
 * @author Dahai Guo
 *
 */
class Rectangle extends Trapezoid {

	/**
	 * Copies input to the instance variables: x and y and verifies
	 * the points comprise a rectangle
	 * 
	 * Assumes points are in counter clockwise order.
	 * 
	 * @param x input x coordinates
	 * @param y input y coordinates
	 */
	Rectangle(double x[], double y[]){
		super(x,y); // calling Trapezoid's constructor
		
		// verifying angles using cross-product
		for(int i=1;i<=3;i++){
			double deltaX1=x[(i+1)%4]-x[i];
			double deltaY1=y[(i+1)%4]-y[i];
			double deltaX2=x[(i-1)%4]-x[i];
			double deltaY2=y[(i-1)%4]-y[i];
			
			if(Math.round(deltaX1*deltaX2+deltaY1*deltaY2)!=0){
				// terminate the program
				throw new RuntimeException("Bad input to Rectangle");
			}
		}
	}
	
	/**
	 * Prints coordinates of end points
	 */
	public void draw() {
		System.out.printf("Rectangle: (%.2f,%.2f), (%.2f,%.2f), "
				+ "(%.2f,%.2f), (%.2f,%.2f)\n", 
				x[0], y[0], x[1], y[1], 
				x[2], y[2], x[3], y[3]);
	}
}

/**
 * Extends TwoDShape and is defined by center point and radius.
 * 
 * @author Dahai Guo
 *
 */
class Circle extends TwoDShape {
	private double x; // x coordinate of center point
	private double y; // y coordinate of center point
	private double radius;

	/**
	 * Initializes instance variables using external inputs.
	 * 
	 * @param x
	 * @param y
	 * @param radius
	 */
	Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	/**
	 * Prints center point coordinate and radius
	 */
	public void draw() {
		System.out.printf("Circle: center at (%.2f,%.2f), radius=%.2f\n", x, y,
				radius);
	}
}

/**
 * Extends TwoDShape and is defined by three end points.
 * 
 * @author Dahai Guo
 *
 */
class Triangle extends TwoDShape {
	private double x[] = new double[3]; // x coordinates of end points
	private double y[] = new double[3]; // y coordinates of end points 

	/**
	 * Copies input to the instance variables: x and y. 
	 * 
	 * @param x input x coordinates
	 * @param y input y coordinates
	 */
	Triangle(double x[], double y[]) {
		for (int i = 0; i < 3; i++) {
			this.x[i] = x[i];
			this.y[i] = y[i];
		}
	}

	/**
	 * Prints coordinates of end points
	 */
	public void draw() {
		System.out.printf("Triangle: (%.2f,%.2f), (%.2f,%.2f), (%.2f,%.2f)\n",
				x[0], y[0], x[1], y[1], x[2], y[2]);
	}
}

public class PolymorphismEx {
	/**
	 * Creates a TwoDShape based object. 
	 * 
	 * The type of object is decided at the run time. The dimension of the
	 * shape is random too.
	 * 
	 * @return a TwoDShape reference 
	 */
	public static TwoDShape create_a_shape() {
		Random rand = new Random();
		int i = 0;
		double x4[] = new double[4];
		double y4[] = new double[4];
		double x3[] = new double[3];
		double y3[] = new double[3];

		TwoDShape shape;

		switch (rand.nextInt(1000) % 3) {
		case 0:
			shape = new Circle(rand.nextInt(1000), 
					rand.nextInt(1000), rand.nextInt(1000));
			break;
		case 1:
			x4[0] = rand.nextInt(1000);
			y4[0] = rand.nextInt(1000);
			int width = rand.nextInt(1000);
			int height = rand.nextInt(1000);
			x4[1] = x4[0]; y4[1] = y4[0]+height;
			x4[2] = x4[0]+width; y4[2] = y4[0]+height;
			x4[3] = x4[0]+width; y4[3] = y4[0];

			shape = new Rectangle(x4, y4);
			break;
		default:
			for (i = 0; i < 3; i++) {
				x3[i] = rand.nextInt(1000);
				y3[i] = rand.nextInt(1000);
			}
			shape = new Triangle(x3, y3);
			break;
		}
		return shape;
	}

	/**
	 * Is a testing driver which creates five shape-based objects randomly and
	 * method draw is called on each.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		TwoDShape shapes[] = new TwoDShape[5];

		// randomly creating five shapes
		for (int i = 0; i < 5; i++) {
			shapes[i] = create_a_shape();
		}

		for (int i = 0; i < 5; i++) {
			// which "draw" to invoke is determined
			// at the run time
			shapes[i].draw();
		}
	}
}