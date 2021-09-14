/* THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING 
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Yu Fung David Wang
*/


public class ShapeTester {

  // returns true if the area of
  // the circle is bigger than (or equal to) the area of the rectangle,
  // false otherwise.
  public static boolean isLarger(Circle c, Rectangle r) {
    return c.getArea() >= r.area();
  }

  // returns the length of the perimeter of the longer of the two objects.
  public static double longerPerim(Circle c, Rectangle r) {
    if (c.getCircumference() > r.perimeter()) {
      return c.getCircumference();
    } else {
      return r.perimeter();
    }
  }

  // another version of the method longerPerim... purpose is so user can interchange rectangle and circle in parameters
  public static double longerPerim(Rectangle r, Circle c) { //swapped Circle c with Rectangle r
     if (r.perimeter() > c.getCircumference()) {
      return (r.perimeter());
    } else {
      return (c.getCircumference());
    }
  }


  // returns the area of the larger of the two objects.
  public static double largerArea(Circle c, Rectangle r) {
    if (isLarger(c, r) == true) {  //using previoulsy built method for finding larger area as boolean
      return (c.getArea());
    } else {
      return (r.area());
    }
  }

  // another version of the method largerArea
  public static double largerArea(Rectangle r, Circle c) {
    if (isLarger(c, r) == true) {  //using previoulsy built method for finding larger area as boolean
      return (c.getArea());
    } else {
      return (r.area());
    }
  }

  // returns true if the first circle contains the center of the second circle,
  // false otherwise.
  public static boolean containsCenter(Circle c1, Circle c2) {
    return c1.containsPoint(c2.x, c2.y);
  }


  // //testing
  // public static void main(String[] args) {
  //   Circle c = new Circle(0, 4, 5);
  //   Circle c1 = new Circle(5, 5, 5);
  //   Rectangle r = new Rectangle(5, 5, 5, 5);
  //   System.out.println(isLarger(c, r));
  //   System.out.println(longerPerim(c, r));
  //   System.out.println(longerPerim(r, c));
  //   System.out.println(largerArea(c, r));
  //   System.out.println(largerArea(r, c));
  //   System.out.println(containsCenter(c, c1));
  // }

}
