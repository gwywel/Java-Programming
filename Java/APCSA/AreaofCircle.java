import java.util.Scanner;

public class AreaofCircle{
  public static void main(String[] args) {
    System.out.println("What is your radius?");
    Scanner scan = new Scanner(System.in);
    int radius = scan.nextInt();
    System.out.println("The area is " + Math.PI * radius * radius);
  }
}
