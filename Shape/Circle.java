public class Circle extends Ellipse{
  private double radius;
  public Circle(double radius){
    super("Circle", radius, radius);
    this.radius = radius;
  }
  public double getRadius(){
    return radius;
  }
  public String toString(){
    return "Circle radius : " + radius
    + "\nCircle perimeter: " + getPerimeter();
  }
  public double getPerimeter(){
    return 2 * Math.PI * radius;
  }
}
