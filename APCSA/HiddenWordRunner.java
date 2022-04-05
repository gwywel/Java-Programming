import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class HiddenWordRunner
{
  public static void main(String[] args)
  {
    HiddenWord it = new HiddenWord("HARPS");

    System.out.println("\n\nHiddenWord  --  calling toString");
    System.out.println( it );
    System.out.println("\n\nHiddenWord  --  calling getHint");
    System.out.println( it.getHint("AAAAA") );
    System.out.println( it.getHint("HELLO") );
    System.out.println( it.getHint("HEART") );
    System.out.println( it.getHint("HARMS") );
    System.out.println( it.getHint("HARPS") );
    System.out.println( it.getHint("APLUS") );
    System.out.println( it.getHint("DOGS4") );
    System.out.println( it.getHint("ZEBRA") );
    System.out.println( it.getHint("ZZZZZ") );

    /*
    OUTPUT

    HiddenWord  --  calling toString
    HARPS

    HiddenWord  --  calling getHint
    +A+++
    H****
    H*++*
    HAR*S
    HARPS
    ++**S
    ***+*
    ***++
    *****
    */
  }
}
