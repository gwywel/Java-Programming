/*
* File: QuadraticFunction.java
* Description: This program contains the methods required to calculate the
* Riemann sum and integral of the quadratic function provided by the user's
* input in the main method. The QuadraticFunction contructor stores the
* given parameters as constants. The toString method displays a readable
* version of the function for the user. The methods that follow contain
* calculations that can be called from the main method for a particular
* QuadraticFunction object.
*/

public class QuadraticFunction {

	/* private instance variables */
	private final double A;
	private final double B;
	private final double C;

	/* QuadraticFunction object constructor */
	public QuadraticFunction(double a, double b, double c) {
		this.A = a;
		this.B = b;
		this.C = c;
	}

	/* displays QuadraticFunction object as a readable string */
	public String toString() {
		return "You have constructed the function f(x) = " + A + "*x^2 + " + B
		+ "*x + " + C;
	}

	/* evaluates the quadratic function at a certain point; to be used in
	calculating the Riemann sum */
	public double evaluationAt(double x) {
		return A * (x * x) + B * x + C;
	}

	/* evaluates the integral of the quadratic function given an upper and
	lower limit */
	public double integral(double x1, double x2) {
		return ((A * (x2 * x2 * x2)) / 3 + (B * (x2 * x2)) / 2 + C * x2) -
		((A * (x1 * x1 * x1)) / 3 + (B * (x1 * x1)) / 2 + C * x1);
	}

	/* evaluates the Riemann sum given the upper and lower limit and the number
	of terms, n */
	public double riemannSum(double x1, double x2, int n) {
		double delx = (x2 - x1) / n; // calculates delta x
		double sum = 0;
		for (int i = 0; i < n; i++) { // for every value i until n
			sum += evaluationAt(x1 + i * delx) * delx; // adds value to the existing summation
		}
		return sum;
	}

	/* public getter methods */

	public double getA() {
		return A;
	}

	public double getB() {
		return B;
	}

	public double getC() {
		return C;
	}

}
