public class OldMacDonald{
    public static void main(String[]args){
        Cow c = new Cow();
        System.out.println(c.getType() + " goes " + c.getSound());
        
        Chick chick = new Chick();
        System.out.println(chick.getType() + " goes " + chick.getSound());
        
        Pig p = new Pig();
        System.out.println(p.getType() + " goes " + p.getSound());
        
        Farm farm = new Farm();
        farm.animalSounds();
    }
}