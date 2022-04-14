/*
* Description: This program reads a sequence of proteins and converts them
* into an RNA sequence of codons that match with the protein. The RNA is
* then converted to DNA by replacing the uracil nucleotides with thymine. The
* resulting DNA strand is then given a complement, which matches adenine to
* thymine and guanine to cytosine. The resulting strands are printed to the
* console.
*/

import java.util.Scanner;
import java.io.File;

public class F3BioCS {

  /* table of amino acids and RNA */
  public static final String[][] AA_TO_RNA = {{"Phe","UUU"},{"Leu","UUA"},
  {"Ser","UCU"},{"Tyr","UAU"},{"Cys","UGU"},{"Trp","UGG"},{"Leu","CUU"},
  {"Pro","CCU"},{"His","CAU"},{"Gln","CAA"},{"Arg","CGU"},{"Ile","AUU"},
  {"Met","AUG"},{"Thr","ACU"},{"Asn","AAU"},{"Lys","AAA"},{"Ser","AGU"},
  {"Arg","AGA"},{"Val","GUU"},{"Ala","GCU"},{"Asp","GAU"},{"Glu","GAA"},
  {"Gly","GGU"}};

  public static void main(String[] args) {
    String sequence = readSequence(args[0]); // store read sequence as a string
    String rna = proteinToRNA(sequence); // convert sequence to RNA
    String dna = RNAtoDNA(rna); // convert RNA to DNA
    System.out.println(dna); // print DNA
    System.out.println(makeComplement(dna)); // make DNA complement and print
  }

  /* converts 3-letter protein sequence to RNA codons and concatenates them */
  public static String proteinToRNA(String sequence) {
    int index = 0;
    String protein = "";
    String codon = "";
    String rna = "";
    while (index < sequence.length()) {
      protein = sequence.substring(index, index+3); // get single protein
      for (int i = 0; i < AA_TO_RNA.length; i++) {
        if (protein.equals(AA_TO_RNA[i][0])) { // match protein with table
          codon = AA_TO_RNA[i][1]; // store the found codon
        }
      }
      rna += codon; // concatenate codon to RNA strand
      index += 4; // increment index to the first character of the next protein
    }
    return rna;
  }

  /* iterates through all nucleotides in RNA and changes all uracil nucleotides
  to thymine nucleotides to make DNA */
  public static String RNAtoDNA(String rna) {
    String dna = "";
    for (int i = 0; i < rna.length(); i++) { // iterates through RNA strand
      if (rna.charAt(i) == 'U') { // if the nucleotide is uracil...
        dna += 'T'; // it becomes thymine
      } else {
        dna += rna.charAt(i); // otherwise, the nucleotide remains the same
      }
    }
    return dna;
  }

  /* create a complement strand by converting nucleotides to their complement */
  public static String makeComplement(String dna) {
    String complement = "";
    for (int i = 0; i < dna.length(); i++) {
      /* convert A's to T's and vice versa */
      if (dna.charAt(i) == 'A') {
        complement += 'T';
      } else if (dna.charAt(i) == 'T') {
        complement += 'A';
        /* convert G's to C's and vice versa */
      } else if (dna.charAt(i) == 'G') {
        complement += 'C';
      } else {
        complement += 'G';
      }
    }
    return complement;
  }

  /* scan single-lined file containing protein sequence */
  public static String readSequence(String filename) {
    String s = "";
    try {
      Scanner scan = new Scanner(new File(filename));
      s = scan.nextLine(); // store first line of file
      scan.close(); // close scanner
    } catch (Exception ex) {
      System.out.println(ex); // print exception if necessary
      System.exit(1); // exit if there is an exception
    }
    return s;
  }

}
