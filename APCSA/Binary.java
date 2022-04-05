import java.util.*;
public class Binary {
  public static void main(String[] args){
    int binary[] = new int[100];
    System.out.println("Enter the number to be converted:");
    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    System.out.println("Base number type of entered number:");
    int base = scan.nextInt();
    int x = 0;
    if(base == 10){
      while(num > 0){
        binary[x++] = num % 2;
        num = num / 2;
      }
      System.out.print("Base 2 equivalent: ");
      for(int i = x - 1; i >= 0; i--){
        System.out.print(binary[i]);
      }
    }
    if(base == 2){
      int i = 0;
      int decimal = 0;
      while(num != 0){
        decimal += (num % 10) * Math.pow(2, i);
        num /= 10;
        i++;
      }
      System.out.print("Base 10 equivalent: ");
      System.out.print(decimal);
    }
  }
}
