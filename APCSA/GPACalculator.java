import java.util.Scanner;

public class GPACalculator{
  public static void main(String[] args) {
    System.out.println("What is your number of GPA points earned?");
    Scanner scan = new Scanner(System.in);
    int gpa = scan.nextInt();

    System.out.println("What is your number of credit hours attempted?");

    double hours = scan.nextDouble();

    System.out.println("Your GPA is: " + hours / gpa);
  }
}
