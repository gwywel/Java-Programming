/*
* File: GenomeSearch1.java
* Description: This program reads two files, a genome sequence and a
* fragment as arguments. The index of the first occurence of the fragment
* within the genome sequence is recorded and reported to the user. If
* the fragment was not found, that is reported to the user. If there is
* an error in reading the file names, the user is alerted.
* This program will read in two files, the first containing a DNA fragment
* and the second containing the entire E. coli genome. Read the sequence
* from each file into a String variable, and then use indexOf to report
* whether the fragment is present in the genome.
*/

import java.util.Scanner;
import java.io.File;

public class GenomeSearch1 {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("You must specify 2 file names to run this program.");
      System.exit(1);
    }
    // read in the genome, timing the process
    long startTime = System.currentTimeMillis();
    String genome = readSequence(args[0]);
    double duration = (System.currentTimeMillis()-startTime)/1000.0;
    System.out.println(duration + " seconds to read the " + genome.length()
    + " nucleotides in the genome");

    // read in the fragment, timing the process
    startTime = System.currentTimeMillis();
    String fragment = readSequence(args[1]);
    duration = (System.currentTimeMillis()-startTime)/1000.0;
    System.out.println(duration + " seconds to read the " + fragment.length()
    + " nucleotides in the fragment");

    // find index of the fragment's first occurence
    int fragmentIndex = genome.indexOf(fragment);
    if (fragmentIndex != -1) {
      System.out.println("Fragment found at position " + fragmentIndex
      + " of the genome.");
    } else {
      System.out.println("The fragment was not found in the genome.");
    }
  }

  // method read file for sequence of nucleotides
  public static String readSequence(String filename) {
    String contents = "";
    try {
      Scanner scan = new Scanner(new File(filename));
      scan.nextLine();
      while (scan.hasNext()) {
        String line = scan.nextLine();
        if (line.length() == 0) break;
        contents += line;
      }
      scan.close();
    } catch (Exception ex) {
      System.out.println("Error reading sequence: java.io.FileNotFoundException: "
      + filename + " (No such file or directory)");
      System.exit(1);
    }
    return contents;
  }

}
