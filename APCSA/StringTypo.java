import java.util.*;

public class StringTypo{
  public static void main(String[]args){
    System.out.println("Input a string with at least 3 characters.");
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();

    int max = str.length();
    int min = 0;

    double rand = Math.random() * max - min;

    System.out.println(str.substring(0,((int)rand-1))+(str.substring((int)rand)));
  }
}
