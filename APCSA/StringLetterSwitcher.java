import java.util.*;

public class StringLetterSwitcher{
  public static void main(String[]args){
    System.out.println("Input a string with at least 3 characters.");
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();

    System.out.println("Input the character you would like to replace.");
    char character1 = scan.next().charAt(0);
    System.out.println("Input the character you would like to replace all instances of the first with.");
    char character2 = scan.next().charAt(0);

    System.out.println(str.replace((character1), (character2)));
  }
}
