public class Sweatshirt extends Clothing{
  private boolean hood;
  public Sweatshirt(String size, String color, boolean hood){
    super(size, color);
    this.hood = hood;
  }
  public boolean hasHood(){
    return this.hood;
  }
  public String toString(){
    if (hood == false)
    return "It is a size " + size + ", " 
    + color + " sweatshirt. It does not have a hood.";
    else
    return "It is a size " + size + ", "
    + color + " sweatshirt. It has a hood.";
  }
}
