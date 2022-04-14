/*
* File: F1MathCS2.java
* Description: Using successively smaller values of delta x, prints out as many
* approximations of f'(a) for f(x) = ln(x) as necessary to get the error of the
* approximation less than 1/1,000,000. In addition to the values of delta x and
* associated approximations, also reports the errors.
*/


import java.util.*;

public class F1MathCS2 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Given a, this program approximates f'(a) for f(x)=ln x.");
		System.out.print("a=");

		double a = scan.nextDouble(); // read user input
		double dx = 1;
		double error = 1;

		int power = 0;

		System.out.println();

		while (error > 0.000001) {

			// compute approximation of f'(a) using linear approximation formula
			double approximation = (Math.log(a + dx) - Math.log(a)) / dx;

			// true value of dy/dx (ln(a))
			double true_derivative = (1 / a);

			// computes absolute value of the error
			error = Math.abs(approximation - true_derivative);

			// decrease delta x by a factor of 10 each iteration
			dx /= 10;

			// print results
			System.out.println("dx=10^-" + power);
			System.out.print("f'(" + a + ")~");
			System.out.println(approximation);
			System.out.println("error=-" + error);

			System.out.println();

			power++;

		}

	}

}
