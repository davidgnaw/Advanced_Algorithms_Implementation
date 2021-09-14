/* THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING 
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Yu Fung David Wang
*/

public class Cylinder extends Circle {

	protected double z;
	protected double height;

	public Cylinder() { //default constructor
		x = 0.0;
		y = 0.0;
		z = 0.0;
		height = 1.0;
		radius = 1.0;
	}

	//argument constructor
	public Cylinder(double ex, double why, double r, double h) {
		x = ex;
		y = why;
		radius = r;
		height = h;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double h) {
		height = h;
	}

	@Override
	public double getArea() {
		double first = super.getCircumference() * height; // first part of equation
		double second = 2 * super.getArea(); //second part of equation
		return first + second;
	}

	public double getVolume() {
		return super.getArea() * height; //Cylinder Volume equation
	}

	// // test
	// public static void main(String[] args) {
	// 	Cylinder cir = new Cylinder(3, 3, 5, 10);
	// 	cir.setHeight(20);
	// 	System.out.println(cir.getHeight());
	// 	System.out.println(cir.getArea());
	// 	System.out.println(cir.getVolume());
	// }
}