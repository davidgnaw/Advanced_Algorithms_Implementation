/* THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING 
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Yu Fung David Wang
*/

// This class represents a circle shape
public class Circle {

    // Instance variables (data members) of class Circle
    protected double radius; // the radius of the circle
    protected double x; // the x coordinate of the circle's center
    protected double y; // the y coordinate fo the circle's center

    // The default constructor with no argument
    public Circle(){
      // Initializing the values of the instance variables
      radius = 1.0;
      x = 0.0;
      y = 0.0;
    }

    // Second constructor with given radius, but origin default
    public Circle(double r) {
      radius = r;
      x = 0.0;
      y = 0.0;
    }

    // Overload constructor 
    public Circle(double r, double ex, double why) {
    	radius = r;
        x = ex;
        y = why;
    }

    // A public getter method for retrieving the radius
    public double getRadius() {
     return radius;
    }

    // A public getter method for retrieving the center coordinates
    public double[] getCenter() {
     double[] c = {this.x, this.y};
     return c;
    }

    // A public getter method for computing and returning
    // the area of the circle
    public double getArea() {
      return radius * radius * Math.PI;
    }

    // Compute circumference
    public double getCircumference() {
    	return 2 * Math.PI * radius;
    }

    // Compares the area of 2 circles, a.isBiggerThan(b); gives true if a has greater area than b
    // false if b has greater area than a
    public boolean isBiggerThan(Circle circleB) {
      double areaA = this.getArea();
      double areaB = circleB.getArea();

      return areaA > areaB;

    }

    // returns true if the (x, y) coordinate input is inside the current circle, false otherwise.
    public boolean containsPoint(double x, double y) {
    	double circleEquation = Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2);
        double radiusSquared = Math.pow(this.radius, 2);

        return circleEquation <= radiusSquared;
    }

    // sets Radius
    public void setRadius (double radius) {
        this.radius = radius;
    }

    // sets Center (x, y)
    public void setCenter (double ex, double why) {
        this.x = ex;
        this.y = why;
    }

    // toString Override method to print center and radius
    @Override
    public String toString() {
        return "This circle is centered at point "+ "(" + this.x + ", " + this.y + ") with radius " + this.radius; 
    }

    // //testing 
    // public static void main(String[] args) {
    //     Circle circleA = new Circle(3, 0, 0);
    //     Circle circleB = new Circle(4, 5, 3);
    //     System.out.println(circleA.isBiggerThan(circleB));
    //     System.out.println(circleA.containsPoint(2, Math.sqrt(5)));
    //     circleB.setRadius(5);
    //     circleB.setCenter(6, 4);
    //     System.out.println(circleB.radius + " " + circleB.x + " " + circleB.y);
    //     System.out.println(circleB.toString());
    // }
}
