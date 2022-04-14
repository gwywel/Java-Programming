/*
* File: F1MathCS1.java
* Description: Prints out approximations of f'(a) for f(x)=x^2 using 7
* successively smaller values of delta x (starting at 1 and decreasing by a
* factor of 10 each iteration).
*/

import java.util.*;

public class F1MathCS1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Given a, this program approximates f'(a) for f(x)=x^2.");
		System.out.print("a=");

		double a = scan.nextDouble(); // read user input
		double dx = 1;

		System.out.println();

		for (int i = 0; i < 7; i++) {

			// calculate approximation of f'(a) using linear approximation formula
			double approximation = ((( a + dx ) * ( a + dx )) - (a * a)) / dx;

			// calculate error as the approximation of f'(a) - f(a)
			double error = approximation - (2 * a);

			// print results
			System.out.println("dx=10^-" + i);
			System.out.print("f'(" + a + ")~");
			System.out.println(approximation);
			System.out.println("error=" + error);

			dx /= 10; // decrease delta x by a factor of 10 each iteration

			System.out.println();

		}

	}

}
