/*
* File: Bacteria.java
* Description: This program simulates and tracks a population of reproducing bacteria,
* some of which contain a mutation that makes them better at reproduction. The
* simulation data is stored in a 2-dimensional array as it is generated, and then it
* is outputted as a .csv file that illustrates how the proportion of mutated bacteria
* changes with time.
*/

import java.util.*;

public class Bacteria {

  public static void main(String[] args) {

    // parse args array into appropriate data types
    int generations = Integer.parseInt(args[0]);
    int nonMutated = Integer.parseInt(args[1]);
    int mutated = Integer.parseInt(args[2]);
    double p = Double.parseDouble(args[3]);
    double q = Double.parseDouble(args[4]);

    // put initial values into the two-dimensional array
    double table[][] = new double[generations][3];
    table[0][0] = (int) nonMutated;
    table[0][1] = (int) mutated;
    table[0][2] = mutated / (nonMutated + mutated);

    double flip = 0;

    // print first row
    System.out.println( (int) table[0][0] + ", " + (int) table[0][1] + ", " + (table[0][1]) / (table[0][0] + table[0][1]));

    for (int i = 0; i < generations - 1; i++) {

      // reset the number of non-mutated and mutated children to 0
      int nonMutatedChildren = 0;
      int mutatedChildren = 0;

      // flip one coin for each non-mutated bacteria and count the number of children
      for (int j = 0; j < table[i][0]; j++) {
        flip = Math.random();
        if (flip <= p) {
          nonMutatedChildren++;
        }
      }

      // flip one coin for each mutated bacteria and count the number of children
      for (int k = 0; k < table[i][1]; k++) {
        flip = Math.random();
        if (flip <= q) {
          mutatedChildren++;
        }
      }

      // write changes to the next row
      table[i+1][0] = table[i][0] + nonMutatedChildren;
      table[i+1][1] = table[i][1] + mutatedChildren;
      table[i+1][2] = (table[i+1][1]) / (table[i+1][0] + table[i+1][1]);

      // print results to the console
      System.out.println( (int) table[i+1][0] + ", " + (int) table[i+1][1] + ", " + table[i+1][2]);

    }
  }
}
