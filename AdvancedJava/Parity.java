/*
* File: Parity.java
* Description: This program reads a list of ints and separates them into two lists,
* representing the even and odd numbers in the array, respectively.
*/

import java.util.Arrays;

public class Parity {

	public static void main(String[] args) {

		int[] numbers = new int[args.length];
		for (int i=0; i<args.length; i++) {
			numbers[i] = Integer.parseInt(args[i]);
		}

		// initialize counters for number of evens and odds
		int evensCount = 0;
		int oddsCount = 0;

		// iterate through numbers array, adding to even/odd counters
		for (int k = 0; k < numbers.length; k++) {
			if (numbers[k] % 2 != 0) {
				oddsCount++;
			} else {
				evensCount++;
			}
		}

		// initialize arrays with appropriate size
		int[] evens = new int[evensCount];
		int[] odds = new int[oddsCount];

		int indexOdd = 0;
		int indexEven = 0;

		// iterate through numbers, advancing index of evens and odds as ints are inserted into array
		for (int h = 0; h < numbers.length; h++) {
			if (numbers[h] % 2 != 0) {
				odds[indexOdd] = numbers[h];
				indexOdd++;
			} else {
				evens[indexEven] = numbers[h];
				indexEven++;
			}
		}

		// print results
		System.out.print("Evens: ");
		System.out.println(Arrays.toString(evens));
		System.out.print("Odds: ");
		System.out.println(Arrays.toString(odds));

	}


}
