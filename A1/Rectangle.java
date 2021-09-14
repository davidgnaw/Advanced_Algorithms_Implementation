/* THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING 
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Yu Fung David Wang
*/


// This class represents a rectangle shape
public class Rectangle {

		private double L; // the length of the rectangle
		private double H; // the height of the rectangle
		private double x; // the x coordinate of the  bottom left corner of the rectangle
		private double y; // the y coordinate of the bottom left corner of the rectangle

		//x and y is for the bottom left corner of the rectangle
		public Rectangle() {
			L = 1;
			H = 1;
			x = 0.0;
			y = 0.0;
		}

		public Rectangle(double Ell, double Eich, double Ex, double Why) {
			L = Ell;
			H = Eich;
			x = Ex;
			y = Why;

		}

		public double getLength() {
			return L;
		}

		public double getHeight() {
			return H;
		}

		public void setLength(double Ell) {
			L = Ell;
		}

		// called Eich and uses it to set the height of the rectangle.
		public void setHeight(double Eich) {
			H = Eich;
		}

		// the perimeter of the rectangle.
		public double perimeter() {
			return 2 * (L + H);
		}


		// area of the rectangle.
		public double area() {
			return L * H;
		}

		// //testing
		// public static void main(String[] args) {
		// 	Rectangle r = new Rectangle(4, 3, 2, 2);
		// 	r.setLength(5);
		// 	r.setHeight(4);
		// 	System.out.println(r.getHeight());
		// 	System.out.println(r.perimeter());
		// 	System.out.println(r.area());
		// }

}
