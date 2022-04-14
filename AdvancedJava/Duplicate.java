/*
* File: Duplicate.java
* Description: This program reads a positive integer n followed by a list of doubles
* and produces a list with each entry replaced by n copies of that entry.
*/
import java.util.Arrays;

public class Duplicate {

	public static void main(String[] args) {

		double[] numbers = new double[args.length];
		for (int i=0; i<args.length; i++) {
			numbers[i] = Double.parseDouble(args[i]);
		}
		
		// cast first value in numbers as an int
		int n = (int) numbers[0];
		// create array with appropriate length
		double[] dup = new double[(numbers.length - 1) * n];

		int dupIndex = 0;

		// iterate through numbers, excluding the first value
		for (int j = 1; j < numbers.length; j++) {
			for (int k = 0; k < n; k++) {
				// increase index n times as values from numbers are assigned n times
				dup[dupIndex] = numbers[j];
				dupIndex++;
			}
		}

		// print result
		System.out.println(Arrays.toString(dup));

	}


}
