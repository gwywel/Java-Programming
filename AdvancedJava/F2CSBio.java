/*
* File: F2CSBio.java
* Description: This program reads in a number of generations and list of
* growth rates from its arguments and outputs a table of population sizes,
* with a row of growth rates followed by one row per generation and one
* column per growth rate. Growth rates correspond to the multiplicative factor
* by which the population grows. Subsequent population sizes are displayed as
* integer values rounded down.
*/

public class F2CSBio {

	public static final int INITIAL_POPULATION = 10;

	public static void main(String[] args) {

		// get number of generations from arguments
		int gen = Integer.parseInt(args[0]);

		// get number of arguments following first argument
		double[] rates = new double[args.length-1];

		// output first row containing rates
		for (int i = 1; i < args.length; i++) {
			rates[i-1] = Double.parseDouble(args[i]);
			System.out.print(rates[i-1] + ",");
		}
		System.out.println();

		// get number of columns
		int cols = rates.length;

		/* create 2-dimensional populations table with rows corresponding
		with number of generations and columns corresponding with the
		number of growth rates to simulate*/
		int[][] table = new int[gen][cols];

		// store final int value as an int that can be changed
		int population = INITIAL_POPULATION;

		// output second row containing the initial populations
		for (int i = 0; i < cols; i++) {
			table[0][i] = population;
			System.out.print(table[0][i] + ",");
		}
		System.out.println();

		/* interate through generations and rates, assigning a new value
		to population by its multiplicative factor and outputing that value */
		for (int i = 1; i < gen; i++) {
			for (int j = 0; j < cols; j++) {
				population = table[i-1][j];
				population *= rates[j];
				table[i][j] = population;
				System.out.print(table[i][j] + ",");
			}
			System.out.println();
		}
	}
}
