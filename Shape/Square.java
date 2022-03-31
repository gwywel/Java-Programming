public class Square extends Rectangle{
  private double sideLength;
  public Square(double sideLength){
    super("Square", sideLength, sideLength);
    this.sideLength = sideLength;
  }
  public String toString(){
    return "Square side length: " + sideLength
    + "\nSquare perimeter: " + getPerimeter();
  }
  public double getPerimeter(){
    return 4 * sideLength;
  }
}
