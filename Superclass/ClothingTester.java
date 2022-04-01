public class ClothingTester{
  public static void main(String[]args){
    TShirt tShirt = new TShirt("Small", "White", "Cotton");
    System.out.println(tShirt);

    Sweatshirt sweatshirt = new Sweatshirt("Medium", "Black", false);
    System.out.println(sweatshirt);
    
    Sweatshirt sweatshirt2 = new Sweatshirt ("Petite", "Pink", true);
    System.out.println(sweatshirt2);

    Jeans jeans = new Jeans("Large");
    System.out.println(jeans);
  }
}
