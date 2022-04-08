import static java.io.File.separator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class SquareTest {
  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(new File("magicData.txt"));
    int count = 1;
    int size = scan.nextInt();
    while (size != -1) {
      Square square = new Square(size);
      square.readSquare(scan);
      System.out.println("\n******** Square " + count + " ********");
      square.printSquare();
      for (int row = 0; row < size; row++) {
        System.out.println("The sum of row " + (row + 1) + " is "
        + square.sumRow(row));
      }
      for (int col = 0; col < size; col++) {
        System.out.println("The sum of col " + (col + 1) + " is "
        + square.sumCol(col));
      }
      System.out.println("The sum of main diagonal is "
      + square.sumMainDiag());
      System.out.println("The sum of the other diagonal is "
      + square.sumOtherDiag());
      System.out.println("The square "
      + ((square.magic()) ? "is " : "is not ")
      + "a magic square.");
      size = scan.nextInt();
      count++;
    }
  }
}
