/*
* File: Sequences.java
* Description: This program will read in a sequence of nucleotides from a file.
* We assume the first line of the file is text to be ignored, and then the
* sequence is displayed on several consecutive lines, followed by a blank line.
* The program should terminate if the user does not specify a file, if the file
* does not exist, or if any other error occurs during file reading.
* After we've read the file, we will consider different approachs for
* searching for stop codons TAG, TAA, TGA.
*/

import java.util.Scanner;
import java.io.File;

public class Sequences {

  public static final String stopCodon = "TAG";

  public static void main(String[] args) {

    // check that the user has entered a filename
    if (args.length == 0) {
      System.out.println("No file specified");
      System.exit(1);
    }

    String filename = args[0]; // the name of the file containing the sequence
    System.out.println("You want to open the file: " + filename);

    // open the file and read the sequence in the file into a String
    try {
      // set up a scanner to read from the file
      Scanner input = new Scanner( new File(filename));

      // process the file
      input.nextLine(); // skip the first line
      String contents = ""; // set up empty string to store contents
      while (input.hasNext()) { // keep reading until end of file
        String line = input.nextLine(); // read next line in the file
        if (line.length()==0) break; // stop reading if you've reached a blank line
        contents += line; // add the new line to the contents
      }

      // print out contents
      System.out.println("Sequence: " + contents);

      // close the scanner
      input.close();
    } catch (Exception ex) {
      // handle exception
      System.out.println("Problem opening file");
      System.exit(1);
    }

  }

}
