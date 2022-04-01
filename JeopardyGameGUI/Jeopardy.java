import java.awt.*;

public class Jeopardy extends EasyApp
{
  public static void main(String[] args)
  {  new Jeopardy(); }

  Label lJeopardy = addLabel("Jeopardy",150,30,200,60,this);

  Label lScoreA = addLabel("Player 1",50,100,50,30,this);
  TextField tScoreA = addTextField("0",100,100,80,30,this);

  Label lScoreB = addLabel("Player 2",300,100,50,30,this);
  TextField tScoreB = addTextField("0",350,100,80,30,this);

  Button bScience = addButton("Science 100",50,150,100,50,this);
  Button bScience2 = addButton("Science 200",50,200,100,50,this);
  Button bScience3 = addButton("Science 300",50,250,100,50,this);

  Button bTech = addButton("Tech 100",150,150,100,50,this);
  Button bTech2 = addButton("Tech 200",150,200,100,50,this);
  Button bTech3 = addButton("Tech 300",150,250,100,50,this);

  Button bHistory = addButton("History 100",250,150,100,50,this);
  Button bHistory2 = addButton("History 200",250,200,100,50,this);
  Button bHistory3 = addButton("History 300",250,250,100,50,this);

  Button bMath = addButton("Math 100",350,150,100,50,this);
  Button bMath2 = addButton("Math 200",350,200,100,50,this);
  Button bMath3 = addButton("Math 300",350,250,100,50,this);

  Button bPlayAgain = addButton("Play again",50,300,400,50,this);

  double scoreA = 0;
  double scoreB = 0;
  boolean move = true;
  boolean boolA = true;
  double points = 0;

  public void score(int points){
    if (boolA){
      scoreA += points;
    } else {
      scoreB += points;
    }
  }

  public Jeopardy()
  {
    setSize(500,500);
    setTitle("Jeopardy!");
    lJeopardy.setFont(new Font("Arial",1,36));
    lJeopardy.setBackground(new Color(255,255,180));
    lJeopardy.setForeground(Color.blue);
    lScoreA.setBackground(new Color(255,255,180));
    lScoreB.setBackground(new Color(255,255,180));
    setBackground(new Color(255,255,180));
    bScience.setFont(new Font("Arial",1,16));
    bScience2.setFont(new Font("Arial",1,16));
    bScience3.setFont(new Font("Arial",1,16));
    bMath.setFont(new Font("Arial",1,16));
    bMath2.setFont(new Font("Arial",1,16));
    bMath3.setFont(new Font("Arial",1,16));
    bHistory.setFont(new Font("Arial",1,16));
    bHistory2.setFont(new Font("Arial",1,16));
    bHistory3.setFont(new Font("Arial",1,16));
    bTech.setFont(new Font("Arial",1,16));
    bTech2.setFont(new Font("Arial",1,16));
    bTech3.setFont(new Font("Arial",1,16));
    bPlayAgain.setFont(new Font("Arial",1,16));
  }

  public void actions(Object source,String command)
  {
    if (source == bScience)
    {  science();}
    if (source == bTech)
    {  tech();}
    if (source == bHistory)
    {  history();}
    if (source == bMath)
    {  math();}
    if (source == bScience2)
    {  science2();}
    if (source == bTech2)
    {  tech2();}
    if (source == bHistory2)
    {  history2();}
    if (source == bMath2)
    {  math2();}
    if (source == bScience3)
    {  science3();}
    if (source == bTech3)
    {  tech3();}
    if (source == bHistory3)
    {  history3();}
    if (source == bMath3)
    {  math3();}
    if (source == bPlayAgain)
    {
      bScience.setEnabled(true);
      bHistory.setEnabled(true);
      bTech.setEnabled(true);
      bMath.setEnabled(true);

      bScience2.setEnabled(true);
      bHistory2.setEnabled(true);
      bTech2.setEnabled(true);
      bMath2.setEnabled(true);

      bScience3.setEnabled(true);
      bHistory3.setEnabled(true);
      bTech3.setEnabled(true);
      bMath3.setEnabled(true);

      scoreA = 0;
      scoreB = 0;
    }
    tScoreA.setText(scoreA + "");
    tScoreB.setText(scoreB + "");
  }

  public void science()
  {
    String guess = inputString("f = ma is a ________ law.  HINT: The first letter is 'p' and is 7 characters long.");
    String first3 = guess.substring(0,3);
    String last = guess.substring(guess.length() - 1);
    if (guess.equalsIgnoreCase("physics")
    || (first3.equalsIgnoreCase("phy") && last.equalsIgnoreCase("s")))
    {
      score(100);
      output("Right!");
    }
    else
    {
      score(-100);
      output("Wrong..." );
      boolA = !boolA;
    }
    bScience.setEnabled(false);
  }

  public void tech()
  {
    String guess = inputString("A computer mouse is an example of what?  HINT: The answer begins with 'i' and contains 12 characters.");
    String first3 = guess.substring(0,3);
    String last = guess.substring(guess.length() - 1);
    if (guess.equalsIgnoreCase("an input device")
    || guess.equalsIgnoreCase("input device")
    || (first3.equalsIgnoreCase("inp") && last.equalsIgnoreCase("e")))
    {
      score(100);
      output("Right!");
    }

    else
    {
      score(-100);
      output("Wrong...");
      boolA = !boolA;
    }
    bTech.setEnabled(false);
  }

  public void history()
  {
    int guess = inputInt("What year did WWII end?  HINT: The answer begins with '1' and contains 4 numbers.");
    if (guess == 1945)
    {
      score(100);
      output("Right!");
    }
    else
    {
      score(-100);
      output("Wrong... ");
      boolA = !boolA;
    }
    bHistory.setEnabled(false);
  }

  public void math()
  {
    int guess = inputInt("What is 5! ?  HINT: The answer begins with '1' and contains 3 numbers.");
    if (guess == 120)
    {
      score(100);
      output("Right!");
    }
    else
    {
      score(-100);
      output("Wrong...");
      boolA = !boolA;
    }
    bMath.setEnabled(false);
  }

  public void science2()
  {
    String guess = inputString("What functional group is found in hydrocarbons?  HINT: The answer begins with 'm' and contains 12 characters.");
    String first3 = guess.substring(0,3);
    String last = guess.substring(guess.length() - 1);
    if (guess.equalsIgnoreCase("a methyl group")
    || guess.equalsIgnoreCase("methyl group")
    || guess.equalsIgnoreCase("methyl")
    || (first3.equalsIgnoreCase("met") && last.equalsIgnoreCase("p")))
    {
      score(200);
      output("Right!");
    }
    else
    {
      score(-200);
      output("Wrong..." );
      boolA = !boolA;
    }
    bScience2.setEnabled(false);
  }

  public void tech2()
  {
    String guess = inputString("What does ROM stand for?  HINT: The answer begins with 'r' and contains 16 characters.");
    String first3 = guess.substring(0,3);
    String last = guess.substring(guess.length() - 1);
    if (guess.equalsIgnoreCase("Read Only Memory")
    || first3.equals("rea") && last.equals("y"))
    {
      score(200);
      output("Right!");
    }
    else
    {
      score(-200);
      output("Wrong... " );
      boolA = !boolA;
    }
    bTech2.setEnabled(false);
  }

  public void history2()
  {
    output("POISON QUESTION!  Minus 50 points, and you lose a turn.  Click OK to continue.");
    score(-50);
    bHistory2.setEnabled(false);
    boolA = !boolA;
  }

  public void math2()
  {
    int bet = inputInt("DAILY DOUBLE!  How much would you like to bet?");
    if ((boolA) && (bet > scoreA)
    || (!boolA) && (bet > scoreB))
    {
      output("You cannot bet more points than you have.");
      bMath2.setEnabled(true);
    } else {
      String guess = inputString("What is the derivative of 2x^2 + 7x + 2 ?  HINT: The answer begins with '4' and contains 6 characters.");
      if (guess.equalsIgnoreCase("4x + 7") || guess.equalsIgnoreCase("4x+7"))
      {
        score(bet);
        output("Right!");
      }
      else
      {
        score(-bet);
        output("Wrong...");
        boolA = !boolA;
      }
      bMath2.setEnabled(false);
    }
  }

  public void science3()
  {
    int guess = inputInt("Water freezes at how many degrees Fahrenheit?  HINT: The answer begins with a '3' and contains 2 characters.");
    if (guess == 32)
    {
      score(300);
      output("Right!");
    }
    else
    {
      score(-300);
      output("Wrong..." );
      boolA = !boolA;
    }
    bScience3.setEnabled(false);
  }

  public void tech3()
  {
    String guess = inputString("Who cracked the Enigma code?  HINT: The answer begins with 'A' and contains 11 characters.");
    String first3 = guess.substring(0,3);
    String last = guess.substring(guess.length() - 1);
    if (guess.equalsIgnoreCase("Alan Turing")
    || guess.equalsIgnoreCase("Turing")
    || (first3.equalsIgnoreCase("ala") && last.equalsIgnoreCase("g"))
    || (first3.equalsIgnoreCase("tur") && last.equalsIgnoreCase("g")))
    {
      score(300);
      output("Right!");
    }

    else
    {
      score(-300);
      output("Wrong...");
      boolA = !boolA;
    }
    bTech3.setEnabled(false);
  }

  public void history3()
  {
    String guess = inputString("What took place on Griffin's Wharf in America in 1773?  HINT: The answer begins with 'B' and contains 16 characters.");
    String first3 = guess.substring(0,3);
    String last = guess.substring(guess.length() - 1);
    if (guess.equalsIgnoreCase ("The Boston Tea Party")
    || guess.equalsIgnoreCase ("Boston Tea Party")
    || (first3.equalsIgnoreCase("bos") && last.equalsIgnoreCase("y")))
    {
      score(300);
      output("Right!");
    }
    else
    {
      score(-300);
      output("Wrong... ");
      boolA = !boolA;
    }
    bHistory3.setEnabled(false);
  }

  public void math3()
  {
    String guess = inputString("Which prime number does not have an 'e' in its name?  HINT: The answer begins with 't' and contains 3 characters.");
    if (guess.equalsIgnoreCase("two"))
    {
      score(300);
      output("Right!");
    }
    else
    {
      score(-300);
      output("Wrong...");
      boolA = !boolA;
    }
    bMath3.setEnabled(false);
  }
}
