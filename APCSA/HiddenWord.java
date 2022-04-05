public class HiddenWord{
  private String word;
  public HiddenWord( String w ){
    word = w;
  }
  public String getHint( String guess ){
    String ret = "";
    for(int i = 0; i < word.length(); i++){
      String g = guess.substring(i, i + 1);
      if(word.substring(i, i + 1).equals(g)){
        ret = ret + g;
      }
      else if(word.indexOf(g) != -1){
        ret = ret + "+";
      }
      else{
        ret = ret + "*";
      }
    }
    return ret;
  }
  public String toString(){
    return "" + word;
  }
}
