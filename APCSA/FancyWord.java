import java.util.List;

public class FancyWord
{
  public static String scrambleWord( String word )
  {
    for(int i = 0; i < word.length() - 1; i++){
      if("A".equals(word.substring(i, i + 1))
      && !"A".equals(word.substring(i + 1, i + 2))){
        word = word.substring(0, i)
        + word.substring(i + 1, i + 2)
        + word.substring(i, i + 1)
        + word.substring(i + 2);
        i++;
      }
    }
    return word;
  }

  public static void scrambleOrRemove( List<String> wordList )
  {
    for(int i = wordList.size() - 1; i >= 0; i--){
      String word = wordList.get(i);
      if(word.equals(scrambleWord(word))){
        wordList.remove(i);
      }
    }
  }
}
