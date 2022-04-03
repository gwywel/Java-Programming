import java.util.ArrayList;

public class ScrambleString
{
   /** Scrambles a given word.
    *  @param word the word to be scrambled
    *  @return the scrambled word (possibly equal to word)
    *  Precondition: word is either an empty string or contains only uppercase letters.
    *  Postcondition: the string returned was created from word as follows:
    *   - the word was scrambled, beginning at the first letter and continuing from left to right
    *   - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
    *   - letters were swapped at most once
    */
    public static String scrambleWord(String word)
    {
        for (int i = 1; i < word.length(); i++){
            if (word.substring(i - 1, i).equals("A") &&
            !word.substring(i, i + 1).equals("A")){
                word = word.substring(0, i - 1)
                + word.substring(i , i + 1)
                + word.substring(i - 1, i)
                + word.substring(i + 1, word.length());
                i++;
            }
        }
        return word;
    }
 
    /** Modifies wordList by replacing each word with its scrambled version,
     *  removing any words that are unchanged as a result of scrambling.
     *  @param wordList the list of words
     *  Precondition: wordList contains only non-null objects
     *  Postcondition:
     *   - all words unchanged by scrambling have been removed from wordList
     *   - each of the remaining words has been replaced by its scrambled version
     *   - the relative ordering of the entries in wordList is the same as it was
     *     before the method was called.
     */
     public static void scrambleOrRemove(ArrayList<String> wordList)
     {
         String word;
         for (int i = wordList.size() - 1; i > -1; i--){
             word = scrambleWord(wordList.get(i));
             if (word.equals(wordList.get(i)))
             wordList.remove(i);
             else
             wordList.set(i, word);
            }
     }
     
     //Do not edit the main method.
     public static void main(String [] args)
     {
        ArrayList<String> words = new ArrayList<String>();
        words.add("TAN");
        words.add("ABRACADABRA");
        words.add("WHOA");
        words.add("AARDVARK");
        words.add("EGGS");
        words.add("A");
        words.add("");
        
        //Test TAN
        System.out.println("TESTING scrambleWord");
        System.out.println("Input: " + words.get(0));
        System.out.println("Output: " + scrambleWord(words.get(0)));
        if(scrambleWord(words.get(0)).equals("TNA"))
           System.out.println("Successful Test!");
        else
        {
           System.out.println("Test Unsuccessful");
           System.out.println("Expected Output: TNA");
        }  
        System.out.println();
        
        //TEST ABRACADABRA
        System.out.println("TESTING scrambleWord");
        System.out.println("Input: " + words.get(1));
        System.out.println("Output: " + scrambleWord(words.get(1)));
        if(scrambleWord(words.get(1)).equals("BARCADABARA"))
           System.out.println("Successful Test!");
        else
        {
           System.out.println("Test Unsuccessful");
           System.out.println("Expected Output: BARCADABARA");
        } 
        System.out.println();
        
        //TEST WHOA
                System.out.println("TESTING scrambleWord");
        System.out.println("Input: " + words.get(2));
        System.out.println("Output: " + scrambleWord(words.get(2)));
        if(scrambleWord(words.get(2)).equals("WHOA"))
           System.out.println("Successful Test!");
        else
        {
           System.out.println("Test Unsuccessful");
           System.out.println("Expected Output: WHOA");
        } 
        System.out.println();
        
        //TEST AARDVARK
        System.out.println("TESTING scrambleWord");
        System.out.println("Input: " + words.get(3));
        System.out.println("Output: " + scrambleWord(words.get(3)));
        if(scrambleWord(words.get(3)).equals("ARADVRAK"))
           System.out.println("Successful Test!");
        else
        {
           System.out.println("Test Unsuccessful");
           System.out.println("Expected Output: ARADVRAK");
        } 
        System.out.println();
        
        //TEST EGGS
        System.out.println("TESTING scrambleWord");
        System.out.println("Input: " + words.get(4));
        System.out.println("Output: " + scrambleWord(words.get(4)));
        if(scrambleWord(words.get(4)).equals("EGGS"))
           System.out.println("Successful Test!");
        else
        {
           System.out.println("Test Unsuccessful");
           System.out.println("Expected Output: EGGS");
        } 
        System.out.println();
        
        //TEST A
        System.out.println("TESTING scrambleWord");
        System.out.println("Input: " + words.get(5));
        System.out.println("Output: " + scrambleWord(words.get(5)));
        if(scrambleWord(words.get(5)).equals("A"))
           System.out.println("Successful Test!");
        else
        {
           System.out.println("Test Unsuccessful");
           System.out.println("Expected Output: A");
        } 
        System.out.println();
        
        //TEST EMPTY STRING
        System.out.println("TESTING scrambleWord");
        System.out.println("Input: " + words.get(6));
        System.out.println("Output: " + scrambleWord(words.get(6)));
        if(scrambleWord(words.get(6)).equals(""))
           System.out.println("Successful Test!");
        else
        {
           System.out.println("Test Unsuccessful");
           System.out.println("Expected Output: (Empty String)");
        } 
        
        System.out.println();
        //Test ScrambleOrRemove
        System.out.println("Testing ScrambleOrRemove");
        scrambleOrRemove(words);
        ArrayList<String> result = new ArrayList<String>();
        result.add("TNA");
        result.add("BARCADABARA");
        result.add("ARADVRAK");
        System.out.println("Expected Output: " + result);
        System.out.println("Output: " + words);
        
        boolean b = true;
        for(int i = 0; i<result.size(); i++)
        {
           if(!result.get(i).equals(words.get(i)))
              b = false;
        }
        
        if(b == false)
           System.out.println("Unsuccessful Test");
        else
           System.out.println("Test Successful!");
       
     }
    }