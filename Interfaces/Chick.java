public class Chick implements Animal{
    private String myType;
    private String mySound;
    private boolean cheepCluck;
    Chick(){
        myType = "chick";
        mySound = "cheep";
    }
    public Chick(boolean c){
        myType = "chick";
        cheepCluck = c;
    }
    public String getSound(){
        if (cheepCluck == true){
            int temp = (int)(Math.random() * 2);
            if (temp == 1)
                mySound = "cheep";
            else
                mySound = "cluck";
            }
        else 
            mySound = "cheep";
        return mySound;
    }
    public String getType(){
        return myType;
    }
}