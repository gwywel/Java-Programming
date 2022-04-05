import java.util.*;

public class Password{
  public static void main(String[] args){
    while (true) {
      Scanner scan = new Scanner(System.in);
      String password = "carrot";

      String inputtedPassword = scan.nextLine();
      System.out.println("Type the password:");

      if (password.equals(inputtedPassword)) {
        System.out.println("Right!");
      } else {
        System.out.println("Wrong!");
      }
      if (password.equals(inputtedPassword)) {
        break;
      }
    }
  }
}
