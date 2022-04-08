import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class MultipleGroupsRunner
{
  public static void main(String[] args)
  {
    MultipleGroups it = new MultipleGroups();
    it.add( new Range( 5, 8 ) );
    it.add( new Range( 10, 12 ) );
    it.add( new Range( 1, 6) );

    System.out.println("MultipleGroups  -- calling toString");
    System.out.println( it );
    System.out.println( it );
    System.out.println( it );

    System.out.println("\n\nMultipleGroups -- calling contains");
    System.out.println( it.contains( 2 ) );		//true
    System.out.println( it.contains( 9 ) );		//false
    System.out.println( it.contains( 6 ) );		//true
  }
}
