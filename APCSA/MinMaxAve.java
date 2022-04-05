import java.util.*;
public class MinMaxAve{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    double integers;
    double sum = 0.0;
    double next;
    double min;
    double max;
    double average;

    System.out.println("Please enter the number of integers you would like to input.");
    integers = scan.nextDouble();
    System.out.println("Please input the integers with single spaces in between each and enter when complete.");
    next = scan.nextDouble();

    max = next;
    min = next;
    sum += next;

    for (int i = 1; i < integers; i++) {
      next = scan.nextDouble();
      if(next > max)
      max = next;
      if(next < max)
      min = next;
      sum = sum + next;
    }
    average = sum/integers;
    System.out.println("The minimum is: " + (int)min);
    System.out.println("The maximum is: " + (int)max);
    System.out.println("The average is: " + average);
  }
}
