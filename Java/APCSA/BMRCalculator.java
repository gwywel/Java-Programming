import java.util.*;

public class BMRCalculator{
  public static void main(String[] args){
    // BEGIN INPUT
    System.out.println("What is your gender? (Type M for Male or F for Female)");
    Scanner scan = new Scanner(System.in);
    String gender = scan.nextLine();

    System.out.println("What is your weight in pounds?");
    int weight = scan.nextInt();

    System.out.println("What is your height in inches?");
    int height = scan.nextInt();
    
    System.out.println("How old are you?");
    int age = scan.nextInt();
    // END INPUT

    String female = "F";
    String male = "M";

    // BEGIN OUTPUT
    if (male.equalsIgnoreCase(gender))
    System.out.println("Your BMR is " + ( ( 10 * weight ) + ( 6.25 * height ) - ( 5 * age ) + 5 ) + " calories." );
    else System.out.println("Your BMR is " + ( ( 10 * weight ) + ( 6.25 * height ) - ( 5 * age ) - 161 ) + " calories." );
    // END OUTPUT
  }
}
