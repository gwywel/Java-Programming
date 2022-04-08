import java.util.List;
import java.util.ArrayList;

public class MultipleGroups implements NumberGroup
{
  private List<NumberGroup> groupList;

  public MultipleGroups( )
  {
    groupList = new ArrayList<NumberGroup>();
  }

  public void add( NumberGroup item )
  {
    groupList.add(item);
  }

  public boolean contains( int val )
  {
    for(NumberGroup y : groupList){
      if(y.contains(val)){
        return true;
      }
    }
    return false;
  }

  public String toString()
  {
    return "" + groupList;
  }
}
