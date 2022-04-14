/*
* Description: This program prompts the user for the necessary elements in
* calculating an integral and Riemann sum of a quadratic function with their
* chosen coefficients. The user inputs coefficients a, b, and c, and the upper
* and lower limits of the integral they want to calculate, as well as the
* number of terms in a Riemann sum. The results from the QuadraticFunction
* class and the error between the integral and Riemann sum are printed at the
* end.
*/

import java.util.Scanner;

public class F3MathCS {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in); // create scanner object
    /* prompt the user for three coefficients */
    System.out.println("Enter three function coefficients.");
    System.out.print("a = ");
    double a = scan.nextDouble();
    System.out.print("b = ");
    double b = scan.nextDouble();
    System.out.print("c = ");
    double c = scan.nextDouble();

    /* create QuadraticFunction object with given coefficients */
    QuadraticFunction qf = new QuadraticFunction(a, b, c);
    System.out.println(qf); // prints toString format

    /* prompt the user for an upper and lower limit */
    System.out.println("Enter a range for a definite integral.");
    System.out.print("x1 = ");
    double x1 = scan.nextDouble(); // lower limit
    System.out.print("x2 = ");
    double x2 = scan.nextDouble(); // upper limit

    /* prompt the user for the number of terms in the Riemann sum */
    System.out.println("Enter the number of terms in a Riemann sum.");
    System.out.print("n = ");
    int n = scan.nextInt();

    /* prints value from calculating the Riemann sum */
    System.out.println("Area calculated by Riemann sums: " + qf.riemannSum(x1, x2, n));
    /* prints value from calculating the integral */
    System.out.println("Actual area: " + qf.integral(x1, x2));
    /* calculates and prints the difference, or error */
    System.out.println("Error: " + (qf.integral(x1, x2) - qf.riemannSum(x1, x2, n)));
  }

}
