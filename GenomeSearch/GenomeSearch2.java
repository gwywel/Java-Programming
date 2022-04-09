/*
* File: GenomeSearch2.java
* Description: This program reads each line in the genome file separately
* while storing information about the nucleotides seen so far via indices.
* The current indices of the line, genome, and fragment are stored and
* the genome and fragment indices are carried over each iteration of the
* while loop in the case that a fragment is split across separate lines.
* If the sequence is interrupted by a character that does match the nextLine
* one in the fragment, the fragment index is reset to zero and the search
* starts all over from the index in the genome where it left off. If a match
* is found, the index within the genome is starts at is reported to the user.
* If no match is found by the end of the search, that is reported to the user.
*
* This program will search for a DNA fragment in a genome with improved
* efficiency by first reading the DNA fragment and then scanning the genome
* line-by-line, looking for a match.
*/

import java.util.Scanner;
import java.io.File;

public class GenomeSearch2 {
  public static void main(String[] args) {

    if (args.length < 2) {
      System.out.println("You must specify 2 file names to run this program.");
      System.exit(1);
    }

    // read in the fragment
    long startTime = System.currentTimeMillis();
    String fragment = readSequence(args[1]);
    double duration = (System.currentTimeMillis()-startTime)/1000.0;
    System.out.println(duration + " seconds to read the fragment");

    // scan the genome, searching for fragment as you go
    startTime = System.currentTimeMillis();
    int foundIndex = positionInGenome(args[0], fragment);
    duration = (System.currentTimeMillis()-startTime)/1000.0;

    // report result
    if (foundIndex>=0) {
      System.out.println("Fragment found at index " + foundIndex + " in "
      + duration + " seconds");
    } else {
      System.out.println(duration + " seconds to read the genome; no match found");
    }
  }

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
      System.out.println("Error reading sequence: " + ex);
      System.exit(1);
    }
    return contents;
  }

  public static int positionInGenome(String genomeFilename, String fragment) {
    // initialize idices
    int genomeIndex = 0;
    int fragIndex = 0;
    int lineIndex = 0;
    try {
      Scanner scan = new Scanner(new File(genomeFilename));
      scan.nextLine();
      while (scan.hasNext()) {
        String line = scan.nextLine();
        lineIndex = 0; // reset line index to 0 for each line
        if (line.length() == 0) break; // if line contains no values, break
        while (fragIndex < fragment.length()) {
          if (line.charAt(lineIndex) == fragment.charAt(fragIndex)) {
            // increase each of the indices if a match is found
            genomeIndex++;
            fragIndex++;
            lineIndex++;
            if (fragIndex == fragment.length()) return (genomeIndex - fragIndex);
          } else {
            // increase the genome and line indices, but reset the fragment index to 0 if no match is found
            genomeIndex++;
            fragIndex = 0;
            lineIndex++;
          }
          if (lineIndex == line.length()) break; // if the end of the line is reached, break
        }
      }
      scan.close();
    } catch (Exception ex) {
      System.out.println("Error reading sequence: " + ex);
      ex.printStackTrace();
      System.exit(1);
    }
    return -1;
  }
}
